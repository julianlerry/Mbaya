package ga.astech.mbaya.dao;

import android.provider.BaseColumns;

/**
 * Created by julian on 6/5/17.
 */

public class Users {

    public Users(){

    }

        public static abstract class UsersInfo implements BaseColumns {
            public static final String USER_TABLE_NAME = "user";
            public static final String USER_NAME = "username";
            public static final String USER_PWD = "user_pwd";
            public static final String USER_MAIL = "user_mail";
            public static final String USER_PHONE = "user_phone";
            public static final String USER_ICON = "user_icon";
            public static final String USER_POSITION = "user_position";
        }
}