package br.com.jpttrindade.p3.simpleappkit.model;

import android.app.Application;
import android.database.Cursor;

import br.com.jpttrindade.p3.simpleappkit.model.data.Database;
import br.com.jpttrindade.p3.simpleappkit.model.data.DatabaseContract;

/**
 * Created by jpttrindade on 16/02/15.
 */
public class Facade extends Application {

    private Database db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Database.getInstance(this);

    }

    public Cursor getListFunction() {
        return db.query("select * from "+ DatabaseContract.Function.TABLE_NAME);
    }
}
