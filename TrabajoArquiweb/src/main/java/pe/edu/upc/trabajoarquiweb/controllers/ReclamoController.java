package pe.edu.upc.trabajoarquiweb.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.ReclamoResueltosDTO;
import pe.edu.upc.trabajoarquiweb.dtos.reclamo.ReclamoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IReclamoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {
    @Autowired
    private IReclamoService rS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<ReclamoDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReclamoDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo a = m.map(dto, Reclamo.class);
        rS.insert(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo a = m.map(dto, Reclamo.class);
        rS.update(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reclamossinresolver")
    public List<ReclamoResueltosDTO> reclamossinresolver() {
        List<String[]> filaLista = rS.reclamosinresolver();
        List<ReclamoResueltosDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            ReclamoResueltosDTO dto = new ReclamoResueltosDTO();
            dto.setFecha(LocalDate.parse(columna[0]));
            dto.setId(Integer.parseInt(columna[1]));
            dto.setUsuario(Integer.parseInt(columna[2]));
            dto.setResuelto(Boolean.parseBoolean(columna[3]));
            dto.setAsunto(columna[4]);
            dto.setDescripcion(columna[5]);
            dtoLista.add(dto);
        }
        return dtoLista;

    }
}