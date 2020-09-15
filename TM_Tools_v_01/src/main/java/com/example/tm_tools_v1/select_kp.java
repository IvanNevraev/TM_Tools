package com.example.tm_tools_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class select_kp extends AppCompatActivity {

    Intent intent;
    int ring;
    int type_kp;

    DBHelper dbHelper;
    ArrayList<String> name_kp = new ArrayList<String>();//Массив для передачи адаптеру списка
    ListView list_kp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_kp);
        list_kp = findViewById(R.id.list_kp);
        //Получаем id выбранных круга и типа КП с прошлых activity
        intent = getIntent();
        ring = intent.getIntExtra("ring",0);
        type_kp = intent.getIntExtra("type_kp",0);
        //Меняем загаловок в actionBar
        String header_title = getString(ring)+"->"+getString(type_kp);
        setTitle(header_title);
        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);
        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d("My_LOG", "--- Rows in kp: ---");
        // делаем запрос определенных данных из таблицы mytable, получаем Cursor
        String columns[] = {
                "id",
                "name_kp"
        };
        String selection = "type_kp = ? and name_ring = ?";
        String selectionArgs[] = {
                getResources().getResourceEntryName(type_kp),
                getResources().getResourceEntryName(ring)
        };
        Cursor c = db.query("kp", columns, selection, selectionArgs, null, null, null);
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
                        if(cn.contentEquals("name_kp")){
                            name_kp.add(c.getString(c.getColumnIndex(cn)));
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
        //Заполняем список
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.select_kp_item, name_kp);

        // присваиваем адаптер списку
        list_kp.setAdapter(adapter);
        //Обрабатываем нажатие на списке
        list_kp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                intent.putExtra("name_kp",((TextView)view).getText());
                intent.setClass(getBaseContext(),kp.class);
                startActivity(intent);
            }
        });
    }
    public void click_add_kp(View v){
        intent.setClass(this,add_kp.class);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if(requestCode==1&&resultCode==RESULT_OK){
            name_kp.add(data.getStringExtra("new_kp_name"));
            // создаем адаптер
            ArrayAdapter<String> new_adapter = new ArrayAdapter<String>(this,
                    R.layout.select_kp_item, name_kp);
            list_kp.setAdapter(null);
            // присваиваем адаптер списку
            list_kp.setAdapter(new_adapter);
        }
    }
}
