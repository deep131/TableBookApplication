/*
package com.example.tablebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLLiteHandler  extends SQLiteOpenHelper {

    private  static  final  int DATABASE_VERSION=1;
    private  static  final  String DATABASE_NAME="android_api";
    private  static  final  String TABLE_LOGIN="login";
    private  static  final  String KEY_PHONE="PHONE",KEY_NAME="name",KEY_TIME="time",KEY_CREATED_AT="created_at";

    public  SQLLiteHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN +"("
                +KEY_NAME + "VARCHAR " + KEY_PHONE + "INTEGER"+KEY_TIME+"TEXT"+KEY_CREATED_AT+"TEXT"+")";
        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_LOGIN);
    onCreate(db);
    }
    public  void addUser(String s, String name, String phone, String time, String created_at){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE,phone);
        values.put(KEY_TIME,time);
        values.put(KEY_CREATED_AT,created_at);

        db.insert(TABLE_LOGIN,null,values);
        db.close();
    }
}
*/
