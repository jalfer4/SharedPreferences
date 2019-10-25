package com.example.sharedpreferences.ui.ui.registro;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.sharedpreferences.model.Usuario;
import com.example.sharedpreferences.request.ApiClient;

public class ViewModelRegistro extends ViewModel {
    private ApiClient api;

    public void addUser(Context context, Usuario usuario){
        ApiClient api = new ApiClient();

        api.guardar(context,usuario);

    }
    public Usuario getUser(Context context){
        ApiClient api = new ApiClient();

        return (api.leer(context));

    }

}


