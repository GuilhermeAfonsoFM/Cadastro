package com.example.aluno.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListaAgenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agenda);
        Button cadastro = (Button) findViewById(R.id.cadastro);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(ListaAgenda.this,MainActivity.class);

                startActivity(intencao);
            }
        });
    }
}
