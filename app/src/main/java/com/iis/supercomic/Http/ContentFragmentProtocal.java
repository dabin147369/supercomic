package com.iis.supercomic.Http;

import com.google.gson.Gson;
import com.iis.supercomic.constant.ConstantKey;
import com.iis.supercomic.constant.ConstantValue;
import com.iis.supercomic.model.ContentModel;
import com.iis.supercomic.utils.FileUtils;
import com.iis.supercomic.utils.IOUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by joyworks on 2015/12/28.
 */
public  class ContentFragmentProtocal extends  BaseProtocal<ContentModel>{


    @Override
    protected String getInterfaceKey() {
        return ConstantKey.CONTENT;
    }

    @Override
    protected ContentModel parseJson(String json) {
        return new Gson().fromJson(json, ContentModel.class);
    }
}