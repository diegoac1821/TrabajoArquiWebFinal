package pe.edu.upc.trabajoarquiweb.dtos;

import jakarta.persistence.*;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;

import java.time.LocalDate;

public class AlertaDTO {
    private int id;
    private String asunto;
    private LocalDate fecha;
    private String descripcion;
    private Vehiculo vehiculo;

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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
