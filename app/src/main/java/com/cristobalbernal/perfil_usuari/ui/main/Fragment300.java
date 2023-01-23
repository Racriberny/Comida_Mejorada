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

public class Fragment300 extends Fragment {
    public Fragment300(){
        super(R.layout.fragment300);
    }
    private Button btMenosPavo,btMasPavo,btMenosPollo,btMasPollo,btMenosSalmon,btMasSalmon,btMenosTernera,btMasTernera;
    public TextView pavo,pollo,salmon,ternera;
    public int contadorPavo300, contadorPollo300, contadorSalmon300, contadorTernera300;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contadorPavo300 = 0;
        contadorPollo300 = 0;
        contadorSalmon300 = 0;
        contadorTernera300 = 0;
        btMasPavo = view.findViewById(R.id.btMasPavo300);
        btMenosPavo = view.findViewById(R.id.btMenosPavo300);
        btMenosPollo = view.findViewById(R.id.btMenosPollo300);
        btMasPollo = view.findViewById(R.id.btMasPollo300);
        btMasSalmon = view.findViewById(R.id.btMasSalmon300);
        btMenosSalmon = view.findViewById(R.id.btMenosSalmon300);
        btMenosTernera = view.findViewById(R.id.btMenosTernera300);
        btMasTernera = view.findViewById(R.id.btMasTernera300);
        pavo = view.findViewById(R.id.txPavo300);
        pollo = view.findViewById(R.id.txPollo300);
        salmon = view.findViewById(R.id.txSalmon300);
        ternera = view.findViewById(R.id.txTernera300);
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
        contadorTernera300++;
        ternera.setText(""+ contadorTernera300);
    }

    private void decrementarContadorTernera() {
        if (contadorTernera300 == 0){
        }else {
            contadorTernera300--;
            ternera.setText(contadorTernera300 + "");
        }
    }

    private void decrementarContadorSalmon() {
        if (contadorSalmon300 == 0){
        }else {
            contadorSalmon300--;
            salmon.setText(contadorSalmon300 + "");
        }
    }

    private void incrementoContadorSalmon() {
        contadorSalmon300++;
        salmon.setText(""+ contadorSalmon300);
    }

    private void decrementarContadorPollo() {
        if (contadorPollo300 == 0){
        }else {
            contadorPollo300--;
            pollo.setText(contadorPollo300 + "");
        }
    }

    private void incrementarContadorPollo() {
        contadorPollo300++;
        pollo.setText("" + contadorPollo300);
    }

    private void decrementarContadorPavo() {
        if (contadorPavo300 == 0){
        }else {
            contadorPavo300--;
            pavo.setText(contadorPavo300 + "");
        }
    }

    private void incrementarContadorPavo() {
        contadorPavo300++;
        pavo.setText(contadorPavo300 + "");
    }
    public void onPause(){
        super.onPause();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor miEditor = datos.edit();
        miEditor.putInt("pavo300", contadorPavo300);
        miEditor.putInt("pollo300", contadorPollo300);
        miEditor.putInt("salmon300", contadorSalmon300);
        miEditor.putInt("ternera300", contadorTernera300);
        miEditor.apply();
    }
    public void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getContext());
        contadorPavo300 = datos.getInt("pavo300",0);
        contadorPollo300 = datos.getInt("pollo300",0);
        contadorSalmon300 = datos.getInt("salmon300",0);
        contadorTernera300 = datos.getInt("ternera300",0);
        pavo.setText(""+ contadorPavo300);
        pollo.setText("" + contadorPollo300);
        salmon.setText("" + contadorSalmon300);
        ternera.setText("" + contadorTernera300);
    }

}
