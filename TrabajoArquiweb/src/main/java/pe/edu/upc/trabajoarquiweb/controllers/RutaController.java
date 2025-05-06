package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.AlertaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.RutaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Ruta;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRutaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private IRutaService rS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<RutaDTO> listar() {
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RutaDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody RutaDTO dto) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(dto, Ruta.class);
        rS.insert(r);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public RutaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RutaDTO dto = m.map(rS.searchId(id), RutaDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody RutaDTO dto) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(dto, Ruta.class);
        rS.update(r);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/rutas_periodo_placa")
    public List<RutaDTO> rutas_periodo_placa(@RequestParam LocalDate fecha1, LocalDate fecha2,String placa) {
        List<String[]> filaLista=rS.RutasenPeriodo(fecha1,fecha2,placa);
        List<RutaDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            RutaDTO dto=new RutaDTO();
            dto.setDistancia(Integer.parseInt(columna[1]));
            dto.setDuracion(Integer.parseInt(columna[2]));
            dto.setFecha(LocalDate.parse(columna[3]));
            dto.setId(Integer.parseInt(columna[4]));
            dto.setDestinoLatitud(columna[5]);
            dto.setDestinoLongitud(columna[6]);
            dto.setOrigenLatitud(columna[7]);
            dto.setOrigenLongitud(columna[8]);
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca(columna[9]); // columna[4] = placa del vehículo
            dto.setVehiculo(vehiculo);
        }
        return dtoLista;
    }
}
