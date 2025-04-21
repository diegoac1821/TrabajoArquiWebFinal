package pe.edu.upc.trabajoarquiweb.dtos;

import jakarta.persistence.*;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.sql.Time;
import java.time.LocalDate;

public class ConsultaDTO {

    private int id;
    private String consulta;
    private LocalDate fecha;
    private Time hora;
    private Usuario usuario;

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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
