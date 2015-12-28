package com.iis.supercomic.ui.fragment;


import android.app.Activity;
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
public class BaseFragment extends Fragment {

protected Activity mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }
}
