package br.com.jpttrindade.p3.simpleappkit.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jpttrindade on 17/02/15.
 */
public class Function implements Parcelable {

    public static final String FNOME = "fnome";
    public static final String FACTION = "faction";

    public String nome;
    public String action;

    public Function(String nome, String action){
        this.nome = nome;
        this.action = action;
    }

    public static final Parcelable.Creator<Function> CREATOR = new Parcelable.Creator<Function>() {


        @Override
        public Function createFromParcel(Parcel source) {
            return new Function(source);
        }

        @Override
        public Function[] newArray(int size) {
            return new Function[size];
        }
    };

    private Function(Parcel p){
        nome = p.readString();
        action = p.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(action);

    }
}
