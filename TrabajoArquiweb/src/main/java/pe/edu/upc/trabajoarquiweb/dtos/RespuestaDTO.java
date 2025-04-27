package pe.edu.upc.trabajoarquiweb.dtos;

import pe.edu.upc.trabajoarquiweb.entities.Consulta;

public class RespuestaDTO {

    private int id;
    private String texto;
    private Consulta consulta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
