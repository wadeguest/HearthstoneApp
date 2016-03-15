package com.example.wade.hearthapp;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wade on 2016-03-15.
 */
public class ActivityModels {
    protected static class SignUpActivity {
        private Activity activity;
        public SignUpActivity(Activity activity) {
            this.activity = activity;
        }

        private class SignUpFormData {
            private String username;
            private String password;
            private String email;
            private String conf_pass;
            private String conf_email;

            //default constructor uses current form data
            SignUpFormData() {
                this.username = ((EditText) activity.findViewById(R.id.etUsername)).getText().toString();
                this.password = ((EditText) activity.findViewById(R.id.etPassword)).getText().toString();
                this.email = ((EditText) activity.findViewById(R.id.etEmail)).getText().toString();
                this.conf_pass = ((EditText) activity.findViewById(R.id.etConfirmPassword)).getText().toString();
                this.conf_email = ((EditText) activity.findViewById(R.id.etConfirmEmail)).getText().toString();
            }

            //Constructor for custom data
            SignUpFormData(String username, String password, String email, String conf_email, String conf_pass) {
                this.username = username;
                this.password = password;
                this.email = email;
                this.conf_email = conf_email;
                this.conf_pass = conf_pass;
            }

            protected String getUsername() {
                return this.username;
            }

            protected String getPassword() {
                return this.password;
            }

            protected String getEmail() {
                return this.email;
            }

            protected String getConf_pass() {
                return this.conf_pass;
            }

            protected String getConf_email() {
                return this.conf_email;
            }
        }

        protected void CheckConstraints() {
            SignUpFormData currentFieldData = new SignUpFormData();
            if (currentFieldData.getUsername().length()>0 && currentFieldData.getPassword().length()>0 && currentFieldData.getEmail().length() > 0
                    && currentFieldData.getConf_email().length() > 0 && currentFieldData.getConf_pass().length() > 0) {

                //check username
                if (currentFieldData.getUsername().length() < 6) {
                    //handle incorrect input
                }
                //check password
                if (currentFieldData.getPassword().length() < 6) {
                    if (currentFieldData.getPassword().equals(currentFieldData.getConf_pass())) {
                        String pass_pt = "^(?=.*[A-Za-z])(?=.*\\sd)[A-Za-z\\sd]{8,}$";
                        Pattern pattern = Pattern.compile(pass_pt);
                        Matcher matcher = pattern.matcher(currentFieldData.getPassword());
                        if (!matcher.matches()) {
                            //handle incorrect input
                        }
                    }
                }
                //check email
                if (!currentFieldData.getConf_email().contains("@") || !currentFieldData.getEmail().contains("@")) {
                    //handle incorrect data
                }

            } else {
                //set up text box to say incorrect data
            }
        }

        private View.OnClickListener submitForm = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

            private boolean CheckConstraints(SignUpFormData fields) {

                return true;
            }
        };

    }
}
