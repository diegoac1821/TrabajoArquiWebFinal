package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;

import java.util.List;

@Repository
public interface IUbicacion_RegistroRepository extends JpaRepository<Ubicacion_Registro, Integer> {

    @Query(value = "SELECT u.id AS dispositivo_id, u.latitud, u.longitud, u.fecha, u.hora\n" +
            "FROM ubicacion_registro u\n" +
            "INNER JOIN (\n" +
            "    SELECT idd, MAX(fecha || ' ' || hora) AS ultima_fecha\n" +
            "    FROM ubicacion_registro\n" +
            "    GROUP BY idd) ult ON u.idd = ult.idd \n" +
            "\tAND (u.fecha || ' ' || u.hora) = ult.ultima_fecha;",nativeQuery = true)
    public List<String[]> ultimaUbicacionRegistrada();
}
