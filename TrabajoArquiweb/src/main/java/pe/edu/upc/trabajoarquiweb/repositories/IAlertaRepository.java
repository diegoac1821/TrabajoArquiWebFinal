package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
    @Query(value = "SELECT u.nombres || ' ' || u.apellidos AS nombre_completo, \n" +
            "COUNT(a.id) AS total_alertas \n" +
            "FROM usuario u \n" +
            "JOIN vehiculo v ON u.id = v.id_user \n" +
            "JOIN alerta a ON v.placa = a.placa \n" +
            "GROUP BY nombre_completo ORDER BY total_alertas DESC;",nativeQuery = true )
    public List<String[]> usersMoreAlert();

    @Query(value="SELECT * \n" +
            "FROM alerta\n" +
            "WHERE fecha BETWEEN :fecha1 AND :fecha2;",nativeQuery = true)
    public List<String[]> fechaAlertmore(@Param("fecha1") LocalDate fecha1,
                                         @Param("fecha2") LocalDate fecha2);
    @Query(value="SELECT a.*\n" +
            "FROM alerta a\n" +
            "JOIN vehiculo v ON a.placa = v.placa\n" +
            "  WHERE v.placa = :placa \n",nativeQuery = true)
    public List<String[]> placaAlert(@Param("placa") String placa);

    List<Alerta> findByVehiculoUsuarioUsername(String username);

}
