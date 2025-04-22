package pe.edu.upc.trabajoarquiweb.serviceImplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Denuncia;
import pe.edu.upc.trabajoarquiweb.repositories.IDenunciaRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDenunciaService;

import java.util.List;

@Service
public class DenunciaServiceImplement implements IDenunciaService {
    @Autowired
    private IDenunciaRepository dR;//(metodo)

    @Override
    public List<Denuncia> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Denuncia v) {
        dR.save(v);
    }

    @Override
    public void update(Denuncia v) {
        dR.save(v);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);}
}
