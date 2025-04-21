package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoarquiweb.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
