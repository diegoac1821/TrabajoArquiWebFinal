package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.VehiculoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IVehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired//Injeccion de dependencias
    private IVehiculoService vS;

    @GetMapping
    public List<VehiculoDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VehiculoDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    public void insertar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo a = m.map(dto, Vehiculo.class);
        vS.insert(a);
    }

    @PutMapping
    public void modificar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo a = m.map(dto, Vehiculo.class);
        vS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") String id) {
        vS.delete(id);
    }

    @GetMapping("/busquedaporplaca")
    public List<VehiculoDTO> buscarporplaca(@RequestParam String placa) {
        return vS.buscarporplaca(placa).stream().map(v->{
            ModelMapper m = new ModelMapper();
            return m.map(v, VehiculoDTO.class);
        }).collect(Collectors.toList());
    }
}
