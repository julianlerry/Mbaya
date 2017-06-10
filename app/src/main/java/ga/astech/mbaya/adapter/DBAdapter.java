package ga.astech.mbaya.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import ga.astech.mbaya.dao.DBHelper;
import ga.astech.mbaya.dao.Users.UsersInfo;
import ga.astech.mbaya.dao.Products.ProductsInfo;

/**
 * Created by julian on 6/10/17.
 */

public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context ctx) {
        this.c = ctx;
        helper = new DBHelper(c);
    }

    // Open DB
    public DBAdapter openDB(){
        try {
            db = helper.getWritableDatabase();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this;
    }

    // Close DB
    public void closeDB(){
        try {
            helper.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Insert data to table Users
    public long addUser(String name, String pwd, String mail, String phone, String icon, String position){
        try {
            ContentValues cv = new ContentValues();
            cv.put(UsersInfo.USER_NAME, name);
            cv.put(UsersInfo.USER_PWD, pwd);
            cv.put(UsersInfo.USER_MAIL, mail);
            cv.put(UsersInfo.USER_PHONE, phone);
            cv.put(UsersInfo.USER_ICON, icon);
            cv.put(UsersInfo.USER_POSITION, position);

            return db.insert(UsersInfo.USER_TABLE_NAME, null, cv);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    // Insert data to table Products
    public long addProduct(String icon, String name, String cost, String description, String quantity, String city){
        try {
            ContentValues cv2 = new ContentValues();
            cv2.put(ProductsInfo.PRODUCT_ICON, icon);
            cv2.put(ProductsInfo.PRODUCT_NAME, name);
            cv2.put(ProductsInfo.PRODUCT_COST, cost);
            cv2.put(ProductsInfo.PRODUCT_DESCRIPTION, description);
            cv2.put(ProductsInfo.PRODUCT_QUANTITY, quantity);
            cv2.put(ProductsInfo.PRODUCT_CITY, city);

            return db.insert(ProductsInfo.PRODUCT_TABLE_NAME, null, cv2);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    // Retrieve all products
    public Cursor getAllProducts(){
        String[] columns = {ProductsInfo.PRODUCT_ICON, ProductsInfo.PRODUCT_NAME, ProductsInfo.PRODUCT_COST, ProductsInfo.PRODUCT_DESCRIPTION,
                ProductsInfo.PRODUCT_QUANTITY, ProductsInfo.PRODUCT_CITY};

        return db.query(ProductsInfo.PRODUCT_TABLE_NAME, columns, null, null, null, null, null);
    }


}
