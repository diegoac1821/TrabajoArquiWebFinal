package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from  Usuario u WHERE u.nombres like %:nombre%")
    public List<Usuario> buscar(@Param("nombre") String nombre);
}
