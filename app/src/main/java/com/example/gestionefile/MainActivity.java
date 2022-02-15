package com.example.gestionefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLeggi;
    Button btnScrivi;
    TextView visualizzaFile;
    EditText nomeFile;
    Gestore gest= new Gestore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeggi= findViewById(R.id.leggi);
        btnScrivi= findViewById(R.id.scrivi);
        visualizzaFile= findViewById(R.id.visualizzaFile);
        nomeFile= findViewById(R.id.nomeFile);

        //String righeLette= gest.leggiFile("prova.txt", getApplicationContext());
        //Toast.makeText(getApplicationContext(), righeLette, Toast.LENGTH_LONG).show();

        //ascoltatore bottone LEGGI
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testo= gest.leggiFile(nomeFile.getText().toString(), getApplicationContext());
                //Toast.makeText(getApplicationContext(), "esito", Toast.LENGTH_LONG).show();
                visualizzaFile.setText(testo);
            }
        });

        //ascoltatore bottone SCRIVI
        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito= gest.scriviFile("prova.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_LONG).show();
            }
        });

    }
}