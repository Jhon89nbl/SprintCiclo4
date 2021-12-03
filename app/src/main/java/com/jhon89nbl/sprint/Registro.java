package com.jhon89nbl.sprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.jhon89nbl.sprint.Controlador.ControladorFormulario;
import com.jhon89nbl.sprint.Modelo.FormularioDTO;

public class Registro extends AppCompatActivity implements FormularioInterfaz.View {
    private EditText regName,regLastName,regAdress, regEmail, regCity,regCellphone,regUser, regPassword;
    private ImageView regPhoto;
    private Spinner regSex;
    private Button btnRegister;
    private FormularioDTO formularioDto;
    private ControladorFormulario controladorFormulario;
    private Boolean validacionForm, usuarioGuardado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        regName = (EditText) findViewById(R.id.edRegName);
        regLastName = (EditText) findViewById(R.id.edRegLastName);
        regAdress = (EditText) findViewById(R.id.edRegAdress);
        regEmail = (EditText) findViewById(R.id.edRegEmail);
        regCity = (EditText) findViewById(R.id.edRegCity);
        regCellphone = (EditText) findViewById(R.id.edRegCellphone);
        regUser = (EditText) findViewById(R.id.edRegUserName);
        regPassword = (EditText) findViewById(R.id.edRegUserPassword);
        regPhoto = (ImageView) findViewById(R.id.imRegFoto);
        regSex = (Spinner) findViewById(R.id.edRegSex);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        formularioDto = new FormularioDTO();
        controladorFormulario = new ControladorFormulario(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formularioDto.setEditNombres(regName.getText().toString());
                formularioDto.setEditApellidos(regLastName.getText().toString());
                formularioDto.setEditDireccion(regAdress.getText().toString());
                formularioDto.setEditCorreo(regEmail.getText().toString());
                formularioDto.setEditCiudad(regCity.getText().toString());
                formularioDto.setEditCelular(regCellphone.getText().toString());
                formularioDto.setEditUsuario(regUser.getText().toString());
                formularioDto.setEditPassword(regPassword.getText().toString());
                formularioDto.setSpSexo(regSex.getSelectedItem().toString());
                validacionForm = controladorFormulario.validarFormulario(formularioDto);
                if (validacionForm){
                    usuarioGuardado= controladorFormulario.usuarioGuardarUsuario(formularioDto);
                }
            }
        });


    }

    @Override
    public void validarResultadoFormulario(String editText, String mensaje) {
        if(editText.contains("name")){
            regName.setError(mensaje);
            
        }if (editText.contains("lastname")){
            regLastName.setError(mensaje);
        }
        if (editText.contains("email")){
            regEmail.setError(mensaje);
        }
        if(editText.contains("city")){
            regCity.setError(mensaje);

        }if (editText.contains("cell")){
            regCellphone.setError(mensaje);
        }
        if(editText.contains("user")){
            regUser.setError(mensaje);

        }if (editText.contains("password")){
            regPassword.setError(mensaje);
        }

    }

    @Override
    public void respuestaGuardadoUsuario(Boolean respuesta) {
        if(respuesta){
            Toast.makeText(this,"datos guardados",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"datos no guardados",Toast.LENGTH_LONG).show();
        }

    }
}