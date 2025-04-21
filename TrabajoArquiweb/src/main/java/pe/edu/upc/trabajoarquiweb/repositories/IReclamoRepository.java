package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;

@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {
}
