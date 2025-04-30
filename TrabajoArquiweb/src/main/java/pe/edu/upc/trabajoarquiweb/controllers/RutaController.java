package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.RutaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Ruta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRutaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private IRutaService rS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<RutaDTO> listar() {
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RutaDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody RutaDTO dto) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(dto, Ruta.class);
        rS.insert(r);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public RutaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RutaDTO dto = m.map(rS.searchId(id), RutaDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody RutaDTO dto) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(dto, Ruta.class);
        rS.update(r);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }
}
