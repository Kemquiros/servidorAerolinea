package clases;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "aeropuerto", uniqueConstraints = @UniqueConstraint(columnNames = {"idAeropuerto"}))

public class Aeropuerto implements Serializable {

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "destino")
    private Collection<Vuelo> vueloCollection1;

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "origen")
    private Collection<Vuelo> vueloCollection;

    @Column(name = "idAeropuerto", table = "aeropuerto", nullable = false)
    @Id
    private Integer idAeropuerto;

    @Column(name = "nombre", table = "aeropuerto", nullable = false, length = 35)
    @Basic
    private String nombre;

    @ManyToOne(optional = false, targetEntity = Ciudad.class)
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    private Ciudad idCiudad;

    public Aeropuerto() {

    }

    public Collection<Vuelo> getVueloCollection1() {
        return this.vueloCollection1;
    }

    public void setVueloCollection1(Collection<Vuelo> vueloCollection1) {
        this.vueloCollection1 = vueloCollection1;
    }

    public Collection<Vuelo> getVueloCollection() {
        return this.vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public Integer getIdAeropuerto() {
        return this.idAeropuerto;
    }

    public void setIdAeropuerto(Integer idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }
}
