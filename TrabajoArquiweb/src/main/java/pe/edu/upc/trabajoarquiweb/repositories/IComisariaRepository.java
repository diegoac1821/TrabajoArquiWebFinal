package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Comisaria;

import java.util.List;

@Repository
public interface IComisariaRepository extends JpaRepository<Comisaria, Integer> {

    @Query(value = " SELECT c " +
            " FROM Comisaria c " +
            " WHERE c.distrito = :distrito", nativeQuery = true)
    public List<Comisaria> buscarComisariaPorDistrito(@Param("distrito") String distrito);
}
