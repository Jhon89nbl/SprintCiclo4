package com.jhon89nbl.sprint;

import com.jhon89nbl.sprint.Modelo.FormularioDTO;

public interface FormularioInterfaz {
    interface View{
        void validarResultadoFormulario(String editText, String mensaje);
        void respuestaGuardadoUsuario(Boolean respuesta);
    }
    interface  Controlador{
        Boolean validarFormulario(FormularioDTO formularioDTO);
        Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO);

    }
    interface Modelo{

    }
}
