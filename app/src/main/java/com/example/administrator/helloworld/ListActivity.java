package com.example.administrator.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bean.Sorted;
import com.example.bitmap.ImageLoader;
import com.example.http.HttpUtil;
import com.example.http.IRequestCallBack;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView,listView1;
    private List<Sorted.DataBean.CategoriesBean> categoriesBeen = new ArrayList<>();
    private List<Sorted.DataBean.CategoriesBean.SubBean> subBeen = new ArrayList<>();
    private SortLeftAdapter leftAdapter;
    private SortRightAdapter rightAdapter;
    private int leftid;
    private int rightid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView)findViewById(R.id.ll_left);
        listView1 = (ListView)findViewById(R.id.ll_right);
        leftAdapter = new SortLeftAdapter(this);
        rightAdapter = new SortRightAdapter(this);
        listView.setAdapter(leftAdapter);
        listView1.setAdapter(rightAdapter);

        HttpUtil.requestGet("http://apicn.seashellmall.com/category", new IRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Sorted sorted = gson.fromJson(result, Sorted.class);
                categoriesBeen .addAll(sorted.getData().getCategories());
                subBeen .addAll(sorted.getData().getCategories().get(0).getSub());
                leftAdapter.notifyDataSetChanged();
                rightAdapter.notifyDataSetChanged();
            }
        });
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            HttpUtil.requestGet("http://apicn.seashellmall.com/category", new IRequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    Sorted sorted = gson.fromJson(result, Sorted.class);
                    subBeen.clear();
                    subBeen .addAll(sorted.getData().getCategories().get(position).getSub());
                    rightAdapter.notifyDataSetChanged();
                    leftid = categoriesBeen.get(position).getId();
                    Log.d("left", "onSuccess: "+leftid);
                }
            });

        }
    });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               rightid=subBeen.get(position).getId();
                Log.d("right", "onItemClick: "+rightid);
                Intent intent = new Intent(ListActivity.this,DetailActivity.class);
                intent.putExtra("left",leftid);
                intent.putExtra("right",rightid);
                startActivity(intent);


            }
        });
    }

    class SortLeftAdapter extends BaseAdapter {

        private Context context;

        public SortLeftAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return categoriesBeen == null ? 0:categoriesBeen.size();
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
                view = LayoutInflater.from(context).inflate(R.layout.show_sorted,null);
                viewHodler = new ViewHodler(view);
                view.setTag(viewHodler);
            } else {
                viewHodler = (ViewHodler) view.getTag();
            }


            Sorted.DataBean.CategoriesBean categoriesBean = categoriesBeen.get(position);
            viewHodler.titleTxt.setText(categoriesBean.getName());
            String url = categoriesBean.getIcon();
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
                titleTxt = (TextView) view.findViewById(R.id.tv_sorted);
                productImage = (ImageView) view.findViewById(R.id.iv_sorted);
            }
        }
    }
    class SortRightAdapter extends BaseAdapter {

        private Context context;

        public SortRightAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return categoriesBeen == null ? 0:subBeen.size();
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
                view = LayoutInflater.from(context).inflate(R.layout.show_right,null);
                viewHodler = new ViewHodler(view);
                view.setTag(viewHodler);
            } else {
                viewHodler = (ViewHodler) view.getTag();
            }


            Sorted.DataBean.CategoriesBean.SubBean subBean = subBeen.get(position);
            viewHodler.titleTxt.setText(subBean.getName());
            String url = subBean.getIcon();
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
                titleTxt = (TextView) view.findViewById(R.id.tv_right_list);
                productImage = (ImageView) view.findViewById(R.id.iv_right_list);
            }
        }
    }
}
