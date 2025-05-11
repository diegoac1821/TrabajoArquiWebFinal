package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Rol;
import pe.edu.upc.trabajoarquiweb.repositories.IRolRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll() ;
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }


}
