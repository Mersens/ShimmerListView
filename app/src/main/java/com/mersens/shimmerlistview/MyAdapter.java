package com.mersens.shimmerlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Mersens on 2017/4/19 11:26
 * Email:626168564@qq.com
 */

public class MyAdapter extends BaseAdapter {
    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    public MyAdapter(Context context,List<String> list){
        this.mContext=context;
        this.mList=list;
        mInflater=LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
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
            convertView=mInflater.inflate(R.layout.item,null);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder{


    }


}
