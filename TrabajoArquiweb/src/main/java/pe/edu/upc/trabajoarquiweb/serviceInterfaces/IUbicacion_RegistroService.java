package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;

import java.util.List;

public interface IUbicacion_RegistroService {
    public List<Ubicacion_Registro> list();
    public void insert(Ubicacion_Registro ubicacion);
    public void update(Ubicacion_Registro ubicacion);
    public void delete(int id);
    public List<String[]> ultimaUbicacionRegistrada();
}

