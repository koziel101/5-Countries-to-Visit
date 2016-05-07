package com.example.hiago.fivecountriestovisit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hiago.relatoriodeestudos.R;

public class MainActivity extends AppCompatActivity {

    /**
     * Método que define as tabas quando o a Activity é instanciada
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Definindo as tabas e nomeando-as conforme seu respectivo pais
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Alemanha"));
        tabLayout.addTab(tabLayout.newTab().setText("Canadá"));
        tabLayout.addTab(tabLayout.newTab().setText("Egito"));
        tabLayout.addTab(tabLayout.newTab().setText("França"));
        tabLayout.addTab(tabLayout.newTab().setText("Nova Zelândia"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Instancia o PagerAdapter e o ViewPager, que são encarregados de organizar as tabs
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            //Quando a tab é selecionada, seu ID é recuperado e definido
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //AlertDialog de Boas vindas ao aplicativo
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("5 Countries to Visit");
        alertDialog.setMessage("Aprenda um pouco sobre estes 5 países e os avalie.");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();
    }
}
