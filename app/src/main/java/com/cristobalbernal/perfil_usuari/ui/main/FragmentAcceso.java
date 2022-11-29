package com.cristobalbernal.perfil_usuari.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    private TextView contrasenaCambio;
    private LinearLayout linearLayout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nombre = view.findViewById(R.id.tvUsername);
        actual = view.findViewById(R.id.etNuevaActual);
        nueva = view.findViewById(R.id.etNuevaAcesso);
        button = view.findViewById(R.id.bChangePassword);
        buttonGuardar = view.findViewById(R.id.bSavePassword);
        nuevaContrasena = view.findViewById(R.id.etNuevaAcessoDos);
        TextView actualLetras = view.findViewById(R.id.tvCurrentPassword);
        TextView actualLetrasNueva = view.findViewById(R.id.tvNewPassword);
        TextView actualLetrasNuevasDos = view.findViewById(R.id.tvRepeatNewPswd);
        buttonOcultar = view.findViewById(R.id.bOcultar);
        linearLayout = view.findViewById(R.id.panelCambio);
        linearLayout.setVisibility(View.INVISIBLE);
        button.setOnClickListener(vieww ->{
            if (linearLayout.getVisibility() == View.INVISIBLE){
                linearLayout.setVisibility(View.VISIBLE);
            }else {
                linearLayout.setVisibility(View.GONE);
            }
        });
        nombre.setText(personas.getNombre());
        buttonGuardar.setOnClickListener(viewww -> {
            if (actual.getText().toString().equalsIgnoreCase(personas.getContrasena())){
                if (nueva.getText().toString().equalsIgnoreCase(nuevaContrasena.getText().toString())){
                    personas.setContrasena(nueva.getText().toString());
                    Toast.makeText(getContext(),"La contraseña se ha cambiado correctamente!!",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(),"La dos contraseñas nuevas no coinciden!!!",Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(getContext(),"La contraseña actual no conincide con la de la base de datos!!!",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        personas = attachListener.getAceso();
    }
}
