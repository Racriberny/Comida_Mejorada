package com.cristobalbernal.perfil_usuari.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.perfil_usuari.R;

public class FragmentProfesional extends Fragment {

    public interface IOnAttachListener{
        Persona getPerson();
    }
    public FragmentProfesional(){
        super(R.layout.fragment_profesional);
    }
    private TextView tvRaoSocial;
    private TextView tvCif;
    private TextView tvDirecion;
    private TextView tvPaginaWeb;
    private TextView tvCorreoElectronico;
    private Persona persona;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvRaoSocial = view.findViewById(R.id.tvRaoSocial);
        tvCif = view.findViewById(R.id.tvCifProfesional);
        tvDirecion = view.findViewById(R.id.tvDirecionProfesional);
        tvPaginaWeb = view.findViewById(R.id.tvPaginaWeb);
        tvCorreoElectronico = view.findViewById(R.id.tvCorreoElectronicoProfesional);
        if(persona !=null){
            mostrarDetalle(persona);
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        persona = attachListener.getPerson();
    }

    public void mostrarDetalle(Persona persona) {
        tvRaoSocial.setText(persona.getRaoSocial());
        tvCif.setText(persona.getCIF());
        tvDirecion.setText(persona.getDirecion());
        tvPaginaWeb.setText(persona.getPaginaWeb());
        tvCorreoElectronico.setText(persona.getCorreuElectronic());
    }
}
