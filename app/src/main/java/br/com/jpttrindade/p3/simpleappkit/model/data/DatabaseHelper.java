package br.com.jpttrindade.p3.simpleappkit.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jpttrindade on 16/02/15.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE_FUNCTION =
            "CREATE TABLE " +  DatabaseContract.Function.TABLE_NAME + " (" +
                    DatabaseContract.Function._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_NAME + " TEXT UNIQUE NOT NULL, "+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_ACTION + " TEXT NOT NULL);";


    private static  final String SQL_POPULATE_TABLE_FUNCTION_a =
            "INSERT INTO "+DatabaseContract.Function.TABLE_NAME+"("+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_NAME+", "+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_ACTION+
                    ") VALUES ('FUNC A', 'actionA');";

    private static  final String SQL_POPULATE_TABLE_FUNCTION_b =
            "INSERT INTO "+DatabaseContract.Function.TABLE_NAME+"("+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_NAME+", "+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_ACTION+
                    ") VALUES ('FUNC B', 'actionB');";

    private static  final String SQL_POPULATE_TABLE_FUNCTION_c =
            "INSERT INTO "+DatabaseContract.Function.TABLE_NAME+"("+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_NAME+", "+
                    DatabaseContract.Function.COLUMN_NAME_FUNCTION_ACTION+
                    ") VALUES ('FUNC B', 'actionC');";

    private static final String SQL_DELETE_TABLE_FUNCTION =
            "DROP TABLE IF EXISTS " + DatabaseContract.Function.TABLE_NAME;



    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "SimpleAppKit.db";





    public DatabaseHelper(Context ctx){
        super(ctx.getApplicationContext(), DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FUNCTION);
//        db.execSQL(SQL_POPULATE_TABLE_FUNCTION_a);
 //       db.execSQL(SQL_POPULATE_TABLE_FUNCTION_b);

    //  db.execSQL(SQL_POPULATE_TABLE_FUNCTION_c);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void removeAll() {
        getReadableDatabase().execSQL("drop table "+DatabaseContract.Function.TABLE_NAME+";" );
        getReadableDatabase().execSQL(SQL_CREATE_TABLE_FUNCTION);
    }
}
