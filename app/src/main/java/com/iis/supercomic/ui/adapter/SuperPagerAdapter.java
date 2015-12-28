package com.iis.supercomic.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.iis.supercomic.ui.holder.BaseHolder;

import java.util.List;

/**
 * Created by joyworks on 2015/12/28.
 */
public abstract class SuperPagerAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener {
    private final static int TYPE_LOAD_MORE = 0;
    private final static int TYPE_NORMAL_ITEM = 1;

    private List<T> mDatas;



    private AbsListView mListView;

    public SuperPagerAdapter(AbsListView listView, List<T> datas) {
        this.mDatas = datas;

        this.mListView = listView;
        mListView.setOnItemClickListener(this);

    }

    @Override
    public int getCount() {
        if (mDatas != null) {
            return mDatas.size() + 1;
        }// 添加加载更多的item
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mDatas != null) {
            return mDatas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder holder = null;

        // ############### 1. 初始化item View #############################
        if (convertView == null) {

                // 1. 新建holder
                holder = getItemHolder(position);// 太具体化
                // 2. 加载视图
                // convertView = View.inflate(UIUtils.getContext(),
                // R.layout.item_tmp, null);// 太具体化
                // 通过holder 来提供 视图

               convertView = holder.getRootView();

            // // 3.设置标记
            // convertView.setTag(holder);

            // // 4. 给holder初始化view
            // holder.tv1 = (TextView) convertView.findViewById(R.id.tmp_tv_1);
            // holder.tv2 = (TextView) convertView.findViewById(R.id.tmp_tv_2);
        } else {
            // 有复用
            holder = (BaseHolder) convertView.getTag();
        }
        // #########################################################

        // ############ 2. 给View设置数据 #############################
        // String data = mDatas.get(position);
        // // 给holder中的view设置数据
        // holder.tv1.setText("头-" + data);
        // holder.tv2.setText("内容-" + data);



            // 给普通holder添加数据
            T data = mDatas.get(position);
            // 给holder中的view设置数据
            holder.setData(data);

        // #########################################################

        return convertView;
    }




    protected abstract BaseHolder<T> getItemHolder(int position);




    /**
     * 如果孩子有item的点击事件，复写此方法即可
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    protected void onNoramlItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            onNoramlItemClick(parent, view, position, id);

    }
}

