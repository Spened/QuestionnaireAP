package com.example.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Question3 extends AppCompatActivity {

    // déclaration des variable
    private TextView txtMessage = null;
    private Button btnVerifier = null;
    private Button btnSuivante = null;
    private String nom= "";
    // déclaration d’une variable de type listView
    private ListView lstContinents = null;
    // création d’un tableau
    private String[] lesContinents = {"Afrique","Amérique","Asie","Europe","Océanie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        // on récupère l'intent qui a lancé l'activité
        Intent i = getIntent();
        // on récupère le nom saisi dans l'autre activité
        nom = i.getStringExtra("NOM");


        // obtention des références sur les vues de l'activité
        txtMessage = (TextView)findViewById(R.id.message);
        btnVerifier = (Button)findViewById(R.id.boutonVerif);
        btnSuivante = (Button)findViewById(R.id.boutonSuiv);

        // écouteurs sur les boutons de l'activité
        btnVerifier.setOnClickListener(EcouteurBouton);
        btnSuivante.setOnClickListener(EcouteurBouton);

        // obtention d’une référence sur la listView
        lstContinents = (ListView)findViewById(R.id.listProposition);
        // peuplement des items de la listView
        lstContinents.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,lesContinents));
    }
    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // quel bouton a été cliqué ?
            switch (view.getId()) {
                case R.id.boutonVerif :
                    if (lesContinents[lstContinents.getCheckedItemPosition()].equals("Amérique")) {
                        txtMessage.setText("Bonne réponse " + nom.toUpperCase());
                    }
                    else {
                        txtMessage.setText("Fausse réponse " + nom.toUpperCase());
                    }
                    break;
                case R.id.boutonSuiv :
                    Intent question4 = new Intent(Question3.this, Question4.class);
                    startActivity(question4);
                    break;
            }
        }
    };
}
