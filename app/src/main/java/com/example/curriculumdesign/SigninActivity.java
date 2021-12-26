package com.example.curriculumdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.curriculumdesign.activity.BaseActivity;
import com.example.curriculumdesign.base_ui.LoginActivity;

public class SigninActivity extends BaseActivity {

    private RadioGroup style;
    private EditText time;
    private Button submit;

    @Override
    protected int initLayout() {
        return R.layout.activity_signin;
    }

    @Override
    protected void initView() {
        style = findViewById(R.id.radio);
        time = findViewById(R.id.edt_time);
        submit = findViewById(R.id.btn_send_signin);
    }

    @Override
    protected void initData() {
        time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navgateTo(LoginActivity.class);
            }
        });



    }


//    private int getWhichButton(){
//        RadioButton radioButton = style.getCheckedRadioButtonId();
//        if (radioButton.getText().equals("二维码")){
//            return 1;
//        }
//        else {
//            return 2;
//        }
//    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_qrcode:
                if (checked)
                    Log.d("radio", "onRadioButtonClicked: 二维码");
                    break;
            case R.id.radio_GPS:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

}