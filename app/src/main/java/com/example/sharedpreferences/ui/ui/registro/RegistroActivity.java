package com.example.sharedpreferences.ui.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.model.Usuario;
import com.example.sharedpreferences.ui.ui.login.MainActivity;

public class RegistroActivity extends AppCompatActivity {

    private EditText etDni;
    private EditText atApellido;
    private EditText etNombre;
    private EditText etEmail;
    private EditText etPassword;

    private Button btnGuardar;



    private ViewModelRegistro viewModelRegistro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        viewModelRegistro = ViewModelProviders.of(this).get(ViewModelRegistro.class);

        etDni = findViewById(R.id.etDni);
        atApellido = findViewById(R.id.etApellido);
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnGuardar = findViewById(R.id.btnGuardar);

        Intent i= getIntent();
        String dato =i.getStringExtra("nuevo");
        // int x= Integer.parseInt(i.getStringExtra("editar"));


        if( dato.equals("0")){
            Usuario usuario;
            usuario = new Usuario();
            usuario= viewModelRegistro.getUser(getApplicationContext());

            atApellido.setText(usuario.getApellido());
            etDni.setText(usuario.getDni());
            etNombre.setText(usuario.getNombre());
            etEmail.setText(usuario.getEmail());
            etPassword.setText(usuario.getPassword());
        }
        else{
            atApellido.setText("");
            etDni.setText("");
            etNombre.setText("");
            etEmail.setText("");
            etPassword.setText("");
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();
                usuario.setDni(etDni.getText().toString());
                usuario.setApellido(atApellido.getText().toString());
                usuario.setNombre(etNombre.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                usuario.setPassword(etPassword.getText().toString());

                viewModelRegistro.addUser(getApplicationContext(),usuario);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
