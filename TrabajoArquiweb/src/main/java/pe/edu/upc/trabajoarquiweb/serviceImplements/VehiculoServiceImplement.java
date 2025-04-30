package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.repositories.IVehiculoRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IVehiculoService;

import java.util.List;

@Service
public class VehiculoServiceImplement implements IVehiculoService {
    @Autowired
    private IVehiculoRepository vR;//(metodo)

    @Override
    public List<Vehiculo> list() {
        return vR.findAll();
    }

    @Override
    public void insert(Vehiculo v) {
        vR.save(v);
    }

    @Override
    public void update(Vehiculo v) {
        vR.save(v);
    }

    @Override
    public void delete(String id) {
        vR.deleteById(id);//aR es el enlace
    }

    @Override
    public List<Vehiculo> buscarporplaca(String placa) {
        return vR.buscarporplaca(placa);
    }
}
