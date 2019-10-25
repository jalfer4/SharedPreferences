package com.example.sharedpreferences.ui.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sharedpreferences.ui.ui.registro.RegistroActivity;
import com.example.sharedpreferences.R;
import com.example.sharedpreferences.model.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private EditText etCuenta;
    private EditText etpassword;
    private Button btnLogin;
    private Button btnRegistrarse;
    private ViewModelMain viewModelMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          btnLogin = findViewById(R.id.btnLogin);
          btnRegistrarse = findViewById(R.id.btnRegistrarse);
          viewModelMain = ViewModelProviders.of(this).get(ViewModelMain.class);

          etCuenta = findViewById(R.id.etCuenta);
          etpassword = findViewById(R.id.etpassword);






        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cuenta = etCuenta.getText().toString();
                String contrasenia = etpassword.getText().toString();


                if(viewModelMain.login(getBaseContext(), cuenta,contrasenia)){
                    Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
                    intent.putExtra("nuevo", "0");


                    startActivity(intent);
                }
                else{Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_LONG).show();}

            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
                intent.putExtra("nuevo", "1");
                startActivity(intent);

            }
        });

    }


}
