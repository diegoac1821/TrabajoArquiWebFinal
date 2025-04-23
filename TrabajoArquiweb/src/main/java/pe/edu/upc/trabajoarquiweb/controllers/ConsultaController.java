package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.ConsultaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IConsultaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService cS;

    @GetMapping
    public List<ConsultaDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultaDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta a = m.map(dto, Consulta.class);
        cS.insert(a);
    }

    @PutMapping
    public void modificar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta a = m.map(dto, Consulta.class);
        cS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }
}
