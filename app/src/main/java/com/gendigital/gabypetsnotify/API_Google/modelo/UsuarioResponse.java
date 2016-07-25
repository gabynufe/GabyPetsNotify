package com.gendigital.gabypetsnotify.API_Google.modelo;


/**
 * Created by Gaby on 23/07/2016.
 * objeto para recibir datos del servicio
 */
public class UsuarioResponse {
    public String id_registro;
    public String id_dispositivo;
    public String id_usuario_instagram;


    public UsuarioResponse(String id_registro, String id_dispositivo, String id_usuario_instagram) {
        this.id_registro = id_registro;
        this.id_dispositivo = id_dispositivo;
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public UsuarioResponse() {
    }

    public String getIdRegistro() {
        return id_registro;
    }

    public void setIdRegistro(String id_registro) {
        this.id_registro = id_registro;
    }

    public String getIdDispositivo() {
        return id_dispositivo;
    }

    public void setIdDispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getIdUsuario() {
        return id_usuario_instagram;
    }

    public void setIdUsuario(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }
}
