package com.example.tm_tools_v1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class DialogScreen {
    public static final int DIALOG_KP_DELETE = 1; // Идентификаторы диалоговых окон
    public static AlertDialog getDialog(final Activity activity, int ID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        switch(ID) {
            case DIALOG_KP_DELETE: // Диалоговое окно удалить КП
                builder.setTitle(R.string.delete);
                builder.setMessage(R.string.msg_delete_kp);
                builder.setCancelable(true);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // Кнопка yes
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity,"YES",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // Кнопка NO
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity,"NO",Toast.LENGTH_SHORT).show();
                        //dialog.dismiss(); // Отпускает диалоговое окно
                    }
                });
                return builder.create();
            default:
                return null;
        }
    }
}
