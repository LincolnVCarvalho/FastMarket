package fastmarket.com.br.fastmarket.activity;

import android.app.Application;
import android.content.Context;

public class myApp extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        super.onCreate();
    }

    public static  Context getmContext(){
        return mContext;
    }
}
