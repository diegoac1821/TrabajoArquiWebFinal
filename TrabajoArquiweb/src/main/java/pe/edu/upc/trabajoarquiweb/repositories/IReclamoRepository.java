package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;

import java.util.List;

@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {
    @Query(value="SELECT *\n" +
            "FROM reclamo r \n" +
            "WHERE r.resuelto = false \n" ,nativeQuery = true)
    public List<String[]> reclamosinresolver();}
