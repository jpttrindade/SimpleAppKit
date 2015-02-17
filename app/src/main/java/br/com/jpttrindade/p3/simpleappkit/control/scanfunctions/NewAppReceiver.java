package br.com.jpttrindade.p3.simpleappkit.control.scanfunctions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.jpttrindade.p3.simpleappkit.model.Facade;
import br.com.jpttrindade.p3.simpleappkit.model.data.Function;

/**
 * Created by joaotrindade on 18/11/14.
 */
public class NewAppReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String fnome = intent.getStringExtra(Function.FNOME);
        String faction = intent.getStringExtra(Function.FACTION);

        Function function = new Function();
        function.nome = fnome;
        function.action = faction;

        Facade facade = (Facade) context.getApplicationContext();


        facade.insertOrUpdateFunction(function);

    }
}
