package fastmarket.com.br.fastmarket.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fastmarket.com.br.fastmarket.model.ItensLista;
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
    private String CHAVE_IDLISTA = "idLIsta";
    private Set<String> CHAVE_LISTAATUAL = new HashSet<>();



    public Preferencias(Context contextParamentro) {
        context = contextParamentro;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void saveLogin(String email, String senha) {
        editor.putString(CHAVE_LOGIN_EMAIL, email);
        editor.putString(CHAVE_LOGIN_SENHA, senha);
        editor.commit();
    }

    public void saveListaAtual(ArrayList<String> lista){
        //CHAVE_LISTAATUAL.addAll(lista);
        for (String a : lista) {
            CHAVE_LISTAATUAL.add(lista.toString());
        }
        editor.putStringSet("listaAtual", CHAVE_LISTAATUAL);
        editor.commit();
    }

    public void savePreferences(String email, String celular, String token) {

        editor.putString(CHAVE_EMAIL, email);
        editor.putString(CHAVE_CELULAR, celular);
        editor.putString(CHAVE_TOKEN, token);
        editor.commit();
    }

    public void saveIdLista(String id) {
        editor.putString(CHAVE_IDLISTA, id);
        editor.commit();
    }

    public ArrayList<String> getListaAtual(){
        ArrayList<String> lista = new ArrayList<>();

        lista.addAll(preferences.getStringSet("listaAtual", CHAVE_LISTAATUAL));

        return lista;
    }

    public HashMap<String, String> getDadosUsuario() {
        HashMap<String, String> dadosUsuario = new HashMap<>();

        dadosUsuario.put(CHAVE_EMAIL, preferences.getString(CHAVE_EMAIL, null));
        dadosUsuario.put(CHAVE_CELULAR, preferences.getString(CHAVE_CELULAR, null));
        dadosUsuario.put(CHAVE_TOKEN, preferences.getString(CHAVE_TOKEN, null));
        dadosUsuario.put(CHAVE_LOGIN_EMAIL, preferences.getString(CHAVE_LOGIN_EMAIL, null));
        dadosUsuario.put(CHAVE_LOGIN_SENHA, preferences.getString(CHAVE_LOGIN_SENHA, null));
        dadosUsuario.put(CHAVE_IDLISTA, preferences.getString(CHAVE_IDLISTA, null));

        return dadosUsuario;
    }

    public void limpaidLista() {
        editor.remove(CHAVE_IDLISTA);
        editor.commit();
        editor.clear();
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
