package com.example.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    // déclaration des variables
    private RadioGroup grpReponse = null;
    private TextView txtMessage = null;
    private Button btnVerifier = null;
    private Button btnSuivante = null;
    private String nom= "";
    // déclaration d’une variable de type spinner
    private Spinner lstCapitales = null;

    // création d’un tableau contenant les valeurs des items
    private String[] lesCapitales = {"Bogota","Buenos Aires","Caracas","Santiago"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        // on récupère l'intent qui a lancé l'activité
        Intent i = getIntent();
        // on récupère le nom saisi dans l'autre activité
        nom = i.getStringExtra("NOM");


        // obtention des références sur les vues de l'activité
        grpReponse = (RadioGroup)findViewById(R.id.grpReponse);
        txtMessage = (TextView)findViewById(R.id.message);
        btnVerifier = (Button)findViewById(R.id.boutonVerif);
        btnSuivante = (Button)findViewById(R.id.boutonSuiv);

        // écouteurs sur les boutons de l'activité
        btnVerifier.setOnClickListener(EcouteurBouton);
        btnSuivante.setOnClickListener(EcouteurBouton);

        // obtention d’une référence sur le spinner
        lstCapitales = (Spinner)findViewById(R.id.listProposition);

        // peuplement des items du spinner
        lstCapitales.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lesCapitales));
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (lstCapitales.getSelectedItem().toString().equals("Buenos Aires")) {
                txtMessage.setText("Bonne réponse " + nom.toUpperCase());
            }
            else {

            }

        }
    };
}
