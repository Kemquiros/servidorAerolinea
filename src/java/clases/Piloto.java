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
@Table(name = "piloto", uniqueConstraints = @UniqueConstraint(columnNames = {"cedula"}))

public class Piloto implements Serializable {

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "idPiloto")
    private Collection<Vuelo> vueloCollection;

    @Column(name = "cedula", table = "piloto", nullable = false, length = 35)
    @Id
    private String cedula;

    @Column(name = "salario", table = "piloto", nullable = false)
    @Basic
    private int salario;

    @Column(name = "nombre", table = "piloto", nullable = false, length = 35)
    @Basic
    private String nombre;

    public Piloto() {

    }

    public Collection<Vuelo> getVueloCollection() {
        return this.vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getSalario() {
        return this.salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
