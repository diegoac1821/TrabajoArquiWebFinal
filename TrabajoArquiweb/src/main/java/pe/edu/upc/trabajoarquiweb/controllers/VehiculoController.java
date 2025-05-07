package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.VehiculoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IVehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired//Injeccion de dependencias
    private IVehiculoService vS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<VehiculoDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VehiculoDTO.class);
        }).collect(Collectors.toList());

    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo a = m.map(dto, Vehiculo.class);
        vS.insert(a);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo a = m.map(dto, Vehiculo.class);
        vS.update(a);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{placa}")
    public void eliminar(@PathVariable("placa") String placa) {
        vS.delete(placa);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/busquedaporplaca")
    public List<VehiculoDTO> buscarporplaca(@RequestParam String placa) {
        return vS.buscarporplaca(placa).stream().map(v->{
            ModelMapper m = new ModelMapper();
            return m.map(v, VehiculoDTO.class);
        }).collect(Collectors.toList());
    }
}
