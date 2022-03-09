package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor;
    private SeekBar seekBar;
    private TextView porcentagemSeekbar;
    private TextView gorjeta;
    private TextView total;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = findViewById(R.id.txtValor);
        seekBar = findViewById(R.id.seekBar);
        porcentagemSeekbar = findViewById(R.id.porcentoSeekBar);
        gorjeta = findViewById(R.id.txtGorjeta);
        total = findViewById(R.id.txtTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                porcentagemSeekbar.setText(porcentagem + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        
    }

    public void calcular() {

        String valorR = valor.getText().toString();

        if (valorR == null || valorR.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_SHORT).show();
        } else {

            double num = Double.parseDouble(valorR);
            double gorjetaNum = num * (porcentagem / 100);
            double totalNum = num + gorjetaNum;
            gorjeta.setText("R$ " + Math.round(gorjetaNum));
            total.setText("R$ " + Math.round(totalNum));

        }

    }




}