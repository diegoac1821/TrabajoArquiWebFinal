package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.CantidadConsultasPorUsuarioDTO;
import pe.edu.upc.trabajoarquiweb.dtos.consulta.ConsultaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IConsultaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService cS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<ConsultaDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultaDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta a = m.map(dto, Consulta.class);
        cS.insert(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta a = m.map(dto, Consulta.class);
        cS.update(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/cantidadconsultas")
    public List<CantidadConsultasPorUsuarioDTO> cantidadConsultasPorUsuario() {
        List<String[]> lista = cS.cantidadConsultasPorUsuario();
        List<CantidadConsultasPorUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CantidadConsultasPorUsuarioDTO dto = new CantidadConsultasPorUsuarioDTO();
            dto.setId(Integer.parseInt(columna[0]));
            dto.setNombres(columna[1]);
            dto.setApellidos(columna[2]);
            dto.setCantidadConsultas(Integer.parseInt(columna[3]));

            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
