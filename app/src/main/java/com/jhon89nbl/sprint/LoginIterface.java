package com.jhon89nbl.sprint;

public interface LoginIterface {

    interface View{
       void validarConexion(String text, String mensaje);
       void usuarioValidado(Boolean validacion);
    }
    interface Controlador{
        Boolean validarLogin(String editText, String mensaje);
        Boolean usuarioPermitido(String usuario, String password);
    }
    interface Modelo{

    }
}
