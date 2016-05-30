package com.example.administrator.helloworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.example.bean.ProduactInfo;
import com.example.bitmap.ImageLoader;
import com.example.http.HttpUtil;
import com.example.http.IRequestCallBack;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SlidingPaneLayout mSlidingLayout;
    private Toolbar mToolBar;
    private  ImageView imageView;
    private MaterialMenuDrawable materialMenuDrawable;
    private LinearLayout lldis,llfirst,llorder,llchoose,llset,llhelp;

    private GridView gridView;
    private List<ProduactInfo.DataEntity.ProductsEntity> productsEntities = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolBar();
        lldis = (LinearLayout) findViewById(R.id.ll_dis);
        llfirst = (LinearLayout) findViewById(R.id.ll_first);
        llorder = (LinearLayout) findViewById(R.id.ll_order);
        imageView = (ImageView) findViewById(R.id.iv_search);
        llchoose= (LinearLayout) findViewById(R.id.ll_choose);
        llset= (LinearLayout) findViewById(R.id.ll_set);
        llhelp= (LinearLayout) findViewById(R.id.ll_help);
        mSlidingLayout = (SlidingPaneLayout) findViewById(R.id.sliding_layout);
        lldis.setOnClickListener(this);
        llfirst.setOnClickListener(this);
        llorder.setOnClickListener(this);
        llchoose.setOnClickListener(this);
        imageView.setOnClickListener(this);
        llset.setOnClickListener(this);
        llhelp.setOnClickListener(this);

        gridView = (GridView) findViewById(R.id.GridView1);
        myAdapter = new MyAdapter(this);
        gridView.setAdapter(myAdapter);

        HttpUtil.requestGet("http://apicn.seashellmall.com/product/list/?size=20&p=1", new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ProduactInfo produactInfo = gson.fromJson(result, ProduactInfo.class);
                productsEntities.addAll(produactInfo.getData().getProducts());
                myAdapter.notifyDataSetChanged();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int num = productsEntities.get(position).getCurrent_sku().getId();
                Intent intent = new Intent(MainActivity.this, GoodsActivity.class);
                intent.putExtra("id",num);
                startActivity(intent);
            }
        });

    }

    private void setupToolBar() {

        mToolBar = (Toolbar) findViewById(R.id.home_tool_bar);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSlidingLayout.isOpen()) {
                    mSlidingLayout.closePane();
                } else {
                    mSlidingLayout.openPane();
                }
            }
        });

        //替换箭头图标
        materialMenuDrawable = new MaterialMenuDrawable(this, Color.BLACK, MaterialMenuDrawable.Stroke.THIN);
        mToolBar.setNavigationIcon(materialMenuDrawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_dis:
            Intent intent = new Intent(this, DisActivity.class);
            startActivity(intent);
                break;
            case R.id.ll_first:
                if (mSlidingLayout.isOpen()) {
                    mSlidingLayout.closePane();
                } else {
                    mSlidingLayout.openPane();
                }
                break;
            case R.id.ll_order:
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                break;
            case  R.id.iv_search:
                Intent intent2 = new Intent(this, SearchActivity.class);
                startActivity(intent2);
                break;
            case  R.id.ll_choose:
                Intent intent3 = new Intent(this, ListActivity.class);
                startActivity(intent3);
                break;
            case  R.id.ll_set:
                Intent intent4 = new Intent(this, SetActivity.class);
                startActivity(intent4);
                break;
            case  R.id.ll_help:
                Intent intent5 = new Intent(this, HelpActivity.class);
                startActivity(intent5);
                break;

        }
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


            ProduactInfo.DataEntity.ProductsEntity productsEntity = productsEntities.get(position);
            double real = productsEntity.getCurrent_sku().getReal_price().getCNY()/100;
            double list = productsEntity.getCurrent_sku().getList_price().getCNY()/100;
            viewHodler.price.setText("￥"+String.valueOf(real));
            DecimalFormat df = new DecimalFormat("#.0");
            String format = df.format((real / list)*10);
            viewHodler.discount.setText(format+"折");
            String url = productsEntity.getImages().get(0).getUrl();
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
