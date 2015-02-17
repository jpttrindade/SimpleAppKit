package br.com.jpttrindade.p3.simpleappkit.control.scanfunctions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.jpttrindade.p3.simpleappkit.model.Facade;
import br.com.jpttrindade.p3.simpleappkit.model.data.Function;

/**
 * Created by joaotrindade on 18/11/14.
 */
public class NewAppReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("DEBUG", "scan function recebendo function");
        String fnome = intent.getStringExtra(Function.FNOME);
        String faction = intent.getStringExtra(Function.FACTION);

        Log.d("DEBUG", "scan function inserir no banco\n"+fnome+"\n"+faction);
        Facade facade = (Facade) context.getApplicationContext();
        facade.startServiceToInsertOrUpdate(new Function(fnome, faction));

    }
}
