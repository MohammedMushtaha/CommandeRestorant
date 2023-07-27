package com.example.commanderestorant.auth.OTPCode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.commanderestorant.R;
import com.example.commanderestorant.databinding.ActivityOtpcodeBinding;

public class OTPCodeActivity extends AppCompatActivity {

    ActivityOtpcodeBinding activityOtpcodeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOtpcodeBinding = DataBindingUtil.setContentView(this, R.layout.activity_otpcode);




    }
}