package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;
import pe.edu.upc.trabajoarquiweb.repositories.IAlertaRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IAlertaService;

import java.util.List;

@Service
public class AlertaServiceImplement implements IAlertaService {
    @Autowired
    private IAlertaRepository aS;

    @Override
    public List<Alerta> list() {
        return aS.findAll();
    }

    @Override
    public void insert(Alerta as) {
        aS.save(as);

    }

    @Override
    public void update(Alerta as) {
        aS.save(as);

    }

    @Override
    public void delete(int id) {
        aS.deleteById(id);

    }
}
