package com.example.tm_tools_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class select_ring extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_ring);
    }

    public void select_ring (View v){
        Intent intent = new Intent(this, select_type_kp.class);
        switch (v.getId()){
            case R.id.ring_1:
                intent.putExtra("ring",R.string.ring_1);
                break;
            case R.id.ring_2:
                intent.putExtra("ring",R.string.ring_2);
                break;
        }
        startActivity(intent);
    }
}
