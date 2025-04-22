package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.AlertaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired//Injeccion de dependencias
    private IAlertaService aS;

    @GetMapping
    public List<AlertaDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlertaDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
       Alerta a = m.map(dto, Alerta.class);
        aS.insert(a);
    }

    @PutMapping
    public void modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
       Alerta a = m.map(dto,Alerta.class);
        aS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        aS.delete(id);
    }
}
