package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.helloworld.R;
import com.example.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
public class UserAdapter extends BaseAdapter{
    private List<User> data;

    private LayoutInflater inflater;

    public UserAdapter(Context context, List<User> data) {
        inflater=LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data!=null?data.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_listview_user,null);
            holder.tvName= (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else
        {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(data.get(position).getName());
        return convertView;
    }

    public static class ViewHolder{
        TextView tvName;
    }


}
