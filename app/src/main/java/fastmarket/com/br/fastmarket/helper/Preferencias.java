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
    private String CHAVE_LOGIN_EMAIL = "loginEmail";
    private String CHAVE_LOGIN_SENHA = "senha";
    private String CHAVE_CELULAR = "celular";
    private String CHAVE_TOKEN = "token";

    public Preferencias( Context contextParamentro){
        context = contextParamentro;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void saveLogin(String email, String senha){
        editor.putString(CHAVE_LOGIN_EMAIL, email);
        editor.putString(CHAVE_LOGIN_SENHA, senha);
        editor.commit();
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
        dadosUsuario.put(CHAVE_LOGIN_EMAIL, preferences.getString(CHAVE_LOGIN_EMAIL, null));
        dadosUsuario.put(CHAVE_LOGIN_SENHA, preferences.getString(CHAVE_LOGIN_SENHA, null));

        return dadosUsuario;
    }

    public void limpaPrefes(){
        editor.remove(CHAVE_EMAIL);
        editor.remove(CHAVE_CELULAR);
        editor.remove(CHAVE_TOKEN);
        editor.remove(CHAVE_LOGIN_SENHA);
        editor.remove(CHAVE_LOGIN_EMAIL);
        editor.commit();
        editor.clear();
    }
}
