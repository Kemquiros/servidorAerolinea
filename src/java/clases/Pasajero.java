package clases;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pasajero", uniqueConstraints = @UniqueConstraint(columnNames = {"cedula"}))

public class Pasajero implements Serializable {

    @Column(name = "cedula", table = "pasajero", nullable = false, length = 35)
    @Id
    private String cedula;

    @Column(name = "usuario", table = "pasajero", nullable = false, length = 35)
    @Basic
    private String usuario;

    @Column(name = "contrasena", table = "pasajero", nullable = false, length = 35)
    @Basic
    private String contrasena;

    @Column(name = "nombre", table = "pasajero", nullable = false, length = 35)
    @Basic
    private String nombre;

    @OneToMany(targetEntity = Tiquete.class, mappedBy = "pasajero1")
    private Collection<Tiquete> tiqueteCollection;

    public Pasajero() {

    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Tiquete> getTiqueteCollection() {
        return this.tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }
}
