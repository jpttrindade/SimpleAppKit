package br.com.jpttrindade.p3.simpleappkit.control.Menu;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;

import br.com.jpttrindade.p3.simpleappkit.model.Facade;


/**
 * Created by jpttrindade on 17/02/15.
 */

public class LoaderMenu extends AsyncTaskLoader<Cursor> {
    public static final int ID = 1;
    private Cursor c;
    private Facade facade;

    public LoaderMenu(Context context){
        super(context);
        facade = (Facade)context.getApplicationContext();
    }


    @Override
    protected void onStartLoading(){
        if(c !=null){
            deliverResult(c);
        }
        if(takeContentChanged()|| c ==null){
            forceLoad();
        }
    }

    /* Runs on the UI thread */
    @Override
    public void deliverResult(Cursor newCursor){
        if(isReset()){
            if(newCursor!=null){
                 newCursor.close();
            }
            return;
        }
        Cursor oldCursor = c;
        c = newCursor;

        if(isStarted()){
            super.deliverResult(newCursor);
        }

        if(oldCursor!=null && oldCursor!=newCursor && !oldCursor.isClosed()){
            oldCursor.close();
        }
    }

    /* Runs on a worker thread */
    @Override
    public Cursor loadInBackground(){
        return facade.getListFunction();
    }



    @Override
    protected void onStopLoading(){
        cancelLoad();
    }

    @Override
    public void onCanceled(Cursor cursor){
        if(cursor!=null&&!cursor.isClosed()){
            cursor.close();
        }
    }

    @Override
    protected void onReset(){
        super.onReset();
        onStopLoading();
        if(c!=null && !c.isClosed()){
            c.close();
        }
        c =null;
    }
}