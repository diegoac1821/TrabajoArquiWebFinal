package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dni", nullable = false, length = 8)
    private int dni;
    @Column(name = "nombres", nullable = false, length = 20)
    private String nombres;
    @Column(name = "apellidos", nullable = false, length = 20)
    private String apellidos;
    @Column(name = "direccion", nullable = false, length = 20)
    private String direccion;
    @Column (name = "correo_electronico", nullable = false, length = 30)
    private String correo_electronico;
    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(name = "edad", nullable = false, length = 3)
    private int edad;
    @Column(name = "telefono", nullable = false, length = 9)
    private int telefono;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "usename", nullable = false, length = 30)
    private String usename;


    public Usuario() {}
    public Usuario(int id, int dni, String nombres, String apellidos, String direccion, String correo_electronico, LocalDate fechaNacimiento, int edad, int telefono, String password, String usename) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.password = password;
        this.usename = usename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }
}
