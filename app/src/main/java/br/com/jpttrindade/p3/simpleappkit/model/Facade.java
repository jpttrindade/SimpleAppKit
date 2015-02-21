package br.com.jpttrindade.p3.simpleappkit.model;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;

import br.com.jpttrindade.p3.simpleappkit.control.Menu.Observer;
import br.com.jpttrindade.p3.simpleappkit.model.business.scanfunctions.InsertOrUpdateFunctionService;
import br.com.jpttrindade.p3.simpleappkit.model.business.scanfunctions.NegocioScanFunctions;
import br.com.jpttrindade.p3.simpleappkit.model.data.Database;
import br.com.jpttrindade.p3.simpleappkit.model.data.DatabaseContract;
import br.com.jpttrindade.p3.simpleappkit.model.data.Function;

/**
 * Created by jpttrindade on 16/02/15.
 */
public class Facade extends Application {

    private Database db;
    private NegocioScanFunctions negocioScanFunctions;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Database.getInstance(this);

        negocioScanFunctions = new NegocioScanFunctions(this);

        sendBroadcastScanFunctions();

    }


    public Cursor getListFunction() {
        return db.query("select "+ DatabaseContract.Function._ID+", "+ DatabaseContract.Function.COLUMN_NAME_FUNCTION_NAME+", "+
                DatabaseContract.Function.COLUMN_NAME_FUNCTION_ACTION+" from "+ DatabaseContract.Function.TABLE_NAME);
    }


    public void sendBroadcastScanFunctions() {
        db.removeAll();
        negocioScanFunctions.sendBroadcastScanFunctions();

    }

    public long insertOrUpdateFunction(Function function) {
       return negocioScanFunctions.insertOrUpdateFunction(db, function);
    }

    public void startServiceToInsertOrUpdate(Function function) {
        Intent intent = new Intent(this, InsertOrUpdateFunctionService.class);
        intent.putExtra(NegocioScanFunctions.NEW_FUNCTION, function);
        startService(intent);
    }

    public void setObserver(Observer observer) {
        negocioScanFunctions.setObserver(observer);
    }

    public void unsetObserver() {
        negocioScanFunctions.unsetObserver();
    }
}
