package com.iis.supercomic.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.iis.supercomic.R;
import com.iis.supercomic.ui.fragment.ContentFragment;
import com.iis.supercomic.ui.fragment.FeedFragment;
import com.iis.supercomic.ui.fragment.MyFragment;
import com.iis.supercomic.ui.fragment.SearchFragment;


public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private FrameLayout mContent;
    private RadioButton mTabContent;
    private RadioButton mTabFeed;
    private RadioButton mTabSearch;
    private RadioButton mTabMy;

    private static String mCurrentPageTag;
    private static Fragment mCurrentFragment;
    private RadioGroup mTabContainer;
    private static int mCurrentCheckedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        setListener();

        upDateTabPager(ContentFragment.TAG);
    }

    private void setListener() {
        mTabContainer.setOnCheckedChangeListener(this);
    }

    private void initViews() {
        mContent = (FrameLayout) findViewById(R.id.home_content);
        mTabContainer = (RadioGroup) findViewById(R.id.home_tab_container);
        mTabContent = (RadioButton) findViewById(R.id.home_tab_content);
        mTabFeed = (RadioButton) findViewById(R.id.home_tab_feed);
        mTabSearch = (RadioButton) findViewById(R.id.home_tab_search);
        mTabMy = (RadioButton) findViewById(R.id.home_tab_my);
    }

    private void upDateTabPager(String tag) {
        if (tag.equals(mCurrentPageTag)) {
            return;
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        if (ContentFragment.TAG.equals(tag)) {
            ContentFragment contentFragment = (ContentFragment) fm.findFragmentByTag(tag);
            if (contentFragment == null) {
                contentFragment = new ContentFragment();
            }
            mCurrentFragment = contentFragment;
            mCurrentPageTag = ContentFragment.TAG;
            mCurrentFragment.onResume();
        } else if (FeedFragment.TAG.equals(tag)) {
            FeedFragment feedFragment = (FeedFragment) fm.findFragmentByTag(tag);
            if (feedFragment == null) {
                feedFragment = new FeedFragment();
            }
            mCurrentFragment = feedFragment;
            mCurrentPageTag = FeedFragment.TAG;
            mCurrentFragment.onResume();

        } else if (SearchFragment.TAG.equals(tag)) {
            SearchFragment searchFragment = (SearchFragment) fm.findFragmentByTag(tag);
            if (searchFragment == null) {
                searchFragment = new SearchFragment();
            }
            mCurrentFragment = searchFragment;
            mCurrentPageTag = SearchFragment.TAG;
            mCurrentFragment.onResume();

        } else if (MyFragment.TAG.equals(tag)) {
            MyFragment myFragment = (MyFragment) fm.findFragmentByTag(tag);
            if (myFragment == null) {
                myFragment = new MyFragment();
            }
            mCurrentFragment = myFragment;
            mCurrentPageTag = MyFragment.TAG;
            mCurrentFragment.onResume();
        } else {
            return;
        }
        if (mCurrentFragment.isAdded()) {
            transaction.show(mCurrentFragment);
        } else {
            transaction.add(R.id.home_content, mCurrentFragment, mCurrentPageTag);
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (mCurrentCheckedId == checkedId) {
            return;
        }
        group.check(checkedId);
        switch (checkedId) {
            case R.id.home_tab_content:
                mCurrentCheckedId = checkedId;
                upDateTabPager(ContentFragment.TAG);
                break;
            case R.id.home_tab_feed:
                mCurrentCheckedId = checkedId;
                upDateTabPager(FeedFragment.TAG);
                break;
            case R.id.home_tab_search:
                mCurrentCheckedId = checkedId;
                upDateTabPager(SearchFragment.TAG);
                break;
            case R.id.home_tab_my:
                mCurrentCheckedId = checkedId;
                upDateTabPager(MyFragment.TAG);
                break;
        }

    }
}
