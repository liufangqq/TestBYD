package com.byd.firstcode.kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void doClick(View view) {
        getIntent().putExtra("return","second");
        setResult(RESULT_OK,getIntent());
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("test201","test20:onBackPressed");
        getIntent().putExtra("return","second_back");
        setResult(RESULT_OK,getIntent());
//        finish();
    }
}