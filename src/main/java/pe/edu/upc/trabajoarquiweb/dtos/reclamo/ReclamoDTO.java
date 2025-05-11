package pe.edu.upc.trabajoarquiweb.dtos.reclamo;

import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.time.LocalDate;

public class ReclamoDTO {

    private int id;
    private String asunto;
    private LocalDate fecha;
    private String descripcion;
    private Boolean resuelto;
    private Usuario usuario;

    public Boolean getResuelto() {
        return resuelto;
    }

    public void setResuelto(Boolean resuelto) {
        this.resuelto = resuelto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
