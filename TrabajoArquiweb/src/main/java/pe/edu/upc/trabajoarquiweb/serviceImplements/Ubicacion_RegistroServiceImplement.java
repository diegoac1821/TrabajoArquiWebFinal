package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;
import pe.edu.upc.trabajoarquiweb.repositories.IUbicacion_RegistroRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUbicacion_RegistroService;

import java.util.List;

@Service

public class Ubicacion_RegistroServiceImplement implements IUbicacion_RegistroService{

    @Autowired
    private IUbicacion_RegistroRepository ruS;

    @Override
    public List<Ubicacion_Registro> list() {
        return ruS.findAll();
    }

    @Override
    public void insert(Ubicacion_Registro rus) {
        ruS.save(rus);

    }

    @Override
    public void update(Ubicacion_Registro rus) {
        ruS.save(rus);

    }

    @Override
    public void delete(int id) {
        ruS.deleteById(id);

    }
}
