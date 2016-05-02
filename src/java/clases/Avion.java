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
@Table(name = "avion", uniqueConstraints = @UniqueConstraint(columnNames = {"idAvion"}))

public class Avion implements Serializable {

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "idAvion")
    private Collection<Vuelo> vueloCollection;

    @Column(name = "idAvion", table = "avion", nullable = false)
    @Id
    private Integer idAvion;

    @Column(name = "nombre", table = "avion", nullable = false, length = 35)
    @Basic
    private String nombre;

    @Column(name = "capacidad", table = "avion", nullable = false)
    @Basic
    private int capacidad;

    public Avion() {

    }

    public Collection<Vuelo> getVueloCollection() {
        return this.vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public Integer getIdAvion() {
        return this.idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
