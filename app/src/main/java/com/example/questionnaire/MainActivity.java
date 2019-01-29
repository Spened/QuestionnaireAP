package com.example.questionnaire;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private Button btnOk = null;
    private EditText editNom = null;
    private TextView txtMessage = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNom = (EditText)findViewById(R.id.editNom);
        btnOk = (Button)findViewById(R.id.boutonOK);
        txtMessage = (TextView)findViewById(R.id.message);

        btnOk.setOnClickListener(EcouteurBouton);
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txtMessage.setText("");
            if (editNom.getText().length()> 0) {
                Intent question1 = new Intent(MainActivity.this, Question1.class);
                question1.putExtra("NOM", editNom.getText().toString());
                startActivity(question1);
            }
        }
    };


}
