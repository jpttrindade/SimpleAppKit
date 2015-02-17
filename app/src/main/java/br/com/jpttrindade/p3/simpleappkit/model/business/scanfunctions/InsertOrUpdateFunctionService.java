package br.com.jpttrindade.p3.simpleappkit.model.business.scanfunctions;

import android.app.IntentService;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import br.com.jpttrindade.p3.simpleappkit.model.Facade;
import br.com.jpttrindade.p3.simpleappkit.model.data.Function;

/**
 * Created by jpttrindade on 17/02/15.
 */
public class InsertOrUpdateFunctionService extends IntentService{

    public  static final String NAME = "insertOrUpdateService";
    public InsertOrUpdateFunctionService() {
        super(NAME);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Facade facade = (Facade) getApplication();
        Function function = (Function) intent.getParcelableExtra(NegocioScanFunctions.NEW_FUNCTION);

        try{
            facade.insertOrUpdateFunction(function);
        } catch (SQLiteException e){
            Log.e("ERROR", e.getMessage());
        }

    }
}
