package com.yangzxcc.macintoshhd.pehs.sql;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class InputValidation {
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }
    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString();
        if (value.isEmpty()){
            textInputLayout.setError(message);

        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
    public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2,TextInputLayout textInputLayout, String message){
        String value1 = textInputEditText1.getText().toString();
        String value2 = textInputEditText2.getText().toString();
        if (!value1.contentEquals(value2)){
            textInputLayout.setError(message);
            hideKeyBoardFrom(textInputEditText2);
        }else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
    private void hideKeyBoardFrom(View view) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
