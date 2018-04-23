package fastmarket.com.br.fastmarket.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

import fastmarket.com.br.fastmarket.model.Usuario;

public class Preferencias {

    private Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "recupera.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;
    private String CHAVE_EMAIL = "email";
    private String CHAVE_CELULAR = "celular";
    private String CHAVE_TOKEN = "token";

    public Preferencias( Context contextParamentro){
        context = contextParamentro;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void savePreferences(String email, String celular, String token){

        editor.putString(CHAVE_EMAIL, email);
        editor.putString(CHAVE_CELULAR, celular);
        editor.putString(CHAVE_TOKEN, token);
        editor.commit();
    }

    public HashMap<String, String> getDadosUsuario(){
        HashMap<String, String> dadosUsuario = new HashMap<>();

        dadosUsuario.put(CHAVE_EMAIL, preferences.getString(CHAVE_EMAIL, null));
        dadosUsuario.put(CHAVE_CELULAR, preferences.getString(CHAVE_CELULAR, null));
        dadosUsuario.put(CHAVE_TOKEN, preferences.getString(CHAVE_TOKEN, null));

        return dadosUsuario;
    }
}
