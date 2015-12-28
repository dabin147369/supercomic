package com.iis.supercomic.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iis.supercomic.R;

/**
 * Created by joyworks on 2015/12/27.
 */
public class SearchFragment extends BaseFragment {
    public static final String TAG = "SearchFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_search,null);
    }
}
