package pe.edu.upc.trabajoarquiweb.dtos;

public class RolDTO {

    private Usuario usuario;
    private String role;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
