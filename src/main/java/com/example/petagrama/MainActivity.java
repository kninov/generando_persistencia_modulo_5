package com.example.petagrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.petagrama.adapter.adapter_Page;

import com.example.petagrama.fragment.Frag_Perfil;
import com.example.petagrama.fragment.Frag_Mascota;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.vPager);

        setUpViewPager();
        if(miActionBar!=null)
        {
            setSupportActionBar(miActionBar);
        }
    }

    public void irMascotasFavoritas(View v) {
        Intent intent = new Intent(this, Mascota_Favorita.class);
        startActivity(intent);
    }

    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Frag_Mascota());
        fragments.add(new Frag_Perfil());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new adapter_Page(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_perro);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_lista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuContacto:
                Intent c = new Intent(this, cntacto.class);
                startActivity(c);
                break;
            case R.id.menuAcercaDe:
                Intent i = new Intent(this, acerca.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}