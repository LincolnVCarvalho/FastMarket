package fastmarket.com.br.fastmarket.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;

import fastmarket.com.br.fastmarket.fragment.ListaFragment;
import fastmarket.com.br.fastmarket.fragment.MapaFragment;
import fastmarket.com.br.fastmarket.fragment.ProcuraFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tabs = {"LISTA", "PROCURA", "MAPA"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new ListaFragment();
                break;
            case 1:
                fragment = new ProcuraFragment();
                break;
            case 2:
                fragment = new MapaFragment();
                break;
        }
        return  fragment;

    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
