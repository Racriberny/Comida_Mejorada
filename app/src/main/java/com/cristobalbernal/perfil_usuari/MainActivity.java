package com.cristobalbernal.perfil_usuari;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.cristobalbernal.perfil_usuari.ui.main.FragmentAcceso;
import com.cristobalbernal.perfil_usuari.ui.main.FragmentPersonal;
import com.cristobalbernal.perfil_usuari.ui.main.FragmentProfesional;
import com.cristobalbernal.perfil_usuari.ui.main.Persona;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements FragmentPersonal.IOnAttachListener, FragmentProfesional.IOnAttachListener, FragmentAcceso.IOnAttachListener{
    public Persona persona = new Persona("12345","Juan","Palomo Garcia",
            "04/08/1995(24 años)","C/Major, 35 03730 Xabia","John Doe, S.L",
            "B123456","http://johndoe.com","juanpalomo@johndoe.com","123");
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        TabStateAdapter tabStateAdapter = new TabStateAdapter(this);
        viewPager2.setAdapter(tabStateAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        TabLayoutMediator tlm = new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Personales");
                        break;
                    case 1:
                        tab.setText("Profesionales");
                        break;
                    case 2:
                        tab.setText("Contraseña");
                        break;
                }
            }
        });
        tlm.attach();

    }


    @Override
    public Persona getPersona() {
        return persona;

    }

    @Override
    public Persona getPerson() {
        return persona;
    }

    @Override
    public Persona getAceso() {
        return persona;
    }

    public static class TabStateAdapter extends FragmentStateAdapter {
        public TabStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch(position) {
                case 0:
                    return new FragmentPersonal();
                case 1:
                    return new FragmentProfesional();
                case 2:
                    return new FragmentAcceso();
                default:
                    return new FragmentPersonal();
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}