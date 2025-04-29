package pe.edu.upc.trabajoarquiweb.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Denuncia;

import java.util.List;

@Repository
public interface IDenunciaRepository extends JpaRepository<Denuncia, Integer> {
    @Query("SELECT d FROM Denuncia d " +
            "JOIN FETCH d.comisaria " +
            "JOIN FETCH d.vehiculo " +
            "WHERE d.id = :id")
    List<Denuncia> buscarPorId(@Param("id") int id);

    }


