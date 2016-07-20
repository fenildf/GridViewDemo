package yinlei.mygridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    /**
     * 上下文对象
     */
    protected Context context;
    /**
     * 布局填充器对象
     */
    protected LayoutInflater inflater;
    /**
     * 数据集
     */
    protected List<T> dataSet;


    public MyBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.dataSet = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return getItemView(position, convertView, parent);
    }

    abstract public View getItemView(int position, View convertView, ViewGroup parent);
}
