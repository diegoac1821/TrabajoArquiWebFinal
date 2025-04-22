package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Alerta;

import java.util.List;

public interface IAlertaService {
    public List<Alerta> list();
    public void insert(Alerta alerta);
    public void update(Alerta alerta);
    public void delete(int id);

}
