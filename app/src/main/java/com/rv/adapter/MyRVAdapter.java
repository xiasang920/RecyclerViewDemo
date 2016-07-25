package com.rv.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rv.ui.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder>{
    private Context context;
    private List<String> data;
    public MyRVAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }
    //实例化viewholder并返回
    @Override
    public MyRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_rv,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }
    //将视图和数据绑定
    @Override
    public void onBindViewHolder(MyRVAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position));
    }
    //获取数据源数据总数
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_content);
        }

    }
}
