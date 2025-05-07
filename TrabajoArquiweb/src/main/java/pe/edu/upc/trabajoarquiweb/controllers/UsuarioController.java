package pe.edu.upc.trabajoarquiweb.controllers;

    import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
    import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.NVehiculosUsuarioDTO;
    import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUsuarioService;

    import java.util.ArrayList;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.insert(u);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UsuarioDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.searchId(id), UsuarioDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.update(u);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }
    @GetMapping("/busquedas")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> buscar(@RequestParam String n) {
        return uS.search(n).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidadvehiculosusuario")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @GetMapping("/filtrar-edad")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> filtrarPorEdad(@RequestParam("min") int min, @RequestParam("max") int max) {
        ModelMapper m = new ModelMapper();
        return uS.filtrarUsuariosPorEdad(min, max).stream()
                .map(u -> m.map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

}
