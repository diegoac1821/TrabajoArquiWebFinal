package pe.edu.upc.trabajoarquiweb.dtos.rol;

public class RolDTO {


    private Long id;

    private String rol;
    public RolDTO(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
