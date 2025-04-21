package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {
}
