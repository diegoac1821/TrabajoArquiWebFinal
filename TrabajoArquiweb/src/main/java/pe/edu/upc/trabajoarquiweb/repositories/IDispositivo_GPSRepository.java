package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;

@Repository
public interface IDispositivo_GPSRepository extends JpaRepository<Dispositivo_GPS, Integer> {
}
