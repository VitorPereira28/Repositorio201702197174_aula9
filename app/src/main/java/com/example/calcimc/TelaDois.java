package com.example.calcimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaDois extends AppCompatActivity implements View.OnClickListener {

    //ATRIBUTOS
    private EditText edtDescricao;
    private EditText edtResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_dois);

        edtDescricao = findViewById(R.id.edtDescricao);
        edtResultado = findViewById(R.id.edtResultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        String descricao = bundle.getString("descricao");
        String resultado = bundle.getString("resultado");

        edtDescricao.setText(descricao);
        edtResultado.setText(resultado);

        Toast.makeText(this,"Calculo efetuado!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnVoltar){
            finish();
        }
    }
}
