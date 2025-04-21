package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;
@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
}
