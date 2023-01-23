package com.cristobalbernal.perfil_usuari.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.perfil_usuari.R;

public class Fragment400 extends Fragment {
    public Fragment400(){
        super(R.layout.fragment400);
    }
    private Button btMenosPavo,btMasPavo,btMenosPollo,btMasPollo,btMenosSalmon,btMasSalmon,btMenosTernera,btMasTernera;
    public TextView pavo,pollo,salmon,ternera;
    public int contadorPavo,contadorPollo,contadorSalmon,contadorTernera;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contadorPavo = 1;
        contadorPollo = 1;
        contadorSalmon = 1;
        contadorTernera = 1;
        btMasPavo = view.findViewById(R.id.btMasPavo400);
        btMenosPavo = view.findViewById(R.id.btMenosPavo400);
        btMenosPollo = view.findViewById(R.id.btMenosPollo400);
        btMasPollo = view.findViewById(R.id.btMasPollo400);
        btMasSalmon = view.findViewById(R.id.btMasSalmon400);
        btMenosSalmon = view.findViewById(R.id.btMenosSalmon400);
        btMenosTernera = view.findViewById(R.id.btMenosTernera400);
        btMasTernera = view.findViewById(R.id.btMasTernera400);
        pavo = view.findViewById(R.id.txPavo400);
        pollo = view.findViewById(R.id.txPollo400);
        salmon = view.findViewById(R.id.txSalmon400);
        ternera = view.findViewById(R.id.txTernera400);
        btMasPavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContadorPavo();
            }
        });
        btMenosPavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContadorPavo();
            }
        });
        btMasPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContadorPollo();
            }
        });
        btMenosPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContadorPollo();
            }
        });
        btMasSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementoContadorSalmon();
            }
        });
        btMenosSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContadorSalmon();
            }
        });
        btMasTernera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContadorTernera();
            }
        });
        btMenosTernera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContadorTernera();
            }
        });
    }

    private void incrementarContadorTernera() {
        contadorTernera++;
        ternera.setText(""+contadorTernera);
    }

    private void decrementarContadorTernera() {
        if (contadorTernera == 0){
        }else {
            contadorTernera--;
            ternera.setText(contadorTernera + "");
        }
    }

    private void decrementarContadorSalmon() {
        if (contadorSalmon == 0){
        }else {
            contadorSalmon--;
            salmon.setText(contadorSalmon + "");
        }
    }

    private void incrementoContadorSalmon() {
        contadorSalmon++;
        salmon.setText(""+contadorSalmon);
    }

    private void decrementarContadorPollo() {
        if (contadorPollo == 0){
        }else {
            contadorPollo--;
            pollo.setText(contadorPollo + "");
        }
    }

    private void incrementarContadorPollo() {
        contadorPollo++;
        pollo.setText("" + contadorPollo);
    }

    private void decrementarContadorPavo() {
        if (contadorPavo == 0){
        }else {
            contadorPavo--;
            pavo.setText(contadorPavo + "");
        }
    }

    private void incrementarContadorPavo() {
        contadorPavo++;
        pavo.setText(contadorPavo + "");
    }
    public void onPause(){
        super.onPause();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor miEditor = datos.edit();
        miEditor.putInt("pavo",contadorPavo);
        miEditor.putInt("pollo",contadorPollo);
        miEditor.putInt("salmon",contadorSalmon);
        miEditor.putInt("ternera",contadorTernera);
        miEditor.apply();
    }
    public void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getContext());
        contadorPavo = datos.getInt("pavo",0);
        contadorPollo = datos.getInt("pollo",0);
        contadorSalmon = datos.getInt("salmon",0);
        contadorTernera = datos.getInt("ternera",0);
        pavo.setText(""+contadorPavo);
        pollo.setText("" + contadorPollo);
        salmon.setText("" + contadorSalmon);
        ternera.setText("" + contadorTernera);
    }
}

