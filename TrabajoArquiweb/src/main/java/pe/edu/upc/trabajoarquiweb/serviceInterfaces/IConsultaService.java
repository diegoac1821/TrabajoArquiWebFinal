package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Consulta;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;

import java.util.List;

public interface IConsultaService {
    public List<Consulta> list();
    public void insert(Consulta c);
    public void delete(int id);
    public void update(Consulta c);
}
