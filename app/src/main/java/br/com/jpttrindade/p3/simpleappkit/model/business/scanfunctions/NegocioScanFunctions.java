package br.com.jpttrindade.p3.simpleappkit.model.business.scanfunctions;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.jpttrindade.p3.simpleappkit.control.Menu.Observer;
import br.com.jpttrindade.p3.simpleappkit.model.data.Database;
import br.com.jpttrindade.p3.simpleappkit.model.data.DatabaseContract;
import br.com.jpttrindade.p3.simpleappkit.model.data.Function;

/**
 * Created by jpttrindade on 17/02/15.
 */
public class NegocioScanFunctions {

    public static final String SCAN_ACTION = "br.ufpe.cin.p3.simpleappkit.scannewactions";
    public static final String NEW_FUNCTION = "new_function";

    Context ctx;

    private Observer observer;
    public NegocioScanFunctions(Context ctx){
        this.ctx = ctx.getApplicationContext();
    }

    public void sendBroadcastScanFunctions() {
        Log.d("DEBUG", "scan function broadcast");
        Intent it = new Intent(SCAN_ACTION);
        ctx.sendBroadcast(it);
        Log.d("DEBUG", "scan function broadcast-sent");

    }

    //TODO: por enquanto só insere, precisa ver o update.
    public long insertOrUpdateFunction(Database db, Function function) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Function.COLUMN_NAME_FUNCTION_NAME, function.nome);
        values.put(DatabaseContract.Function.COLUMN_NAME_FUNCTION_ACTION, function.action);
        long retorno = db.insert(DatabaseContract.Function.TABLE_NAME,values);

        if(observer != null) {
            observer.notificar();
        }
        return retorno;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void unsetObserver(){
        this.observer = null;
    }
}
