package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> list();
    public void insert(Usuario usuario);
    public Usuario searchId(int id);
    public void update(Usuario usuario);
    public void delete(int id);
    public List<Usuario> search(String nombre);
    public List<String[]> cantidadVehiculosPorUsuario();

}
