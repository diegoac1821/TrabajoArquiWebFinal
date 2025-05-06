package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.AlertaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.TipoAlertaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.UsuarioConTotalAlertasDTO;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IAlertaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired//Injeccion de dependencias
    private IAlertaService aS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<AlertaDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlertaDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
       Alerta a = m.map(dto, Alerta.class);
        aS.insert(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
       Alerta a = m.map(dto,Alerta.class);
        aS.update(a);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        aS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/usuarios_maslertas")
    public List<UsuarioConTotalAlertasDTO> listarUsuariosMaslertas() {
        List<String[]> filaLista=aS.usersMoreAlert();
        List<UsuarioConTotalAlertasDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            UsuarioConTotalAlertasDTO dto=new UsuarioConTotalAlertasDTO();
            dto.setNombreCompleto(columna[0]);
            dto.setTotalAlertas(Long.parseLong(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/alertas_mas_tipo")
    public List<TipoAlertaDTO> listarAlertasMasTipo() {
        List<String[]> filaLista=aS.typeAlertmore();
        List<TipoAlertaDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            TipoAlertaDTO dto=new TipoAlertaDTO();
            dto.setTipoAlerta(columna[0]);
            dto.setTotal(Long.parseLong(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
