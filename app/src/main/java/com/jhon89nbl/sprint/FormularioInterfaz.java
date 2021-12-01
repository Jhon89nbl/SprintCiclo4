package com.jhon89nbl.sprint;

import com.jhon89nbl.sprint.Modelo.FormularioDto;

public interface FormularioInterfaz {
    interface View{
        void validarResultadoFormulario(String editText, String mensaje);
        void respuestaGuardadoUsuario(Boolean respuesta);
    }
    interface  Controlador{
        Boolean validarFormulario(FormularioDto formularioDto);
        Boolean usuarioGuardarUsuario(FormularioDto formularioDto);

    }
    interface Modelo{

    }
}
