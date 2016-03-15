package com.example.wade.hearthapp;
import android.app.ActionBar;
import android.app.Activity;

import com.example.wade.hearthapp.ActivityControllers;
/**
 * Created by Wade on 2016-03-15.
 */
public class ActivityControllers {
    protected Activity activity;

    protected static class SignUpController extends ActivityControllers{
        public SignUpController(Activity activity) {
            super.activity = activity;
        }
        protected void CheckSignUpConstraints() {
            new ActivityModels.SignUpActivity(activity).CheckConstraints();
        }
    }
}
