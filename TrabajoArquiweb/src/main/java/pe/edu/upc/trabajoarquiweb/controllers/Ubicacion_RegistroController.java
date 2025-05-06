package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.CantidadConsultasPorUsuarioDTO;
import pe.edu.upc.trabajoarquiweb.dtos.Ubicacion_RegistroDTO;
import pe.edu.upc.trabajoarquiweb.dtos.UltimaUbicacionRegistradaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUbicacion_RegistroService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/ubicaciones")
public class Ubicacion_RegistroController {
    @Autowired//Injeccion de dependencias
    private IUbicacion_RegistroService ruS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Ubicacion_RegistroDTO> listar() {
        return ruS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Ubicacion_RegistroDTO.class);
        }).collect(Collectors.toList());

    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody Ubicacion_RegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion_Registro u = m.map(dto, Ubicacion_Registro.class);
        ruS.insert(u);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody Ubicacion_RegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion_Registro u = m.map(dto, Ubicacion_Registro.class);
        ruS.update(u);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        ruS.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/ultimoregistro")
    public List<UltimaUbicacionRegistradaDTO> ultimaUbicacionRegistrada() {
        List<String[]> lista = ruS.ultimaUbicacionRegistrada();
        List<UltimaUbicacionRegistradaDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            UltimaUbicacionRegistradaDTO dto = new UltimaUbicacionRegistradaDTO();

            dto.setDispositivo_id(Integer.parseInt(columna[0]));
            dto.setLatitud(columna[1]);
            dto.setLongitud(columna[2]);
            dto.setFecha(LocalDate.parse(columna[3]));
            dto.setHora(Time.valueOf(columna[4]));

            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
