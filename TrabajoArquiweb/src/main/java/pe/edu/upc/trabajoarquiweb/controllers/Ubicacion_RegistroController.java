package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.Ubicacion_RegistroDTO;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUbicacion_RegistroService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/ubicaciones")
public class Ubicacion_RegistroController {
    @Autowired//Injeccion de dependencias
    private IUbicacion_RegistroService ruS;

    @GetMapping
    public List<Ubicacion_RegistroDTO> listar() {
        return ruS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Ubicacion_RegistroDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody Ubicacion_RegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion_Registro u = m.map(dto, Ubicacion_Registro.class);
        ruS.insert(u);
    }

    @PutMapping
    public void modificar(@RequestBody Ubicacion_RegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion_Registro u = m.map(dto, Ubicacion_Registro.class);
        ruS.update(u);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        ruS.delete(id);
    }
}
