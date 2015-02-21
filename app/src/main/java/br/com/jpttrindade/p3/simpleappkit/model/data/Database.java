package br.com.jpttrindade.p3.simpleappkit.model.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jpttrindade on 16/02/15.
 */
public class Database {

    Context ctx;
    DatabaseHelper helper;

    static Database instance;

    private Database (Context ctx){
        this.ctx = ctx;
        helper = new DatabaseHelper(ctx);
    }


    public static Database getInstance(Context ctx){
        if(instance == null){
            instance = new Database(ctx);
        }

        return instance;
    }


    public long insert(String table_name, ContentValues values){
        SQLiteDatabase db = helper.getWritableDatabase();
        return db.insert(table_name, null, values);
    }


    public Cursor query(String query){
        SQLiteDatabase db = helper.getReadableDatabase();

        return db.rawQuery(query, null, null);
    }


    public void removeAll() {
        helper.removeAll();
    }
}
