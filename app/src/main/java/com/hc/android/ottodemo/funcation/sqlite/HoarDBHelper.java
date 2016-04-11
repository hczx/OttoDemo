package com.hc.android.ottodemo.funcation.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.MalformedJsonException;

import instrument.LogUtil;

/**
 * Created by 99165 on 2016/4/6.
 */
public class HoarDBHelper extends SQLiteOpenHelper {


    //where字句中使用的索引的（键）列的名称
    private static final String KEY_ID = "_id";

    //数据库中每个列名和索引
    public static final String KEY_GOLD_HOARD_NAME_COLUMN = "GOLD_HOARD_NAME_COLUMN";
    public static final String KEY_GOLD_HOARD_ACCESSIBLE_COLUMN = "GOLD_HOARD_ACCESSIBLE_COLUMN";
    public static final String KEY_GOLD_HOARDED_COLUMN = "GOLD_HOARDED_COLUMN";

    private static final String DATABASE_NAME = "myDatabase.db";
    private static final String DATABASE_TABLE = "GoldHoards";

    private static final int DATABASE_VERSION = 1;

    //创建数据库的SQL语句
    private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE + " ("
            + KEY_ID + " integer primary key autoincrement, "
            + KEY_GOLD_HOARD_NAME_COLUMN + " text not null, "
            + KEY_GOLD_HOARDED_COLUMN + " float, "
            + KEY_GOLD_HOARD_ACCESSIBLE_COLUMN + " integer);";

    public HoarDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //当磁盘上不存在数据库，辅助类需要创建一个新数据库时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtil.getInstance().debug("DATABASE", DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE);
    }

    //当数据库版本不一致时，磁盘上的数据库版本需要升级到当前版本时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*记录版本升级*/
        LogUtil.getInstance().debug("DATABASE", "Upgrading from version " + oldVersion + " to " + newVersion + " , which will destroy all old data");

        //将数据升级到现有版本，通过比较oldVersion 和 newVersion的值
        //可以处理多个旧版本的情况
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        //创建新表
        onCreate(db);
    }


    public static void insertGoldModel(GoldModel goldModel) {

        ContentValues newValues = new ContentValues();

        //为每一行赋值
        newValues.put(KEY_GOLD_HOARD_NAME_COLUMN, goldModel.gold_hoard_name);
        newValues.put(KEY_GOLD_HOARDED_COLUMN, goldModel.gold_hoarded_column);
        newValues.put(KEY_GOLD_HOARD_ACCESSIBLE_COLUMN, goldModel.gold_hoard_accessible_column);

        //把行插入到表中
//        SQLiteDatabase db =
    }
}
