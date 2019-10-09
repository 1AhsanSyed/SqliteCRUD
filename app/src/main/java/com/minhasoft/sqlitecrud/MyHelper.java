package com.minhasoft.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private  static final  String dbName = "myDataBase";
    private  static final int version = 3;

    public  MyHelper(Context context){
        super(context,dbName,null,version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE STUDENT (ROLL_NO INTEGER PRIMARY KEY AUTOINCREMENT, S_NAME TEXT, S_SUBJECT TEXT, S_SEMESTER)";
        db.execSQL(query);

        insertionDb("Ahsan","English",8,db);
        insertionDb("Akash","English",8,db);
        insertionDb("waseem","English",8,db);
        insertionDb("osama","English",8,db);
        insertionDb("sabir","English",8,db);
        insertionDb("ali","English",8,db);
    }
    private void insertionDb(String name,String subject,int semester, SQLiteDatabase database){
        ContentValues cv = new ContentValues();
        cv.put("S_NAME", name);
        cv.put("S_SUBJECT", subject);
        cv.put("S_SEMESTER", semester);
        database.insert("STUDENT",null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
