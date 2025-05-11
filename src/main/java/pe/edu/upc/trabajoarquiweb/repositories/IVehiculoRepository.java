package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, String> {
    @Query("Select e from Vehiculo e where e.placa like %:placa%")
    public List<Vehiculo> buscarporplaca (@Param("placa")String placa);
    List<Vehiculo> findByUsuarioUsername(String username);
}
