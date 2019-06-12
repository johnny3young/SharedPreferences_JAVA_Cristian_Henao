package com.ejemplo.app.sharedpreferences_java_cristian_henao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextUser, editTextPass;
    Button buttonGuardar, buttonCargar;
    TextView textViewUser, textViewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.edit_text_user);
        editTextPass = findViewById(R.id.edit_text_pass);
        buttonGuardar = findViewById(R.id.button_guardar);
        buttonCargar = findViewById(R.id.button_cargar);
        textViewUser = findViewById(R.id.textView_User);
        textViewPass = findViewById(R.id.textView_Pass);

    //Leer el archivo cada vez que abramos la aplicación para ver si hay alguna información
        cargarPreferencias();

    }

    private void cargarPreferencias() {
    //Abre el archivo y no lo crea porque ya existe (creado con el método "guardar preferencias")
    SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

    //Mostrar info de las columnas
    String user = preferences.getString("user", "No existe información");
    String password = preferences.getString("password", "No existe información");

        textViewUser.setText(user);
        textViewPass.setText(password);


    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.button_guardar:
                guardarPreferencias();
                break;
            case  R.id.button_cargar:
                Intent intent = new Intent(this, ConsultaPreferencias.class);
                startActivity(intent);
                break;
        }
    }

    private void guardarPreferencias() {

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String usuario = editTextUser.getText().toString();
        String password = editTextPass.getText().toString();

        //Columnas ???
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", usuario);
        editor.putString("pass", password);

        textViewUser.setText(usuario);
        textViewPass.setText(password);

        editor.commit();
    }
}
