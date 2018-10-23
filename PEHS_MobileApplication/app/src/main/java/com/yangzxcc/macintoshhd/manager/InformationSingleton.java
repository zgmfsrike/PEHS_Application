package com.yangzxcc.macintoshhd.manager;

import android.content.Context;

import com.yangzxcc.macintoshhd.Contextor;
import com.yangzxcc.macintoshhd.infos.Information;


public class InformationSingleton {

    private static InformationSingleton instance;

    public static InformationSingleton getInstance() {
        if (instance == null)
            instance = new InformationSingleton();
        return instance;
    }

    private Context mContext;
    private Information information;

    private InformationSingleton() {
        mContext = Contextor.getInstance().getContext();
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}
