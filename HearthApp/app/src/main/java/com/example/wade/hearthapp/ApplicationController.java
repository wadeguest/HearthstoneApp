package com.example.wade.hearthapp;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by Wade on 2016-03-10.
 *
 * implementation from:
 * http://arnab.ch/blog/2013/08/asynchronous-http-requests-in-android-using-volley/
 */
public class ApplicationController extends Application {

    //Log or request TAG
    public static final String TAG = "VolleyPatterns";

    //Gloabl request queue for volley
    private RequestQueue mRequestQueue;

    //A singleton instance of the application class for easy access in other places
    private static ApplicationController sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        //initialize the singleton
        sInstance = this;
    }

    //get singleton instance
    public static synchronized ApplicationController getInstance() {
        return sInstance;
    }

    //returns the RequestQueue, or initializes one and returns empty
    public RequestQueue getRequestQueue() {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    //add requests to queue
    public <T> void addToRequestQueue(Request<T> req, String tag) {

        req.setTag(TextUtils.isEmpty(tag) ? TAG:tag);
        VolleyLog.d("Adding request to queue: %s", req.getUrl());
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    //cancel all requests from queue
    public void CancelPendingRequests(Object tag) {
        if(mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
