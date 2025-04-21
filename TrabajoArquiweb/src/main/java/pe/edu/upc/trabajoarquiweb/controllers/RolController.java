package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.DenunciaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.RolDTO;
import pe.edu.upc.trabajoarquiweb.entities.Denuncia;
import pe.edu.upc.trabajoarquiweb.entities.Rol;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDenunciaService;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Rol")
public class RolController {

    @Autowired//Injeccion de dependencias
    private IRolService rS;

    @GetMapping
    public List<RolDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rS.insert(a);
    }

    @PutMapping
    public void modificar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.update(r);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }
}
