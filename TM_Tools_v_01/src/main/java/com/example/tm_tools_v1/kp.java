package com.example.tm_tools_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

public class kp extends AppCompatActivity {

    Intent intent;
    int ring;
    int type_kp;
    String id; //id в кп в бд
    String name_kp;
    CheckBox reserve_modem, reserve_ugzl;
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
        reserve_ugzl = findViewById(R.id.kp_reserve_ugzl);
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
        // создаем объект для создания и управления версиями БД
        DBHelper dbHelper = new DBHelper(this);
        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d("My_LOG", "--- Rows in kp: ---");
        String selection = "type_kp = ? and name_ring = ? and name_kp = ?";
        String selectionArgs[] = {
                getResources().getResourceEntryName(type_kp),
                getResources().getResourceEntryName(ring),
                name_kp,
        };
        Cursor c = db.query("kp", null, selection, selectionArgs, null, null, null);
        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = "
                                + c.getString(c.getColumnIndex(cn)) + "; ");
                        switch(cn){
                            case  "id":
                                id = c.getString(c.getColumnIndex(cn));
                            case "number_kp":
                                number_kp.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "key_type":
                                key_type.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "type_restart_device":
                                type_restart_device.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "reserve_modem":
                                if(Integer.parseInt(c.getString(c.getColumnIndex(cn)))==1){
                                    reserve_modem.setChecked(true);
                                    reserve_modem.setText(R.string.yes);
                                }else{
                                    reserve_modem.setChecked(false);
                                    reserve_modem.setText(R.string.no);
                                }
                                break;
                            case "reserve_ugzl":
                                if(Integer.parseInt(c.getString(c.getColumnIndex(cn)))==1){
                                    reserve_ugzl.setChecked(true);
                                    reserve_ugzl.setText(R.string.yes);
                                }else{
                                    reserve_ugzl.setChecked(false);
                                    reserve_ugzl.setText(R.string.no);
                                }
                                break;
                            case "ip_mcp":
                                ip_mcp.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_moxa":
                                ip_moxa.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_asmi_1":
                                ip_asmi_1.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_asmi_2":
                                ip_asmi_2.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_asmi_shos":
                                ip_asmi_shos.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "location_asmi_shos":
                                location_asmi_shos.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_moxa_shos":
                                ip_moxa_shos.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_first_zelax":
                                ip_first_zelax.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "forward_first_zelax":
                                forward_first_zelax.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "ip_second_zelax":
                                ip_second_zelax.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "forward_second_zelax":
                                forward_second_zelax.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "type_relay":
                                type_relay.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                            case "count_destroy":
                                count_destroy.setText(c.getString(c.getColumnIndex(cn)));
                                break;
                        }
                    }
                    Log.d("MYLOG", str);

                } while (c.moveToNext());
            }
            c.close();
        } else
            Log.d("MY_LOG", "Cursor is null");
        // закрываем подключение к БД
        dbHelper.close();
        //Меняем данные в БД если изменили статус резервного модема и УГЗЛ
        reserve_modem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // создаем объект для данных
                ContentValues cv = new ContentValues();
                // создаем объект для создания и управления версиями БД
                DBHelper dbHelper = new DBHelper(kp.this);
                // подключаемся к БД
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Log.d("LOG_TAG", "--- Update mytable: ---");
                if(isChecked) {
                    reserve_modem.setText(R.string.yes);
                    // подготовим значения для обновления
                    cv.put("reserve_modem", 1);
                    // обновляем по id
                    int updCount = db.update("kp", cv, "id = ?",
                            new String[] { id });
                    Log.d("LOG_TAG", "updated rows count = " + updCount);
                }else {
                    reserve_modem.setText(R.string.no);
                    // подготовим значения для обновления
                    cv.put("reserve_modem", 0);
                    // обновляем по id
                    int updCount = db.update("kp", cv, "id = ?",
                            new String[] { id });
                    Log.d("LOG_TAG", "updated rows count = " + updCount);
                }
            }
        });
        reserve_ugzl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // создаем объект для данных
                ContentValues cv = new ContentValues();
                // создаем объект для создания и управления версиями БД
                DBHelper dbHelper = new DBHelper(kp.this);
                // подключаемся к БД
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Log.d("LOG_TAG", "--- Update mytable: ---");
                if (isChecked){
                    reserve_ugzl.setText(R.string.yes);
                    // подготовим значения для обновления
                    cv.put("reserve_ugzl", 1);
                    // обновляем по id
                    int updCount = db.update("kp", cv, "id = ?",
                            new String[] { id });
                    Log.d("LOG_TAG", "updated rows count = " + updCount);
                }else {
                    reserve_ugzl.setText(R.string.no);
                    // подготовим значения для обновления
                    cv.put("reserve_ugzl", 0);
                    // обновляем по id
                    int updCount = db.update("kp", cv, "id = ?",
                            new String[] { id });
                    Log.d("LOG_TAG", "updated rows count = " + updCount);
                }
            }
        });

    }
    public void kp_click_kp_gps(View v){

    }
    public void kp_click_add_images(View v){

    }
    public void kp_click_show_work_log(View v){

    }
    public void kp_click_show_table_tu_ts(View v){

    }
    public void kp_click_edit(View v){

    }
    public void kp_click_delete(View v){
        DialogScreen.getDialog(kp.this,1).show();
    }
}
