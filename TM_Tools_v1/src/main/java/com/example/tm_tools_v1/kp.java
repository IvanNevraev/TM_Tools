package com.example.tm_tools_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class kp extends AppCompatActivity {

    Intent intent;
    int ring;
    int type_kp;
    String name_kp;
    TextView reserve_modem, reserve_ugzl;
    TextView number_kp, key_type, type_restart_device, ip_mcp, ip_moxa, ip_asmi_1, ip_asmi_2;
    TextView ip_asmi_shos, location_asmi_shos, ip_moxa_shos, ip_first_zelax, forward_first_zelax;
    TextView ip_second_zelax, forward_second_zelax, type_relay, count_destroy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp);
        intent = getIntent();
        //Получаем id выбранных круга и типа КП с прошлых activity
        intent = getIntent();
        ring = intent.getIntExtra("ring",0);
        type_kp = intent.getIntExtra("type_kp",0);
        name_kp = intent.getStringExtra("name_kp");
        //Меняем загаловок в actionBar
        String header_title = getString(ring)+"->"+getString(type_kp)+"->"+name_kp;
        setTitle(header_title);
        //Находим все view компоненты
        number_kp = findViewById(R.id.kp_number_kp);
        key_type = findViewById(R.id.kp_key_type);
        type_restart_device = findViewById(R.id.kp_type_restart_device);
        reserve_modem = findViewById(R.id.kp_reserve_modem);
        reserve_ugzl = findViewById(R.id.add_kp_reserve_ugzl);
        ip_mcp = findViewById(R.id.kp_ip_mcp);
        ip_moxa = findViewById(R.id.kp_ip_moxa);
        ip_asmi_1 = findViewById(R.id.kp_ip_asmi_1);
        ip_asmi_2 = findViewById(R.id.kp_ip_asmi_2);
        ip_asmi_shos = findViewById(R.id.kp_ip_asmi_shos);
        location_asmi_shos = findViewById(R.id.kp_location_asmi_shos);
        ip_moxa_shos = findViewById(R.id.kp_ip_moxa_shos);
        ip_first_zelax = findViewById(R.id.kp_ip_first_zelax);
        forward_first_zelax = findViewById(R.id.kp_forward_first_zelax);
        ip_second_zelax = findViewById(R.id.kp_ip_second_zelax);
        forward_second_zelax = findViewById(R.id.kp_forwaed_second_zelax);
        type_relay = findViewById(R.id.kp_type_relay);
        count_destroy = findViewById(R.id.kp_count_destroy);


    }
    public void click_kp_gps(View v){

    }
    public void click_add_images(View v){

    }
    public void click_show_work_log(View v){

    }
    public void show_table_tu_ts(View v){

    }
}
