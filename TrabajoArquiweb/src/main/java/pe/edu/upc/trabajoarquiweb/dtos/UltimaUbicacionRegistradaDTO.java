package pe.edu.upc.trabajoarquiweb.dtos;

import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;

import java.sql.Time;
import java.time.LocalDate;

public class UltimaUbicacionRegistradaDTO {

    private String latitud;
    private String longitud;
    private LocalDate fecha;
    private Time hora;
    private int dispositivo_id;

    public int getDispositivo_id() {
        return dispositivo_id;
    }

    public void setDispositivo_id(int dispositivo_id) {
        this.dispositivo_id = dispositivo_id;
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
}
