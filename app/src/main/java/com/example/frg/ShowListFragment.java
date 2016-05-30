package com.example.frg;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.helloworld.R;
import com.example.bean.PageData;
import com.example.bitmap.ImageLoader;
import com.example.http.HttpUtil;
import com.example.http.IRequestCallBack;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ListView listView;
    private List<PageData.DataBean.ProductsBean> productsBeen = new ArrayList<>();
    private MyAdapter myAdapter;

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;

    private OnFragmentInteractionListener mListener;

    public ShowListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment ShowListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowListFragment newInstance(int num, int num2) {
        ShowListFragment fragment = new ShowListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, num);
        args.putInt(ARG_PARAM2, num2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_show_list, container, false);
        listView = (ListView) view.findViewById(R.id.lv_detail);
        myAdapter = new MyAdapter(getActivity());
        listView.setAdapter(myAdapter);
        String url = "http://apicn.seashellmall.com/product/list/"+mParam1+"-"+mParam2+"?size=20&p=1";

        HttpUtil.requestGet(url, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                PageData pageData = gson.fromJson(result, PageData.class);
                productsBeen.addAll(pageData.getData().getProducts());
                myAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    class MyAdapter extends BaseAdapter {

        private Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return productsBeen == null ? 0:productsBeen.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHodler viewHodler = null;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.show_list,null);
                viewHodler = new ViewHodler(view);
                view.setTag(viewHodler);
            } else {
                viewHodler = (ViewHodler) view.getTag();
            }


            PageData.DataBean.ProductsBean productsBean = productsBeen.get(position);
            double real = productsBean.getCurrent_sku().getReal_price().getCNY()/100;
            double list = productsBean.getCurrent_sku().getList_price().getCNY()/100;
            viewHodler.price.setText("￥"+String.valueOf(real));
            DecimalFormat df = new DecimalFormat("#.0");
            String format = df.format((real / list)*10);
            viewHodler.discount.setText(format+"折");
            String url = productsBean.getImages().get(0).getUrl();
            //滚动的时候，设置默认图
            viewHodler.productImage.setImageResource(R.mipmap.ic_launcher);
            viewHodler.productImage.setTag(url);
            ImageLoader.loadImage(context,url,viewHodler.productImage);
            String name = productsBean.getName();
            viewHodler.title.setText(name);
            return view;
        }

        class ViewHodler {
            protected TextView title;
            public TextView discount;
            public TextView price;
            private ImageView productImage;

            public ViewHodler(View view) {
                title = (TextView) view.findViewById(R.id.tv_detail_title);
                price = (TextView) view.findViewById(R.id.tv_detail_price);
                productImage = (ImageView) view.findViewById(R.id.iv_detail_show_pic);
                discount = (TextView)view.findViewById(R.id.tv_discounts_detail);
            }
        }
    }
}
