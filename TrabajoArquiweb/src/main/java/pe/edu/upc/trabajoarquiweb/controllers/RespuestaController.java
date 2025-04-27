package pe.edu.upc.trabajoarquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.RespuestaDTO;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRepuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuestas")
public class  RespuestaController {

    @Autowired
    private IRepuestaService rrS;

    @GetMapping
    public List<RespuestaDTO> listar() {
        return rrS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RespuestaDTO.class);
        }).collect(Collectors.toList());
    }
        /*
    @PostMapping
    public void insertar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Respuesta r = m.map(dto, Respuesta.class);
        rrS.insert(r);
    }*/

    @GetMapping("/{id}")
    public RespuestaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RespuestaDTO dto = m.map(rrS.searchId(id), RespuestaDTO.class);
        return dto;
    }
    /*
        @PutMapping
        public void modificar(@RequestBody RespuestaDTO dto) {
            ModelMapper m = new ModelMapper();
            Respuesta r = m.map(dto, Respuesta.class);
            rrS.update(r);
        }

         */
    @DeleteMapping
    public void eliminar(@PathVariable("id") int id) {
        rrS.delete(id);
    }
}
