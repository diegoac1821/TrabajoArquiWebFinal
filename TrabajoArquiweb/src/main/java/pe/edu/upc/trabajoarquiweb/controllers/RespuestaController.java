package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.respuesta.RespuestaDTO;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRepuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearerAuth")

public class  RespuestaController {

    @Autowired
    private IRepuestaService rrS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<RespuestaDTO> listar() {
        return rrS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RespuestaDTO.class);
        }).collect(Collectors.toList());
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public RespuestaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RespuestaDTO dto = m.map(rrS.searchId(id), RespuestaDTO.class);
        return dto;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public void eliminar(@PathVariable("id") int id) {
        rrS.delete(id);
    }
}
