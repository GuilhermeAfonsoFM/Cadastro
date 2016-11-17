package com.example.aluno.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cadastro = (Button) findViewById(R.id.Cadastrado);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText) findViewById(R.id.Name);
                EditText telefone = (EditText) findViewById(R.id.Telephone);

                String letras =  nome.getText().toString();
                String numero =  telefone.getText().toString();

                Agenda agenda = new Agenda();
                agenda.setNome(letras);
                agenda.setTelefone(numero);

                AgendaDao agendaDao = new AgendaDao(getBaseContext());
                agendaDao.insert(agenda);

                List<Agenda> agendas = agendaDao.list();
                for(Agenda a : agendas){
                    Log.i("Agenda:", "Nome:" + a.getNome() + " Telefone: " + a.getTelefone());
                }
            }
        });
    }
}
