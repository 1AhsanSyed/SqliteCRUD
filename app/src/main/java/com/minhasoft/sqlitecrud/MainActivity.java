package com.minhasoft.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.myData);
        StringBuilder builder = new StringBuilder();

        MyHelper myHelper = new MyHelper(this);
        SQLiteDatabase sqliDb = myHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        //Update Query
       // values.put("S_NAME","Ahsan Syed");
        //sqliDb.update("STUDENT",values,"ROLL_NO = ?", new String[]{"3"});

        //Delete query
        //sqliDb.delete("STUDENT","ROLL_NO = ? ", new String[]{"3"});

        //select Query
        Cursor cursor = sqliDb.rawQuery("SELECT S_NAME,S_SUBJECT,S_SEMESTER from STUDENT",new String[]{});

        if (cursor != null){
            cursor.moveToFirst();

        }

        do {
            //int sRollNo = cursor.getInt(0);
            String sName = cursor.getString(0);
            String sSubject = cursor.getString(1);
            int sSemester = cursor.getInt(2);
            builder.append("\nName  : "+sName+"\nSubject  : "+sSubject+"\nSemester : "+sSemester);
        }while (cursor.moveToNext());

        result.setText(builder.toString());
    }
}
