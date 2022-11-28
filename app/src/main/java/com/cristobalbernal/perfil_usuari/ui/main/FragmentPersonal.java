package com.cristobalbernal.perfil_usuari.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.perfil_usuari.R;

public class FragmentPersonal extends Fragment {
    private Persona persona;
    public interface IOnAttachListener{
        Persona getPersona();
    }
    public FragmentPersonal(){
        super(R.layout.fragment_personal);
    }

    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvFechaNacimiento;
    private TextView tvDirecion;
    private TextView tvCIF;
    private ImageView imageView;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNombre = view.findViewById(R.id.tvNombreDato);
        tvApellidos = view.findViewById(R.id.tvApellidosDatos);
        tvFechaNacimiento = view.findViewById(R.id.tvFechaNacimientoDato);
        tvDirecion = view.findViewById(R.id.tvDirecionDato);
        tvCIF = view.findViewById(R.id.tvCIF);
        imageView = view.findViewById(R.id.imageView);
        if (persona !=null){
            mostrarDetalle(persona);
        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        persona = attachListener.getPersona();
    }

    public void mostrarDetalle(Persona persona) {
        tvNombre.setText(persona.getNombre());
        tvApellidos.setText(persona.getApellidos());
        tvFechaNacimiento.setText(persona.getFecha_nacimiento());
        tvDirecion.setText(persona.getDirecion());
        tvCIF.setText(persona.getCIF());
        imageView.setImageResource(R.drawable.profile);
    }
}
