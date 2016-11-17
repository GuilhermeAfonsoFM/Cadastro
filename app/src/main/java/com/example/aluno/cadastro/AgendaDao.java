package com.example.aluno.cadastro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 16/11/2016.
 */
public class AgendaDao extends SQLiteOpenHelper {
    private static final String DATABASE = "cadastro";
    private static final String TABLE = "agenda";
    private static final int VERSION = 1;
    Context context;

    public AgendaDao(Context context) {
        super(context, DATABASE, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "telefone TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Agenda agenda) {
        ContentValues values = new ContentValues();
        values.put("nome" , agenda.getNome());
        values.put("telefone" , agenda.getTelefone());
        getWritableDatabase() .insert(TABLE, null, values);
    }

    public List<Agenda> list() {
        List<Agenda> Agendas = new ArrayList<Agenda>();
        Cursor c = getReadableDatabase() .rawQuery("SELECT * FROM " + TABLE + " ORDER BY nome", null);
        while (c.moveToNext()) {
            Agenda Agenda = new Agenda();
            Agenda.setId(c.getInt(c.getColumnIndex("id")));
            Agenda.setNome(c.getString(c.getColumnIndex("nome")));
            Agenda.setTelefone(c.getString(c.getColumnIndex("telefone")));
            Agendas.add(Agenda);
        }
        c.close();
        return(Agendas);
    }
}
