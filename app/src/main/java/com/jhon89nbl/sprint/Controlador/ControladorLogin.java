package com.jhon89nbl.sprint.Controlador;

import com.jhon89nbl.sprint.LoginIterface;

public class ControladorLogin implements LoginIterface.Controlador {

    private final LoginIterface.View view;

    public ControladorLogin(LoginIterface.View view){
        this .view = view;
    }



    @Override
    public Boolean validarLogin(String editText, String indicador) {
        if (indicador.equals("usuario")) {
            if (editText.trim().isEmpty()) {
                view.validarConexion(indicador, "Los campos no pueden estar vacios");
                return false;
            } else if (editText.length() <= 4) {
                view.validarConexion(indicador, "Los campos no deben ser mayor o igual a 5");
                return false;
            }
        } else if (indicador.equals("password")) {
            if (editText.trim().isEmpty()) {
                view.validarConexion(indicador, "los campos no pueden estar vacios");
                return false;
            } else if (editText.length() <= 4) {
                view.validarConexion(indicador, "Los campos no deben ser mayor o igual a 5");
                return false;
            }
        }
        return true;
    }
    @Override
    public Boolean usuarioPermitido  (String usuario, String password) {
        if ("prueba".equals(usuario) && "12345".equals(password)){
            view.usuarioValidado(true);
            return true;
        }else {
            view.usuarioValidado(false);
            return false;
        }
    }

}


