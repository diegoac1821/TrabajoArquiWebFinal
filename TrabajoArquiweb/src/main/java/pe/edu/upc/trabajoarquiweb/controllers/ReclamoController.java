package pe.edu.upc.trabajoarquiweb.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.ReclamoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IReclamoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {
    @Autowired
    private IReclamoService rS;

    @GetMapping
    public List<ReclamoDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReclamoDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo a = m.map(dto, Reclamo.class);
        rS.insert(a);
    }

    @PutMapping
    public void modificar(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo a = m.map(dto, Reclamo.class);
        rS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }
}
