package com.cristobalbernal.perfil_usuari.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.perfil_usuari.R;

public class FragmentAcceso extends Fragment {
    public interface IOnAttachListener{
        Persona getAceso();
    }
    public FragmentAcceso(){
        super(R.layout.fraggmentacesso);
    }
    private Persona personas;
    private Button button;
    private Button buttonGuardar;
    private Button buttonOcultar;
    private TextView nombre;
    private EditText actual;
    private EditText nueva;
    private EditText nuevaContrasena;
    private TextView actualLetras;
    private TextView actualLetrasNueva;
    private TextView actualLetrasNuevasDos;
    private TextView contrasenaCambio;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nombre = view.findViewById(R.id.tvNombreAccesoDato);
        actual = view.findViewById(R.id.etNuevaActual);
        nueva = view.findViewById(R.id.etNuevaAcesso);
        button = view.findViewById(R.id.btCambiarContraseña);
        buttonGuardar = view.findViewById(R.id.btGuuardar);
        nuevaContrasena = view.findViewById(R.id.etNuevaAcessoDos);
        actualLetras = view.findViewById(R.id.tvContraseña);
        actualLetrasNueva = view.findViewById(R.id.tvContraseñaNueva);
        actualLetrasNuevasDos = view.findViewById(R.id.tvRepitaNuevaContraseña);
        buttonOcultar = view.findViewById(R.id.btOcultar);
        contrasenaCambio = view.findViewById(R.id.tvContraseñaTrampas);
        if (personas !=null){
            mostrarDatos(personas);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        personas = attachListener.getAceso();
    }

    public void mostrarDatos(Persona persona) {
        nombre.setText(persona.getNombre());
        contrasenaCambio.setText(persona.getContrasena());
        button.setOnClickListener(view ->{
            actual.setVisibility(View.VISIBLE);
            nueva.setVisibility(View.VISIBLE);
            nuevaContrasena.setVisibility(View.VISIBLE);
            actualLetras.setVisibility(View.VISIBLE);
            actualLetrasNueva.setVisibility(View.VISIBLE);
            actualLetrasNuevasDos.setVisibility(View.VISIBLE);
            buttonOcultar.setVisibility(View.VISIBLE);
            buttonGuardar.setVisibility(View.VISIBLE);

        });
        buttonOcultar.setOnClickListener(view -> {
            actual.setVisibility(View.INVISIBLE);
            nueva.setVisibility(View.INVISIBLE);
            nuevaContrasena.setVisibility(View.INVISIBLE);
            actualLetras.setVisibility(View.INVISIBLE);
            actualLetrasNueva.setVisibility(View.INVISIBLE);
            actualLetrasNuevasDos.setVisibility(View.INVISIBLE);
            buttonOcultar.setVisibility(View.INVISIBLE);
            buttonGuardar.setVisibility(View.INVISIBLE);
        });
        buttonGuardar.setOnClickListener(view -> {
            if (actual.getText().toString().equalsIgnoreCase(persona.getContrasena())){
                if (nueva.getText().toString().equalsIgnoreCase(nuevaContrasena.getText().toString())){
                    personas.setContrasena(nueva.getText().toString());
                    Toast.makeText(getContext(),"Se ha cambiado",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(),"La dos contraseñas no coinciden",Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(getContext(),"La contraseña no coincidem",Toast.LENGTH_LONG).show();
            }
        });


    }
}
