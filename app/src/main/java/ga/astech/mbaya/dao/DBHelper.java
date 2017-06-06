package ga.astech.mbaya.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ga.astech.mbaya.dao.Users.UsersInfo;
import ga.astech.mbaya.dao.Products.ProductsInfo;

/**
 * Created by julian on 6/5/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Mbaya.db";
    private static final int DB_VERSION = 1;


    private   String CREATE_USERS_TABLE = "CREATE TABLE " + UsersInfo.USER_TABLE_NAME + " ("
            + UsersInfo.USER_NAME + " TEXT NOT NULL,"
            + UsersInfo.USER_PWD + " TEXT NOT NULL,"
            + UsersInfo.USER_MAIL + " TEXT NOT NULL,"
            + UsersInfo.USER_PHONE + " TEXT NOT NULL,"
            + UsersInfo.USER_ICON + " TEXT NOT NULL,"
            + UsersInfo.USER_POSITION + " TEXT NOT NULL);";

     private String CREATE_PRODUCT_TABLE = " CREATE TABLE " + ProductsInfo.PRODUCT_TABLE_NAME + " ("
            + ProductsInfo.PRODUCT_ICON + " TEXT NOT NULL,"
            + ProductsInfo.PRODUCT_NAME + " TEXT NOT NULL,"
            + ProductsInfo.PRODUCT_COST + " TEXT NOT NULL,"
            + ProductsInfo.PRODUCT_DESCRIPTION + " TEXT NOT NULL,"
            + ProductsInfo.PRODUCT_QUANTITY + " TEXT NOT NULL,"
            + ProductsInfo.PRODUCT_CITY + " TEXT NOT NULL);";

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION );
        Log.d("Database operations : ", " Database created ");
    }

    @Override
    public void onCreate( SQLiteDatabase db){

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        Log.d("Database operations : ", " Tables created ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("DBHelper", "Upgrading the database version from " + oldVersion + " to " + newVersion);
        // Clear all data
        db.execSQL(" DROP TABLE IF EXIST " + UsersInfo.USER_TABLE_NAME);
        db.execSQL("  DROP TABLE IF EXIST " + ProductsInfo.PRODUCT_TABLE_NAME);

        // recreate the table
        onCreate(db);
    }
}
