package pe.edu.upc.trabajoarquiweb.controllers;

    import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
    import pe.edu.upc.trabajoarquiweb.dtos.NVehiculosUsuarioDTO;
    import pe.edu.upc.trabajoarquiweb.dtos.UsuarioDTO;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUsuarioService;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @GetMapping("/cantidadvehiculosusuario")
    public List<NVehiculosUsuarioDTO> listarCantidadVehiculosPorUsuario(){
        List<String[]> ealista=uS.cantidadVehiculosPorUsuario();
        List<NVehiculosUsuarioDTO> dtoLista=new ArrayList<>();
        for (String[] columna : ealista) {
                NVehiculosUsuarioDTO uDTO = new NVehiculosUsuarioDTO();
                uDTO.setId(Integer.parseInt(columna[0]));
                uDTO.setNombres(columna[1]);
                uDTO.setListaVehiculosPorUsuario(Integer.parseInt(columna[2]));
                dtoLista.add(uDTO);
        }
        return dtoLista;
    }
}
