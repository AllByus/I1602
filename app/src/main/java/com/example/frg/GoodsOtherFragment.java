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
public class GoodsOtherFragment extends Fragment {


    public GoodsOtherFragment() {
        // Required empty public constructor
    }

    public static GoodsOtherFragment newInstance(List<Goods.DataBean.ProductBean> data) {

        Bundle args = new Bundle();
        String location = data.get(0).getLocation();
        args.putString("location",location);
        String name = data.get(0).getMerchant().getName();
        args.putString("name",name);
        int score = data.get(0).getMerchant().getScore();
        args.putInt("score",score);
        String goodsname = data.get(0).getName();
        args.putString("goodsname",goodsname);
        int reviewcount = data.get(0).getReview_count();
        args.putInt("reviewcount",reviewcount);
        int goodscore = data.get(0).getScore();
        args.putInt("goodscore",goodscore);
        GoodsOtherFragment fragment = new GoodsOtherFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        String name = bundle.getString("name");
        String location = bundle.getString("location");

        int score = bundle.getInt("score");

        String goodsname = bundle.getString("goodsname");

        int reviewcount = bundle.getInt("reviewcount");

        int goodscore =bundle.getInt("goodscore");
        View view =inflater.inflate(R.layout.fragment_goods_other, container, false);

        TextView tvlocation = (TextView) view.findViewById(R.id.tv_other_location);
        tvlocation.setText(location);

        TextView tvname = (TextView) view.findViewById(R.id.tv_other_name);
        tvname.setText(name);

        TextView tvscore = (TextView) view.findViewById(R.id.tv_other_score);
        tvscore.setText(score+"");

        TextView tvgscore = (TextView) view.findViewById(R.id.tv_other_goodscore);
        tvgscore.setText(goodscore+"");

        TextView tvgname = (TextView) view.findViewById(R.id.tv_other_goodsname);
        tvgname.setText(goodsname);

        TextView tvreviewcount = (TextView) view.findViewById(R.id.tv_other_reviewcount);
        tvreviewcount.setText(reviewcount+"");

        return view;
    }

}
