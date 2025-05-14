package pe.edu.upc.trabajoarquiweb.dtos.consulta;

import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO2;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaDTO {

    private int id;
    private String consulta;
    private LocalDate fecha;
    private LocalTime hora;
    private UsuarioDTO2 usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public UsuarioDTO2 getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO2 usuario) {
        this.usuario = usuario;
    }
}
