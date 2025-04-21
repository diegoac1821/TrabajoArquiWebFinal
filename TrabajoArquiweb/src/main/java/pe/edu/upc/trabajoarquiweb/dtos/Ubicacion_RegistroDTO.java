package pe.edu.upc.trabajoarquiweb.dtos;

import jakarta.persistence.*;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;

import java.sql.Time;
import java.time.LocalDate;

public class Ubicacion_RegistroDTO {

    private int id;
    private String latitud;
    private String longitud;
    private LocalDate fecha;
    private Time hora;
    private Dispositivo_GPS disGPS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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

    public Dispositivo_GPS getDisGPS() {
        return disGPS;
    }

    public void setDisGPS(Dispositivo_GPS disGPS) {
        this.disGPS = disGPS;
    }
}
