package com.example.tm_tools_v1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MY_LOG", "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table kp ("
                + "id integer primary key autoincrement,"
                + "number_kp integer,"
                + "name_kp text,"
                + "type_kp text,"
                + "name_ring text,"
                + "key_type integer,"
                + "ip_mcp text,"
                + "ip_moxa text,"
                + "ip_asmi_1 text,"
                + "ip_asmi_2 text,"
                + "ip_asmi_shos text,"
                + "location_asmi_shos text,"
                + "ip_moxa_shos text,"
                + "ip_first_zelax text,"
                + "forward_first_zelax text,"
                + "ip_second_zelax text,"
                + "forward_second_zelax text,"
                + "type_relay integer,"
                + "type_restart_device integer,"
                + "reserve_modem integer,"
                + "reserve_ugzl integer,"
                + "gps_w real,"
                + "gps_h real,"
                + "count_destroy integer" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
