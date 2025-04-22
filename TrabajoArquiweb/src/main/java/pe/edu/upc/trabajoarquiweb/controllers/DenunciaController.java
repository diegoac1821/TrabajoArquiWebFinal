package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.DenunciaDTO;

import pe.edu.upc.trabajoarquiweb.entities.Denuncia;

import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDenunciaService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired//Injeccion de dependencias
    private IDenunciaService dS;

    @GetMapping
    public List<DenunciaDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DenunciaDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Denuncia a = m.map(dto, Denuncia.class);
        dS.insert(a);
    }

    @PutMapping
    public void modificar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Denuncia a = m.map(dto, Denuncia.class);
        dS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }
}
