package com.cristobalbernal.perfil_usuari;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.cristobalbernal.perfil_usuari.ui.main.Fragment400;
import com.cristobalbernal.perfil_usuari.ui.main.Fragment300;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity{
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
                        tab.setText("400");
                        break;
                    case 1:
                        tab.setText("300");
                        break;
                }
            }
        });
        tlm.attach();

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
                    return new Fragment400();
                case 1:
                    return new Fragment300();
                default:
                    return new Fragment400();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}