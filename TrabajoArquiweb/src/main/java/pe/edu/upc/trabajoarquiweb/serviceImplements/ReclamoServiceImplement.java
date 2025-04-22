package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;
import pe.edu.upc.trabajoarquiweb.repositories.IReclamoRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IReclamoService;

import java.util.List;

@Service
public class ReclamoServiceImplement implements IReclamoService {

    @Autowired
    private IReclamoRepository rR;

    @Override
        public List<Reclamo> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Reclamo r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Reclamo r) {
        rR.save(r);
    }
}
