package com.shiqi.find.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Author:ShiQi
 * Date:2020/4/14-15:50
 * 连接数据库
 */
public class DBHelper extends SQLiteOpenHelper {

    //上下文；数据库名称；游标工厂（指针在数据表游动）；版本号
    public DBHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
