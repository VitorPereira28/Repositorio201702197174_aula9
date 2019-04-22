package com.example.calcimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //ATRIBUTOS
    private EditText edtMassa;
    private EditText edtAltura;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIAR OS COMPONENTES
        edtMassa = findViewById(R.id.edtMassa);
        edtAltura = findViewById(R.id.edtAltura);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);

        //ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalcular){
            double massa = Double.parseDouble(edtMassa.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (massa/Math.pow(altura,2));

            String resultadoTxt = (String.format("%.2f",resultado));
            String descricaoTxt = "";

            if(resultado<18.5){
                descricaoTxt = "Abaixo do Peso";
            }else if(resultado<25){
                descricaoTxt = "Peso Ideal";
            }else if(resultado<30){
                descricaoTxt = "Levemente Acima do Peso";
            }else if(resultado<35){
                descricaoTxt = "Obesidade Grau I";
            }else if(resultado<40){
                descricaoTxt = "Obesidade Grau II";
            }else{
                descricaoTxt = "Obesidade Grau III";
            }

            Intent intent = new Intent(MainActivity.this, TelaDois.class);
            intent.putExtra("descricao", descricaoTxt);
            intent.putExtra("resultado", resultadoTxt);
            startActivity(intent);

        }else if(v.getId() == R.id.btnLimpar){
            edtMassa.setText("");
            edtAltura.setText("");
            edtMassa.requestFocus();

            Toast.makeText(this,"Os dados foram apagados!",Toast.LENGTH_LONG).show();
        }
    }
}
