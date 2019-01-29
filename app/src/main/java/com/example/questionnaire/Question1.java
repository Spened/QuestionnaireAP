package com.example.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {
    // déclaration des variables
    private RadioGroup grpReponse = null;
    private TextView txtMessage = null;
    private Button btnVerifier = null;
    private Button btnSuivante = null;
    private String nom= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

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
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String message = "";
            // quel bouton a été cliqué ?
            switch (view.getId()) {
                case R.id.boutonVerif :
                    if (grpReponse.getCheckedRadioButtonId() == R.id.rdbFaux) {
                        message = "Bonne réponse "+nom.toUpperCase()+" - La capitale est Tokyo";
                    }
                    else {
                        message = "Mauvaise réponse "+nom.toUpperCase()+" - La capitale est Tokyo";
                    }
                    txtMessage.setText(message);
                    break;
                case R.id.boutonSuiv :
                    Intent question2 = new Intent(Question1.this, Question2.class);
                    startActivity(question2);
                    break;
            }
        }
    };
}
