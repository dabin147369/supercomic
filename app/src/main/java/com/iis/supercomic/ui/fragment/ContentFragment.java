package com.iis.supercomic.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iis.supercomic.Http.ContentFragmentProtocal;
import com.iis.supercomic.R;
import com.iis.supercomic.model.ContentModel;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by joyworks on 2015/12/27.
 */
public class ContentFragment extends BaseFragment {
    public static final String TAG = "ContentFragment";

    @ViewInject(R.id.home_content_banner)
    private ViewPager mBannerViewPager;

    @ViewInject(R.id.home_content_banner_dots)
    private LinearLayout mBannerDots;

    @ViewInject(R.id.home_content_banner_search)
    private ImageView mBannerSearch;

    @ViewInject(R.id.home_content_banner_novel)
    private ImageView mBannerNovel;

    @ViewInject(R.id.home_content_banner_tongren)
    private ImageView mBannerTongRen;

    @ViewInject(R.id.home_content_banner_comic)
    private ImageView mBannerComic;

    @ViewInject(R.id.home_content_newest_novel_more)
    private ImageView mNovelMore;

    @ViewInject(R.id.home_content_novel_views)
    private LinearLayout mNovelList;
    private View mRootView;

    private ContentModel contentModel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home_content, null);
        ViewUtils.inject(mContext, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initData();
        mBannerViewPager.setAdapter(new ContentViewPager());
    }

    private void initData() {
        ContentFragmentProtocal protocal = new ContentFragmentProtocal();
        try {
             contentModel = protocal.loadData(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class ContentViewPager extends PagerAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
