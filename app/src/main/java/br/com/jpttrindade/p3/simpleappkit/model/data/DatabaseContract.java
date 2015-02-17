package br.com.jpttrindade.p3.simpleappkit.model.data;

import android.provider.BaseColumns;

/**
 * Created by jpttrindade on 16/02/15.
 */
public final class DatabaseContract {


    public DatabaseContract(){}


    public static abstract  class Function implements BaseColumns{
        public static final String TABLE_NAME = "tb_function";
        public static final String COLUMN_NAME_FUNCTION_NAME = "function_name";
        public static final String COLUMN_NAME_FUNCTION_ACTION = "function_action";


    }
}
