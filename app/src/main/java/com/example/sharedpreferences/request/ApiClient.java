package com.example.sharedpreferences.request;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.sharedpreferences.model.Usuario;


public class ApiClient {

    private static SharedPreferences sharedPreferences;


    private static SharedPreferences conectar(Context context){
        if(sharedPreferences == null){
            sharedPreferences= context.getSharedPreferences("datos", Context.MODE_PRIVATE);

        }
        return sharedPreferences;
    }

    public static void guardar(Context context, Usuario usuario){

        SharedPreferences sharedPreferences = conectar(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("dni", usuario.getDni());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("email", usuario.getEmail());
        editor.putString("password", usuario.getPassword());
        editor.commit();

    }

    public static Usuario leer(Context context){

        SharedPreferences sharedPreferences = conectar(context);

        String dni = sharedPreferences.getString("dni", "-1");
        String apellido = sharedPreferences.getString("apellido", "-1");
        String nombre = sharedPreferences.getString("nombre", "-1");
        String email = sharedPreferences.getString("email", "-1");
        String password = sharedPreferences.getString("password", "-1");

        Usuario usuario= new Usuario(dni, apellido, nombre, email, password);
        return usuario;

    }

    public static Usuario login(Context context, String mail, String pass){

        Usuario usuario = null;
        SharedPreferences sharedPreferences = conectar(context);

        String dni = sharedPreferences.getString("dni", "-1");
        String apellido = sharedPreferences.getString("apellido", "-1");
        String nombre = sharedPreferences.getString("nombre", "-1");
        String email = sharedPreferences.getString("email", "-1");
        String password = sharedPreferences.getString("password", "-1");


        if(mail.equals(email) && pass.equals(password)){
            usuario = new Usuario(dni, apellido, nombre, email, password);
        }

        return usuario;
    }


}

