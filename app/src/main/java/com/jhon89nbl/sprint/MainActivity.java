package com.jhon89nbl.sprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.jhon89nbl.sprint.Controlador.ControladorLogin;

public class MainActivity extends AppCompatActivity implements LoginIterface.View {
    private EditText usuario;
    private EditText contrasena;
    private Button login,register;
    private ControladorLogin control = new ControladorLogin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario= (EditText) findViewById(R.id.editUsuario);
        contrasena= (EditText) findViewById(R.id.editPassword);
        login=(Button) findViewById(R.id.btnLogin);
        register=(Button) findViewById(R.id.btnPageRegister);
        Toast.makeText(this, "ok", Toast.LENGTH_LONG).show();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean user,pass;
                user = control.validarLogin(usuario.getText().toString(),"user");
                pass = control.validarLogin(contrasena.getText().toString(),"password");
                if(user == true && pass == true){
                    control.usuarioPermitido(usuario.getText().toString(),contrasena.getText().toString());
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Registro.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void validarConexion(String text, String mensaje) {
        if(text.equals("user")){
            usuario.setError(mensaje);
        }
        if (text.equals("password")){
            contrasena.setError(mensaje);
        }
    }

    @Override
    public void usuarioValidado(Boolean validacion) {
        if (validacion) {
            Toast.makeText(this, "Usuario autorizado", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Usuario/Contraseña incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}