package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;

import java.util.List;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
    @Query(value = "SELECT\n" +
            "    u.nombres || ' ' || u.apellidos AS nombre_completo,\n" +
            "    COUNT(a.id) AS total_alertas\n" +
            "FROM\n" +
            "    Usuario u\n" +
            "JOIN\n" +
            "    Vehiculo v ON u.id = v.usuario\n" +
            "JOIN\n" +
            "    Alerta a ON v.placa = a.vehiculo\n" +
            "GROUP BY\n" +
            "    nombre_completo\n" +
            "ORDER BY\n" +
            "    total_alertas DESC\n",nativeQuery = true )
    public List<String[]> usersMoreAlert();
    @Query(value = "SELECT\n" +
            "    a.Tipo AS tipo_alerta,\n" +
            "    COUNT(*) AS total\n" +
            "FROM\n" +
            "    Alerta a\n" +
            "GROUP BY\n" +
            "    a.Tipo\n" +
            "ORDER BY\n" +
            "    total DESC",nativeQuery = true)
    public List<String[]> typeAlertmore();
}
