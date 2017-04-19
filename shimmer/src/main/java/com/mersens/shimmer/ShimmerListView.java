package com.mersens.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.facebook.shimmer.ShimmerFrameLayout;

/**
 * Created by Mersens on 2017/4/18 16:04
 * Email:626168564@qq.com
 */

public class ShimmerListView extends ListView {
    private static final String TAG = "ShimmerListView";
    //默认item个数
    private static int default_count = 3;
    //限制最大Item个数为10
    private static int max_count=10;
    //布局id
    private int mLayoutReference = R.layout.default_shimmer_item_view;
    //ShimmerAdapter
    private ShimmerAdapter mShimmerAdapter;
    //真实数据Adapter
    private ListAdapter mActualAdapter;

    public ShimmerListView(Context context) {
        this(context, null);
    }

    public ShimmerListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShimmerListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * 初始化
     * @param attrs
     */
    private void init(AttributeSet attrs) {
        mShimmerAdapter = new ShimmerAdapter();
        TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.ShimmerListView, 0, 0);
        try {
            if (a.hasValue(R.styleable.ShimmerListView_shimmer_layout)) {
                //存在自定义布局文件，如果没有需要提供默认
                mLayoutReference = a.getResourceId(R.styleable.ShimmerListView_shimmer_layout,
                        R.layout.default_shimmer_item_view);
            }
            if (a.hasValue(R.styleable.ShimmerListView_shimmer_item_count)) {
                //设置了count,如果没有需要提供默认
                default_count = a.getInteger(R.styleable.ShimmerListView_shimmer_item_count,
                        default_count);
                if(default_count>max_count)
                    default_count=max_count;

            }


        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            a.recycle();
        }

    }


    /**
     * 显示Shimmer
     */
    public void showShimmer() {
        if (mShimmerAdapter == null) {
            return;
        }
        setAdapter(mShimmerAdapter);
    }

    /**
     * 隐藏Shimmer
     */
    public void hideShimmer() {
        if (mActualAdapter == null) {
            return;
        }
        setAdapter(mActualAdapter);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        if (adapter == null) {
            mActualAdapter = null;
        } else if (adapter != mShimmerAdapter) {
            mActualAdapter = adapter;
        }
        super.setAdapter(adapter);
    }

    /**
     * 构建ShimmerAdapter
     */
    private class ShimmerAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public ShimmerAdapter() {
            inflater = LayoutInflater.from(getContext());
        }

        @Override
        public int getCount() {
            return default_count;
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
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(mLayoutReference, null);
                holder.mShimmerFrameLayout = (ShimmerFrameLayout) convertView.findViewById(
                        R.id.shimmer_view_container);
                //Shimmer默认自动播放
                holder.mShimmerFrameLayout.setAutoStart(false);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mShimmerFrameLayout.startShimmerAnimation();
            return convertView;
        }
    }

    static class ViewHolder {
        public ShimmerFrameLayout mShimmerFrameLayout;
    }

}
