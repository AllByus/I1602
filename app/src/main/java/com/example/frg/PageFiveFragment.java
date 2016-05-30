package com.example.frg;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
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
 * {@link PageFiveFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageFiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFiveFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private GridView gridView;
    private List<PageData.DataBean.ProductsBean> productsBeen = new ArrayList<>();
    private MyAdapter myAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String url;

    private OnFragmentInteractionListener mListener;

    public PageFiveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageFiveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageFiveFragment newInstance(String param1, String param2) {
        PageFiveFragment fragment = new PageFiveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_five, container, false);

        Bundle arguments = getArguments();
        int position = arguments.getInt("position", 1);
        Log.d("ld-------", "position ="+position);
        switch (position){
            case 0:
                url="http://apicn.seashellmall.com/product/topic/7/products?size=20&p=1";
                break;
            case 1:
                url="http://apicn.seashellmall.com/product/topic/1/products?size=20&p=1";
                break;
            case 2:
                url="http://apicn.seashellmall.com/product/topic/2/products?size=20&p=1";
                break;
            case 3:
                url="http://apicn.seashellmall.com/product/topic/3/products?size=20&p=1";
                break;
            case 4:
                url="http://apicn.seashellmall.com/product/topic/4/products?size=20&p=1";
                break;
            case 5:
                url="http://apicn.seashellmall.com/product/topic/5/products?size=20&p=1";
                break;
            case 6:
                url="http://apicn.seashellmall.com/product/topic/6/products?size=20&p=1";
                break;
        }


        gridView = (GridView) view.findViewById(R.id.GridView_page5);
        myAdapter = new MyAdapter(getActivity());
        gridView.setAdapter(myAdapter);
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
                view = LayoutInflater.from(context).inflate(R.layout.show_goods,null);
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
            return view;
        }

        class ViewHodler {
            public TextView discount;
            public TextView price;
            private ImageView productImage;

            public ViewHodler(View view) {
                price = (TextView) view.findViewById(R.id.tv_price);
                productImage = (ImageView) view.findViewById(R.id.iv_home_show_pic);
                discount = (TextView)view.findViewById(R.id.tv_discounts);
            }
        }
    }
}
