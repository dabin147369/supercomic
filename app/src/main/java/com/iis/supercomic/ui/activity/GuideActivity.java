package com.iis.supercomic.ui.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.iis.supercomic.R;
import com.iis.supercomic.utils.DensityUtil;
import com.iis.supercomic.utils.UIUtils;

import java.util.HashMap;
import java.util.Map;


public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private LinearLayout mDotContainer;


    private static final int PAGE_COUNT = 4;
    private SparseArray<int[]> layoutIds = new SparseArray<int[]>();
    private ImageView mDynamicDot;
    private ImageView mBtn;
    private int mDotSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initViews();
        setListener();

    }

    private void setListener() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        mDotContainer = (LinearLayout) findViewById(R.id.guide_dot_container);
        mDynamicDot = (ImageView) findViewById(R.id.guide_dynamic_dot);
        mBtn = (ImageView) findViewById(R.id.guide_btn);
        initPages();
    }

    private void initPages() {
        initDots();

        mViewPager.setPageTransformer(false, new ViewPagerTransformer(1.2f, 0.5f, layoutIds));
        mViewPager.setAdapter(new ViewPagerAdapter(layoutIds));
        mViewPager.setOnPageChangeListener(this);

    }


    private void initDots() {
        for (int i = 0; i < PAGE_COUNT; i++) {
            View dot = mInflater.inflate(R.layout.guide_dot, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                params.leftMargin = DensityUtil.dip2px(mContext, 10);
            }
            dot.setLayoutParams(params);
            mDotContainer.addView(dot);
        }

        mDotContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mDotContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mDotSpace = mDotContainer.getChildAt(1).getLeft() - mDotContainer.getChildAt(0).getLeft();

            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int leftMargin = (int)(mDotSpace*positionOffset+position*mDotSpace+0.5);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = leftMargin;
        mDynamicDot.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        mBtn.setVisibility(position==PAGE_COUNT-1?View.VISIBLE:View.INVISIBLE);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class ViewPagerTransformer implements ViewPager.PageTransformer {
        SparseArray<int[]> layoutIds;
        float parallaxCoefficient;
        float distanceCoefficient;
        public ViewPagerTransformer(float parallaxCoefficient, float distanceCoefficient,SparseArray<int[]> layoutIds){
            this.layoutIds = layoutIds;
            this.parallaxCoefficient = parallaxCoefficient;
            this.distanceCoefficient = distanceCoefficient;
        }
        @Override
        public void transformPage(View page, float position) {
            float scrollXoffset = page.getWidth() * parallaxCoefficient;
            ViewGroup viewGroup = (ViewGroup) page;

            int[] viewIds = layoutIds.get(viewGroup.getId());
            if(viewIds==null){
                return;
            }
            for(int viewId : viewIds){
                View view = page.findViewById(viewId);
                if(view!=null){
                    view.setTranslationX(scrollXoffset*position);
                }
                scrollXoffset*=distanceCoefficient;
            }
        }
    }

    private class ViewPagerAdapter extends PagerAdapter {
        SparseArray<int[]> layoutIds ;
        public ViewPagerAdapter(SparseArray<int[]> layoutIds) {
            this.layoutIds = layoutIds;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View page = null;
            if (position == 0) {
                page = mInflater.inflate(R.layout.guide_page1, null);
                layoutIds.put(page.getId(), new int[]{R.id.guide_page1_title, R.id.guide_page1_img});

            } else if (position == 1) {
                page = mInflater.inflate(R.layout.guide_page2, null);
                layoutIds.put(page.getId(), new int[]{R.id.guide_page2_title, R.id.guide_page2_img});

            } else if (position == 2) {
                page = mInflater.inflate(R.layout.guide_page3, null);
                layoutIds.put(page.getId(), new int[]{R.id.guide_page3_title, R.id.guide_page3_img});
            } else if (position == 3) {
                page = mInflater.inflate(R.layout.guide_page4, null);
                layoutIds.put(page.getId(), new int[]{R.id.guide_page4_title, R.id.guide_page4_img});
            }
            container.addView(page);
            return page;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            layoutIds.remove(view.getId());
            container.removeView(view);
        }
    }

    private void goToMain() {
        UIUtils.startActivity(this,HomeActivity.class);
    }

}
