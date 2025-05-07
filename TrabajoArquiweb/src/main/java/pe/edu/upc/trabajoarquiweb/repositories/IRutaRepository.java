package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Ruta;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRutaRepository extends JpaRepository<Ruta, Integer> {
    @Query(value="SELECT *\n" +
            "FROM ruta r\n" +
            "WHERE r.placav = :placa and\n" +
            "r.fecha BETWEEN :fecha1 AND :fecha2",nativeQuery = true)
    public List<String[]> RutasenPeriodo(@Param("fecha1") LocalDate fecha1,
                                         @Param("fecha2") LocalDate fecha2,
                                         @Param("placa") String placa);
}
