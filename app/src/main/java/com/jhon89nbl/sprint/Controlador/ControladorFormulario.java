package com.jhon89nbl.sprint.Controlador;

import com.jhon89nbl.sprint.FormularioInterfaz;
import com.jhon89nbl.sprint.Modelo.FormularioDto;

public class ControladorFormulario implements FormularioInterfaz.Controlador{
    private final FormularioInterfaz.View view;

    public ControladorFormulario(FormularioInterfaz.View view){
        this.view = view;
    }

    @Override
    public Boolean validarFormulario(FormularioDto formularioDto) {
        return null;
    }

    @Override
    public Boolean usuarioGuardarUsuario(FormularioDto formularioDto) {
        return null;
    }
}
