package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.NVehiculosUsuarioDTO;
import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO;
import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO2;
import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioMiperfilDTO;
import pe.edu.upc.trabajoarquiweb.entities.Rol;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRolService;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;
    @Autowired
    private IRolService rS;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CLIENTE')")
    public List<UsuarioDTO2> listar() {
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO2.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();

        // Mapear DTO a entidad
        Usuario usuario = m.map(dto, Usuario.class);

        // Guardar usuario
        uS.insert(usuario); // no devuelve nada

        Rol rolCliente = new Rol();
        rolCliente.setRol("CLIENTE");
        rolCliente.setUser(usuario); // usar el original, no uno nuevo
        rS.insert(rolCliente);
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
    @DeleteMapping("/{id}")
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
    @GetMapping("/miperfil")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<UsuarioMiperfilDTO> obtenerMiPerfil() {
        // Obtener el username del token JWT
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscar al usuario por su username
        Usuario usuario = uS.findByUsername(username);

        // Construir manualmente el DTO sin exponer la contraseña
        UsuarioMiperfilDTO dto = new UsuarioMiperfilDTO();
        dto.setDni(usuario.getDni());
        dto.setNombres(usuario.getNombres());
        dto.setApellidos(usuario.getApellidos());
        dto.setDireccion(usuario.getDireccion());
        dto.setCorreo_electronico(usuario.getCorreo_electronico());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setEdad(usuario.getEdad());
        dto.setTelefono(usuario.getTelefono());
        dto.setUsername(usuario.getUsername());
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/miperfil")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizarMiPerfil(@RequestBody UsuarioMiperfilDTO dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = uS.findByUsername(username);
        // Actualizamos solo los campos permitidos
        usuario.setDni(dto.getDni());
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setDireccion(dto.getDireccion());
        usuario.setCorreo_electronico(dto.getCorreo_electronico());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setEdad(dto.getEdad());
        usuario.setTelefono(dto.getTelefono());
        uS.update(usuario);
        return ResponseEntity.ok("Perfil actualizado correctamente");
    }


}
