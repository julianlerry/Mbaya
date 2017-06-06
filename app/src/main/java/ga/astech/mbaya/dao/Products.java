package ga.astech.mbaya.dao;

import android.provider.BaseColumns;

/**
 * Created by julian on 6/5/17.
 */

public class Products {

    public Products(){

    }

    public static abstract class ProductsInfo implements BaseColumns {
        public static final String PRODUCT_TABLE_NAME = "products";
        public static final String PRODUCT_ICON = "products_icon";
        public static final String PRODUCT_NAME = "products_name";
        public static final String PRODUCT_COST = "products_cost";
        public static final String PRODUCT_DESCRIPTION = "products_description";
        public static final String PRODUCT_QUANTITY = "products_quantity";
        public static final String PRODUCT_CITY = "products_city";
    }
}
