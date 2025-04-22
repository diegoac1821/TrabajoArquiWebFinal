package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.UsuarioDTO;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.insert(u);
    }
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.searchId(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.update(u);
    }
    @DeleteMapping
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }
    @GetMapping("/busquedas")
    public List<UsuarioDTO> buscar(@RequestParam String n) {
        return uS.search(n).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
