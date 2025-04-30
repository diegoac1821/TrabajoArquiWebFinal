package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.util.List;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query(" select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = " insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


    @Query(value = "SELECT u.id, u.nombres, u.apellidos, COUNT(v.placa) AS cantidad_vehiculos\n" +
            " FROM Usuario u\n" +
            " LEFT JOIN Vehiculo v ON u.id = v.usuario.id  \n" +
            " GROUP BY u.id, u.nombres")
    List<String[]> cantidadVehiculosPorUsuario();

    @Query("SELECT u FROM Usuario u WHERE u.edad BETWEEN :min AND :max")
    List<Usuario> filtrarPorEdad(@Param("min") int min, @Param("max") int max);

}
