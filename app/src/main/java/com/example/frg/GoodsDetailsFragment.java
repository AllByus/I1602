package com.example.frg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.helloworld.R;
import com.example.bean.Goods;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsDetailsFragment extends Fragment {


    public GoodsDetailsFragment() {
        // Required empty public constructor
    }

    public static GoodsDetailsFragment newInstance(List<Goods.DataBean.ProductBean> data) {

        Bundle args = new Bundle();
        String name = data.get(0).getName();
        String desc = data.get(0).getDesc();
        args.putString("name",name);
        args.putString("desc",desc);

        GoodsDetailsFragment fragment = new GoodsDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String name=bundle.getString("name");
        String desc=bundle.getString("desc");

        View view = inflater.inflate(R.layout.fragment_goods_details, container, false);

        TextView tvName= (TextView) view.findViewById(R.id.tv_details_name);
        TextView tvDesc= (TextView) view.findViewById(R.id.tv_details_desc);
        // tvName.setText(name);
        tvDesc.setText(desc);


        return view;
    }

}
