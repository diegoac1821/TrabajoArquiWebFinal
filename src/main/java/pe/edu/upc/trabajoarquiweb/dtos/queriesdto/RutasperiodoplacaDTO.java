package pe.edu.upc.trabajoarquiweb.dtos.queriesdto;

import java.time.LocalDate;

public class RutasperiodoplacaDTO {
    private int id;
    private String origenLatitud;
    private String origenLongitud;
    private String destinoLatitud;
    private String destinoLongitud;
    private LocalDate fecha;
    private int duracion;
    private int distancia;
    private String placa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigenLatitud() {
        return origenLatitud;
    }

    public void setOrigenLatitud(String origenLatitud) {
        this.origenLatitud = origenLatitud;
    }

    public String getOrigenLongitud() {
        return origenLongitud;
    }

    public void setOrigenLongitud(String origenLongitud) {
        this.origenLongitud = origenLongitud;
    }

    public String getDestinoLatitud() {
        return destinoLatitud;
    }

    public void setDestinoLatitud(String destinoLatitud) {
        this.destinoLatitud = destinoLatitud;
    }

    public String getDestinoLongitud() {
        return destinoLongitud;
    }

    public void setDestinoLongitud(String destinoLongitud) {
        this.destinoLongitud = destinoLongitud;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
