package br.com.jpttrindade.p3.simpleappkit.model.business.scanfunctions;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;

import br.com.jpttrindade.p3.simpleappkit.model.data.Database;
import br.com.jpttrindade.p3.simpleappkit.model.data.DatabaseContract;
import br.com.jpttrindade.p3.simpleappkit.model.data.Function;

/**
 * Created by jpttrindade on 17/02/15.
 */
public class NegocioScanFunctions {

    public static final String SCAN_ACTION = "br.ufpe.cin.p3.simpleappkit.scannewactions";

    Context ctx;


    public NegocioScanFunctions(Context ctx){
        this.ctx = ctx.getApplicationContext();
    }

    public void sendBroadcastScanFunctions() {

        Intent it = new Intent(SCAN_ACTION);
        ctx.sendBroadcast(it);

    }

    public long insertOrUpdateFunction(Database db, Function function) {
        ContentValues values = new ContentValues();
        values.put(Function.FNOME, function.nome);
        values.put(Function.FACTION, function.action);

        return db.insert(DatabaseContract.Function.TABLE_NAME,values);
    }
}
