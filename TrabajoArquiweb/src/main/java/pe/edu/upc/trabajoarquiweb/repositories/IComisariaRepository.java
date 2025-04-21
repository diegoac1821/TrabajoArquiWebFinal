package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoarquiweb.entities.Comisaria;

public interface IComisariaRepository extends JpaRepository<Comisaria, Integer> {
}
