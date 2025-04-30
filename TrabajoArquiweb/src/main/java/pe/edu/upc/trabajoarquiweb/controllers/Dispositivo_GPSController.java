package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.Dispositivo_GPSDTO;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDispositivo_GPSService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/gps")
public class Dispositivo_GPSController {
    @Autowired//Injeccion de dependencias
    private IDispositivo_GPSService dS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Dispositivo_GPSDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Dispositivo_GPSDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody Dispositivo_GPSDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo_GPS a = m.map(dto, Dispositivo_GPS.class);
        dS.insert(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody Dispositivo_GPSDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo_GPS a = m.map(dto, Dispositivo_GPS.class);
        dS.update(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }
}
