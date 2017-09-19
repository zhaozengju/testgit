package com.goodfood86.tiaoshi.order121Project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goodfood86.tiaoshi.order121Project.R;
import com.goodfood86.tiaoshi.order121Project.activity.LlqDateilsActivity;
import com.goodfood86.tiaoshi.order121Project.activity.LlqListActivity;
import com.goodfood86.tiaoshi.order121Project.activity.LoginActivity;
import com.goodfood86.tiaoshi.order121Project.application.Order121Application;
import com.goodfood86.tiaoshi.order121Project.model.CustomActivityModel;

import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<CustomActivityModel.DataBean> listData;

    public CustomAdapter(Context context, List<CustomActivityModel.DataBean> listData) {
        this.context = context;
        this.listData = listData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.item_main_huodong, parent, false));
        return holder;

    }
    public void setData(List<CustomActivityModel.DataBean> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CustomActivityModel.DataBean dataBean = listData.get(position);
        ((MyViewHolder) holder).tv_main_name.setText(dataBean.getName());
        if (dataBean.getImg() != null) {
            Order121Application.getGlobalBitmapUtils().display(((MyViewHolder) holder).iv_huodong_icon, dataBean.getImg().split(",")[0]);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_main_name;
        ImageView iv_huodong_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_huodong_icon = (ImageView) itemView.findViewById(R.id.iv_huodong_icon);
            tv_main_name = (TextView) itemView.findViewById(R.id.tv_main_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (!Order121Application.isLogin()){
                context.startActivity(new Intent(context, LoginActivity.class));
            }else {
                context.startActivity(new Intent(context, LlqListActivity.class)
                        .putExtra("id",listData.get(getPosition()).getId()));
            }

        }
    }
}