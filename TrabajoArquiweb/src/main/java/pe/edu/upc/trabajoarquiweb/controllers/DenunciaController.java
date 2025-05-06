package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.AlertaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.DenunciaDTO;

import pe.edu.upc.trabajoarquiweb.entities.Comisaria;
import pe.edu.upc.trabajoarquiweb.entities.Denuncia;

import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDenunciaService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired//Injeccion de dependencias
    private IDenunciaService dS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<DenunciaDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DenunciaDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Denuncia a = m.map(dto, Denuncia.class);
        dS.insert(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Denuncia a = m.map(dto, Denuncia.class);
        dS.update(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscar/{id}")
    public List<DenunciaDTO> buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return dS.buscarDenunciaPorId(id).stream()
                .map(x -> m.map(x, DenunciaDTO.class))
                .collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscarporestado")
    public List<DenunciaDTO> buscarporestado(@RequestParam String estado) {
        List<String[]> filaLista=dS.buscarPorEstado(estado);
        List<DenunciaDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            DenunciaDTO dto=new DenunciaDTO();
            dto.setId(Integer.parseInt(columna[0]));
            Comisaria comisaria = new Comisaria();
            comisaria.setId(Integer.parseInt(columna[1]));
            dto.setEstado(columna[2]);
            dto.setMotivo(columna[3]);
            dto.setDescripcion(columna[4]);
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca(columna[5]); // columna[4] = placa del vehículo
            dto.setVehiculo(vehiculo);
        }
        return dtoLista;
    }



}
