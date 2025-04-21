package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Usuario usuario;
    @Column(name = "roleName", nullable = false,length = 20)
    private String role;

    public Rol() {}

    public Rol(Usuario usuario, String role) {
        this.usuario = usuario;
        this.role = role;
    }

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
