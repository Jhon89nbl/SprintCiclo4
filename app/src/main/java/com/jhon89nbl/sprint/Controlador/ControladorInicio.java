package com.jhon89nbl.sprint.Controlador;

import com.jhon89nbl.sprint.InicioInterface;

public class ControladorInicio implements InicioInterface.Controlador{
    private final InicioInterface.View view;

    public ControladorInicio(InicioInterface.View view){
        this.view = view;
    }

    @Override
    public void recuperarLista() {

    }

    @Override
    public void salirApp() {

    }
}
