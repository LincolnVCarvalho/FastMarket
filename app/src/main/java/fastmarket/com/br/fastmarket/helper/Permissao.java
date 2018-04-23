package fastmarket.com.br.fastmarket.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissao {

    public static boolean validaPermissoes(int requestCode,Activity activity, String[] permissoes){

        if(Build.VERSION.SDK_INT >= 23){

            List<String> listPermissao = new ArrayList<String>();

            for(String permissao : permissoes){
                Boolean validaPermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;
                if(!validaPermissao) listPermissao.add(permissao);
            }

            if(listPermissao.isEmpty()) return true;

            String [] novaPermissoes = new String[ listPermissao.size()];
            listPermissao.toArray(novaPermissoes);

            ActivityCompat.requestPermissions(activity, novaPermissoes, requestCode);
        }

        return true;
    }
}
