package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Denuncia;
import pe.edu.upc.trabajoarquiweb.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol rol);
    public void update(Rol rol);
    public void delete(int id);
}
