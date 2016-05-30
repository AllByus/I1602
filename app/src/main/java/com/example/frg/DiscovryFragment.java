package com.example.frg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.helloworld.R;
import com.example.bean.Discovery;
import com.example.bitmap.ImageLoader;
import com.example.http.HttpUtil;
import com.example.http.IRequestCallBack;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiscovryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiscovryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscovryFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ListView lview;
    private List<Discovery.DataBean.TopicsBean> topicsBeen = new ArrayList<>();
    private  DisAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DiscovryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscovryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscovryFragment newInstance(String param1, String param2) {
        DiscovryFragment fragment = new DiscovryFragment();
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
        View view = inflater.inflate(R.layout.fragment_discovry, container, false);
        lview= (ListView) view.findViewById(R.id.lv_discovry);
        adapter = new DisAdapter(getActivity());
        lview.setAdapter(adapter);


        HttpUtil.requestGet("http://apicn.seashellmall.com/product/topics", new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Discovery discovery = gson.fromJson(result, Discovery.class);
                topicsBeen.addAll(discovery.getData().getTopics());
                adapter.notifyDataSetChanged();
            }
        });

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentInteraction("参数" ,position);
            }
        });
        return view;
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


    class DisAdapter extends BaseAdapter {

        private Context context;

        public DisAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return topicsBeen == null ? 0:topicsBeen.size();
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
                view = LayoutInflater.from(context).inflate(R.layout.show_dis,null);
                viewHodler = new ViewHodler(view);
                view.setTag(viewHodler);
            } else {
                viewHodler = (ViewHodler) view.getTag();
            }


            Discovery.DataBean.TopicsBean topicsBean = topicsBeen.get(position);
            viewHodler.titleTxt.setText(topicsBean.getTitle());
            String url = topicsBean.getImage();
            //滚动的时候，设置默认图
            viewHodler.productImage.setImageResource(R.mipmap.ic_launcher);
            viewHodler.productImage.setTag(url);
            ImageLoader.loadImage(context,url,viewHodler.productImage);
            return view;
        }

        class ViewHodler {
            public TextView titleTxt;
            private ImageView productImage;

            public ViewHodler(View view) {
                titleTxt = (TextView) view.findViewById(R.id.tv_dis);
                productImage = (ImageView) view.findViewById(R.id.iv_dis);
            }
        }
    }



}
