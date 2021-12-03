package com.jhon89nbl.sprint.Controlador;

import com.jhon89nbl.sprint.FormularioInterfaz;
import com.jhon89nbl.sprint.Modelo.FormularioDTO;
import com.jhon89nbl.sprint.Modelo.UsuarioDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorFormulario implements FormularioInterfaz.Controlador{
    private final FormularioInterfaz.View view;

    public ControladorFormulario(FormularioInterfaz.View view){
        this.view = view;
    }

    @Override
    public Boolean validarFormulario(FormularioDTO formularioDTO) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(formularioDTO.getEditCorreo());
        String camposvacios ="init, ";
        if(formularioDTO.getEditNombres().trim().isEmpty()){
            camposvacios = camposvacios + "name,";
        }if (formularioDTO.getEditApellidos().trim().isEmpty()){
            camposvacios = camposvacios + "lastname, ";
        }if (formularioDTO.getSpSexo().trim().isEmpty()|| formularioDTO.getSpSexo().equals("SELECCIONE EL SEXO")){
            camposvacios = camposvacios + "sex, ";
        }if (formularioDTO.getEditCorreo().trim().isEmpty()|| mather.find()){
            camposvacios = camposvacios + "email, ";
        }if (formularioDTO.getEditCiudad().trim().isEmpty()){
            camposvacios = camposvacios + "city, ";
        }if (formularioDTO.getEditCelular().trim().isEmpty()){
            camposvacios = camposvacios + "cell, ";
        }if (formularioDTO.getEditUsuario().trim().isEmpty()|| formularioDTO.getEditUsuario().length()<5){
            camposvacios = camposvacios + "user, ";
        }if (formularioDTO.getEditPassword().trim().isEmpty()||formularioDTO.getEditPassword().length()<=5){
            camposvacios = camposvacios + "password, ";
        }

        if(camposvacios.equals("init, ")){
            return true;
        }else {
            view.validarResultadoFormulario(camposvacios,"Los campos no pueden estar vacios");
            return false;
        }

    }

    @Override
    public Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO) {
        if (formularioDTO!=null) {
            UsuarioDTO usuarioDTO = UsuarioDTO.getInstance();
            usuarioDTO.setNombre(formularioDTO.getEditNombres());
            usuarioDTO.setApellido(formularioDTO.getEditApellidos());
            usuarioDTO.setSexo(formularioDTO.getSpSexo());
            usuarioDTO.setDireccion(formularioDTO.getEditDireccion());
            usuarioDTO.setCorreo(formularioDTO.getEditCorreo());
            usuarioDTO.setCiudad(formularioDTO.getEditCiudad());
            usuarioDTO.setCelular(formularioDTO.getEditCelular());
            usuarioDTO.setUsuario(formularioDTO.getEditUsuario());
            usuarioDTO.setPassword(formularioDTO.getEditPassword());
            view.respuestaGuardadoUsuario(true);
            return true;
        }else {
            view.respuestaGuardadoUsuario(false);
            return false;
        }
    }
}
