package com.example.tm_tools_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class select_type_kp extends AppCompatActivity {

    Intent intent;
    int ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_type_kp);

        intent = getIntent();
        ring = intent.getIntExtra("ring",0);
        //Меняем загаловок в actionBar
        String header_title = getString(ring);
        setTitle(header_title);
    }

    public void select_type_kp(View v) {
        switch (v.getId()){
            case R.id.kp_type_1:
                intent.putExtra("type_kp",R.string.kp_type_1);
                break;
            case R.id.kp_type_2:
                intent.putExtra("type_kp",R.string.kp_type_2);
                break;
            case R.id.kp_type_3:
                intent.putExtra("type_kp",R.string.kp_type_3);
                break;
            case R.id.kp_type_4:
                intent.putExtra("type_kp",R.string.kp_type_4);
                break;
            case R.id.kp_type_5:
                intent.putExtra("type_kp",R.string.kp_type_5);
                break;
            case R.id.kp_type_6:
                intent.putExtra("type_kp",R.string.kp_type_6);
                break;
        }
        intent.setClass(this,select_kp.class);
        startActivity(intent);
    }
}
