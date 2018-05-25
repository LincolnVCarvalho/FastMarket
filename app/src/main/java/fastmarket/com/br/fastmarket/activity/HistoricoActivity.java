package fastmarket.com.br.fastmarket.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.ExpandableListViewAdapter;
import fastmarket.com.br.fastmarket.model.Lista;

public class HistoricoActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        listView = (ExpandableListView) findViewById(R.id.listExp);
        initData();
        listAdapter = new ExpandableListViewAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap  = new HashMap<>();

        listDataHeader.add("02/01/2018");
        listDataHeader.add("30/01/2018");
        listDataHeader.add("12/03/2018");
        listDataHeader.add("15/03/2018");
        //listDataHeader.add("24/04/2018");

        List<String> edmtDev = new ArrayList<>();
            edmtDev.add("This is Expanable ListView!");

        List<String> andoridStudio = new ArrayList<>();
        andoridStudio.add("This is Expanable ListView!");
        andoridStudio.add("This is Expanable ListView!");
        andoridStudio.add("This is Expanable ListView!");
        List<String> xamarin = new ArrayList<>();
        xamarin.add("This is Expanable ListView!");
        xamarin.add("This is Expanable ListView!");
        xamarin.add("This is Expanable ListView!");
        xamarin.add("This is Expanable ListView!");
        List<String> uwp = new ArrayList<>();
        uwp.add("This is Expanable ListView!");
        uwp.add("This is Expanable ListView!");
        uwp.add("This is Expanable ListView!");
        uwp.add("This is Expanable ListView!");

        listHashMap.put(listDataHeader.get(0), edmtDev);
        listHashMap.put(listDataHeader.get(1), andoridStudio);
        listHashMap.put(listDataHeader.get(2), xamarin);
        listHashMap.put(listDataHeader.get(3), uwp);
    }

}
