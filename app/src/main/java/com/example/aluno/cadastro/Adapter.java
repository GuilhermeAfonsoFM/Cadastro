package com.example.aluno.cadastro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 16/11/2016.
 */
public class Adapter extends BaseAdapter{
    private List<Agenda> listaAgendas;
    private Context context;

    public Adapter(Context context, List<Agenda> listaAgendas){
        this.listaAgendas = listaAgendas;
        this.context = context;
    }
    @Override
    public int getCount() {
        return this.listaAgendas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaAgendas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.listaAgendas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater)
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_main,null);

        TextView textNome = (TextView) layout.findViewById(R.id.Name);
        textNome.setText(listaAgendas.get(position).getNome() + " - ");

        TextView textTelefone = (TextView) layout.findViewById(R.id.Telephone);
        textTelefone.setText(listaAgendas.get(position).getTelefone());

        return layout;
    }
}
