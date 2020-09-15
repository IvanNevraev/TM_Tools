package com.example.tm_tools_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class add_kp extends AppCompatActivity {

    Intent intent;
    int ring;
    int type_kp;
    ContentValues cv = new ContentValues(); // создаем объект для данных
    EditText add_kp_number, add_kp_name, add_kp_ip_mcp, add_kp_ip_moxa, add_kp_ip_asmi_1;
    EditText add_kp_ip_asmi_2, add_kp_ip_asmi_shos, add_kp_location_asmi_shos, add_kp_ip_moxa_shos;
    EditText add_kp_ip_first_zelax, add_kp_forwaed_first_zelax, add_kp_ip_second_zelax;
    EditText add_kp_forward_second_zelax;
    Spinner add_kp_key_type_spiner, add_kp_type_restart_device_spiner, add_kp_type_relay_spiner;
    CheckBox add_kp_reserve_modem, add_kp_reserve_ugzl;
    SQLiteOpenHelper bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_kp);

        intent = getIntent();
        ring = intent.getIntExtra("ring",0);
        type_kp = intent.getIntExtra("type_kp",0);
        //Меняем загаловок в actionBar
        String header_title = getString(ring)+"->"+getString(type_kp)+"->Новый КП";
        setTitle(header_title);
        //Кладем в cv для добавления в SQLite
        cv.put("name_ring",getResources().getResourceEntryName(ring));
        cv.put("type_kp",getResources().getResourceEntryName(type_kp));
        //Находим все View
        add_kp_number = findViewById(R.id.add_kp_number);
        add_kp_name = findViewById(R.id.add_kp_name);
        add_kp_ip_mcp = findViewById(R.id.add_kp_ip_mcp);
        add_kp_ip_moxa = findViewById(R.id.add_kp_ip_moxa);
        add_kp_ip_asmi_1 = findViewById(R.id.add_kp_ip_asmi_1);
        add_kp_ip_asmi_2 = findViewById(R.id.add_kp_ip_asmi_2);
        add_kp_ip_asmi_shos = findViewById(R.id.add_kp_ip_asmi_shoes);
        add_kp_location_asmi_shos = findViewById(R.id.add_kp_location_asmi_shos);
        add_kp_ip_moxa_shos = findViewById(R.id.add_kp_ip_moxa_shos);
        add_kp_ip_first_zelax = findViewById(R.id.add_kp_ip_first_zelax);
        add_kp_forwaed_first_zelax = findViewById(R.id.add_kp_forward_first_zelax);
        add_kp_ip_second_zelax = findViewById(R.id.add_kp_ip_second_zelax);
        add_kp_forward_second_zelax = findViewById(R.id.add_kp_forward_second_zelax);
        add_kp_key_type_spiner = findViewById(R.id.add_kp_key_type_spiner);
        add_kp_type_relay_spiner = findViewById(R.id.add_kp_type_relay_spiner);
        add_kp_type_restart_device_spiner = findViewById(R.id.add_kp_type_restart_device_spiner);
        add_kp_reserve_modem = findViewById(R.id.add_kp_reserve_modem);
        add_kp_reserve_ugzl = findViewById(R.id.add_kp_reserve_ugzl);
        //Добавляем подсетку в зависимости от выбраного круга
        switch (ring){
            case R.string.ring_1:
                add_kp_ip_mcp.setText(R.string.ring_1_ip);
                add_kp_ip_moxa.setText(R.string.ring_1_ip);
                add_kp_ip_asmi_1.setText(R.string.ring_1_ip);
                add_kp_ip_asmi_2.setText(R.string.ring_1_ip);
                add_kp_ip_asmi_shos.setText(R.string.ring_1_ip);
                add_kp_ip_moxa_shos.setText(R.string.ring_1_ip);
                add_kp_ip_first_zelax.setText(R.string.ring_1_ip);
                add_kp_ip_second_zelax.setText(R.string.ring_1_ip);
                break;
            case R.string.ring_2:
                add_kp_ip_mcp.setText(R.string.ring_2_ip);
                add_kp_ip_moxa.setText(R.string.ring_2_ip);
                add_kp_ip_asmi_1.setText(R.string.ring_2_ip);
                add_kp_ip_asmi_2.setText(R.string.ring_2_ip);
                add_kp_ip_asmi_shos.setText(R.string.ring_2_ip);
                add_kp_ip_moxa_shos.setText(R.string.ring_2_ip);
                add_kp_ip_first_zelax.setText(R.string.ring_2_ip);
                add_kp_ip_second_zelax.setText(R.string.ring_2_ip);
                break;
        }
        //Подключаемся к BD
        bdHelper = new SQLiteOpenHelper(this,"myDB",null,1) {
            @Override
            public void onCreate(SQLiteDatabase bdHelper) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase bdHelper, int oldVersion, int newVersion) {

            }
        };
    }
    public void click_add_kp (View v){
        SQLiteDatabase bd = bdHelper.getWritableDatabase();

        cv.put("number_kp",add_kp_number.getText().toString());
        cv.put("name_kp",add_kp_name.getText().toString());
        cv.put("key_type",add_kp_key_type_spiner.getSelectedItemId());
        cv.put("ip_mcp",add_kp_ip_mcp.getText().toString());
        cv.put("ip_moxa",add_kp_ip_moxa.getText().toString());
        cv.put("ip_asmi_1",add_kp_ip_asmi_1.getText().toString());
        cv.put("ip_asmi_2",add_kp_ip_asmi_2.getText().toString());
        cv.put("ip_asmi_shos",add_kp_ip_asmi_shos.getText().toString());
        cv.put("location_asmi_shos",add_kp_location_asmi_shos.getText().toString());
        cv.put("ip_moxa_shos",add_kp_ip_moxa_shos.getText().toString());
        cv.put("ip_first_zelax",add_kp_ip_first_zelax.getText().toString());
        cv.put("forward_first_zelax",add_kp_forwaed_first_zelax.getText().toString());
        cv.put("ip_second_zelax",add_kp_ip_second_zelax.getText().toString());
        cv.put("forward_second_zelax",add_kp_forward_second_zelax.getText().toString());
        cv.put("type_relay",add_kp_type_relay_spiner.getSelectedItemId());
        cv.put("type_restart_device",add_kp_type_restart_device_spiner.getSelectedItemId());
        cv.put("reserve_modem",add_kp_reserve_modem.isChecked());
        cv.put("reserve_ugzl",add_kp_reserve_ugzl.isChecked());
        bd.insert("kp",null,cv);
        intent.putExtra("new_kp_name",add_kp_name.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
