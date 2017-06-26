package com.alex.compare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("Compare: Álcool X Gasolina");
        Button BtnCalcula = (Button) findViewById(R.id.btnCalcular);
        final EditText ValorAlcoolVA = (EditText) findViewById(R.id.ValorAlcool);
        final EditText ValorGasolinaVA = (EditText) findViewById(R.id.ValorGasolina);
        final TextView TxtExibe = (TextView) findViewById(R.id.txtResultado);
        final TextView TxtMensagem = (TextView) findViewById(R.id.txtMensagem);
        TxtExibe.setText("");
        BtnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double alcool = 0, gasolina = 0, resultado = 0;
                int result;
                TxtExibe.setText("");
                if (ValorAlcoolVA.length() == 0 || ValorGasolinaVA.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Entre com os Valores", Toast.LENGTH_SHORT).show();
                } else {
                    alcool = Double.parseDouble(String.valueOf(ValorAlcoolVA.getText()));
                    gasolina = Double.parseDouble(String.valueOf(ValorGasolinaVA.getText()));
                    resultado = alcool / gasolina;
                    result = (int) (resultado * 100);

                    if (resultado >= 0.7) {
                        TxtExibe.setText("GASOLINA");
                        TxtExibe.setBackgroundResource(R.drawable.fundogasolina);
                    } else {
                        TxtExibe.setText("ÁLCOOL");
                        TxtExibe.setBackgroundResource(R.drawable.fundoalcool);
                    }
                    TxtMensagem.setText(result + "%. É o valor do álcool em relação ao preço da gasolina");
                }
            }
        });


    }
}