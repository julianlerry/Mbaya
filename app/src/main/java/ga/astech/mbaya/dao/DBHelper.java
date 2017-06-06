package ga.astech.mbaya.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by julian on 6/5/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Mbaya.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION );
    }
}
