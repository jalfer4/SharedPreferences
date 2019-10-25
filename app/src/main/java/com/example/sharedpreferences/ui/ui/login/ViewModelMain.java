package com.example.sharedpreferences.ui.ui.login;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sharedpreferences.model.Usuario;
import com.example.sharedpreferences.request.ApiClient;

import java.util.List;

public class ViewModelMain extends ViewModel {

    private MutableLiveData<String> email;
    private MutableLiveData<String> password;


    public ViewModelMain(){

        email = new MutableLiveData<>();
        password = new MutableLiveData<>();
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }




    public static boolean login(Context context, String email, String password){
        ApiClient api = new ApiClient();

        if(api.login(context,email,password) != null){
            return true;
        }

        return false;

    }
}
