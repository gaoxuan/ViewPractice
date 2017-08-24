package com.gx.viewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoxuan on 2017/8/24.
 */

public class SimpleItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<EffectItem> dataList;

    public SimpleItemAdapter(Context context, List<EffectItem> list) {
        mContext = context;
        dataList = list;
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_simple, null, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        EffectItem effectItem = dataList.get(position);

        viewHolder.tvItemMainName.setText(effectItem.getName());
        viewHolder.tvItemMainCount.setText(String.valueOf(effectItem.getCount()));

        return convertView;
    }

    protected static class ViewHolder {
        @BindView(R.id.tv_item_main_name)
        TextView tvItemMainName;
        @BindView(R.id.tv_item_main_count)
        TextView tvItemMainCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
