package com.example.administrator.helloworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.example.bean.ShowData;
import com.example.bitmap.ImageLoader;
import com.example.http.HttpUtil;
import com.example.http.IRequestCallBack;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShowSearchActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private  ImageView imageView;

    private MaterialMenuDrawable materialMenuDrawable;
    private GridView gridView;
    private List<ShowData.DataBean.ProductsBean> productsEntities = new ArrayList<>();
    private MyAdapter myAdapter;
    private TextView textview;
    private  String encode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_search);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        textview = (TextView) findViewById(R.id.titlt_search);
        textview.setText(message);
        setupToolBar();
        gridView = (GridView) findViewById(R.id.GridView_show_list_search);
        myAdapter = new MyAdapter(this);
        gridView.setAdapter(myAdapter);
        try {
            encode = URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        HttpUtil.requestGet("http://apicn.seashellmall.com/search/product/?q="+encode +"&size=20", new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ShowData showData = gson.fromJson(result, ShowData.class);
                Log.d("ld-----", showData.toString());
                productsEntities.addAll(showData.getData().getProducts());
                myAdapter.notifyDataSetChanged();
            }
        });



    }


    private void setupToolBar() {

        mToolBar = (Toolbar) findViewById(R.id.search_tool_bar);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);

        //替换箭头图标
        materialMenuDrawable = new MaterialMenuDrawable(this, Color.BLACK, MaterialMenuDrawable.Stroke.THIN);
        mToolBar.setNavigationIcon(materialMenuDrawable);
    }
    class MyAdapter extends BaseAdapter {

        private Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return productsEntities == null ? 0:productsEntities.size();
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


            ShowData.DataBean.ProductsBean productsBean = productsEntities.get(position);
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
