package com.example.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Question4 extends AppCompatActivity {

    // déclaration des variable
    private TextView txtMessage = null;
    private Button btnVerifier = null;
    private Button btnSuivante = null;
    private String nom= "";
    // déclaration d’une variable de type listView
    private ListView lstCouleurs = null;
    // création d’un tableau
    private String[] lesCouleurs = {"Blanc","Bleu","Jaune","Noir","Rouge","Vert"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

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
        lstCouleurs = (ListView)findViewById(R.id.listProposition);
        // peuplement des items de la listView
        lstCouleurs.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,lesCouleurs));
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String choix="";
            SparseBooleanArray lesChoix = lstCouleurs.getCheckedItemPositions();
            for (int i=0; i<lesChoix.size();i++) {
                if (lesChoix.valueAt(i)) choix += Integer.toString(lesChoix.keyAt(i));
            }
            // quel bouton a été cliqué ?
            switch (view.getId()) {
                case R.id.boutonVerif :
                        if (choix.equals("235")) {
                        txtMessage.setText("Bonne réponse " + nom.toUpperCase());
                    }
                    else {
                        txtMessage.setText("Fausse réponse " + nom.toUpperCase());
                    }
                    break;
                case R.id.boutonSuiv :
                    Intent question5 = new Intent(Question4.this, Question1.class);
                    startActivity(question5);
                    break;
            }
        }
    };
}
