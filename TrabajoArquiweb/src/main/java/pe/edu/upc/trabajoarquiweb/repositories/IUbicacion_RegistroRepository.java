package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;
@Repository
public interface IUbicacion_RegistroRepository extends JpaRepository<Ubicacion_Registro, Integer> {
}
