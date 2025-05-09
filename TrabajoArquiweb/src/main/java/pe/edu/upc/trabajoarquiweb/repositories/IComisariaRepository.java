package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Comisaria;

import java.util.List;

@Repository
public interface IComisariaRepository extends JpaRepository<Comisaria, Integer> {

    @Query(value = " SELECT * " +
            " FROM comisaria c " +
            " WHERE c.distrito = :distrito", nativeQuery = true)
    public List<String[]> buscarComisariaPorDistrito(@Param("distrito") String distrito);
    @Query(value="SELECT c.nombre AS nombre_comisaria, COUNT(d.id) AS cantidad_denuncias\n" +
            " FROM denuncia d\n" +
            " JOIN comisaria c ON d.id_comisaria = c.id\n" +
            " GROUP BY c.nombre\n" +
            " ORDER BY cantidad_denuncias DESC;",nativeQuery = true)
    public List<String[]>cantidaddenunciasporcomisaria();

}
