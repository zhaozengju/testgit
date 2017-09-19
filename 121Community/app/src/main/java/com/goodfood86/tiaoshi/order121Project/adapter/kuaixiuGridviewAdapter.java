package com.goodfood86.tiaoshi.order121Project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.goodfood86.tiaoshi.order121Project.R;
import com.goodfood86.tiaoshi.order121Project.application.Order121Application;
import com.goodfood86.tiaoshi.order121Project.model.ModuleMainModel;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class kuaixiuGridviewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ModuleMainModel.DataBean.NodesBean> nodesBeanT;

    public kuaixiuGridviewAdapter(Context context, List<ModuleMainModel.DataBean.NodesBean> nodesBeanT) {
        this.context = context;
        this.nodesBeanT = nodesBeanT;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return nodesBeanT.size();
    }

    @Override
    public Object getItem(int position) {
        return nodesBeanT.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View  view = layoutInflater.inflate(R.layout.kuaixiu_item, null);
        if (position < 2) {
            ImageView iv_img = (ImageView) view.findViewById(R.id.iv_kuaixiu_img);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
            tv_title.setText(nodesBeanT.get(position).getTitle());
            tv_content.setText(nodesBeanT.get(position).getSubTitle());
            Order121Application.getHeadImgBitmapUtils().display(iv_img, nodesBeanT.get(position).getIcon());
        }
        return view;

    }
}
