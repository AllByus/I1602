package com.example.administrator.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.bean.Goods;
import com.example.bitmap.ImageLoader;
import com.example.frg.GoodsDetailsFragment;
import com.example.frg.GoodsOtherFragment;
import com.example.http.HttpUtil;
import com.example.http.IRequestCallBack;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends AppCompatActivity {
    private int id;
    private List<Goods.DataBean.ProductBean> data = new ArrayList<>();
    private ImageView iv;
    private TextView tvName,tvRelprice,tvPrice,tvLocation,tvdiscount;
    private RatingBar rbar;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",1);
        Log.d("iiiii", "onCreate: "+id);
        initView();
        initData();
    }

    private void initData() {
        HttpUtil.requestGet("http://apicn.seashellmall.com/product/sku/"+id, new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Goods goods = gson.fromJson(result, Goods.class);
                data.add(goods.getData().getProduct());
                ImageLoader.loadImage(GoodsActivity.this,data.get(0).getImages().get(0).getUrl(),iv);
                tvName.setText(data.get(0).getName());
                rbar.setProgress(data.get(0).getScore());
                int realPrice = data.get(0).getSkus().get(0).getReal_price().getCNY();
                int x1=realPrice/100;
                int y1=realPrice%100;
                float price=x1+y1*0.01f;
                tvRelprice.setText("￥ "+price);
                int Price = data.get(0).getSkus().get(0).getList_price().getCNY();
                int x=Price/100;
                int y=Price%100;
                float price1=x+y*0.01f;
                tvPrice.setText("￥ "+price1);
                tvLocation.setText("物流   "+"从"+data.get(0).getLocation()+"发货");
                int discount = 100-data.get(0).getCurrent_sku().getDiscount();
                tvdiscount.setText(discount/10+discount%10*0.1+" 折");
                transaction=manager.beginTransaction();
                transaction.replace(R.id.fraglay_goods, GoodsDetailsFragment.newInstance(data));
                transaction.commit();
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        transaction=manager.beginTransaction();
                        switch (checkedId){
                            case R.id.rbtn_goods_details:
                                transaction.replace(R.id.fraglay_goods, GoodsDetailsFragment.newInstance(data));
                                break;
                            case R.id.rbtn_goods_other:
                                transaction.replace(R.id.fraglay_goods, GoodsOtherFragment.newInstance(data));
                                break;
                        }
                        transaction.commit();
                    }
                });
            }
        });

    }

    private void initView() {
        iv= (ImageView) findViewById(R.id.iv_goods);
        tvName = (TextView) findViewById(R.id.tv_goods_name);
        rbar= (RatingBar) findViewById(R.id.rbar_goods);
        tvRelprice= (TextView) findViewById(R.id.tv_goods_relprice);
        tvPrice= (TextView) findViewById(R.id.tv_goods_price);
        tvLocation= (TextView) findViewById(R.id.tv_goods_location);
        tvdiscount= (TextView) findViewById(R.id.tv_goods_discount);
        rg = (RadioGroup) findViewById(R.id.rg_goods);
        manager=getSupportFragmentManager();
    }
}
