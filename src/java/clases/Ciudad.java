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
@Table(name = "ciudad", uniqueConstraints = @UniqueConstraint(columnNames = {"idCiudad"}))

public class Ciudad implements Serializable {

    @OneToMany(targetEntity = Aeropuerto.class, mappedBy = "idCiudad")
    private Collection<Aeropuerto> aeropuertoCollection;

    @Column(name = "nombre", table = "ciudad", nullable = false, length = 35)
    @Basic
    private String nombre;

    @Column(name = "idCiudad", table = "ciudad", nullable = false)
    @Id
    private Integer idCiudad;

    public Ciudad() {

    }

    public Collection<Aeropuerto> getAeropuertoCollection() {
        return this.aeropuertoCollection;
    }

    public void setAeropuertoCollection(Collection<Aeropuerto> aeropuertoCollection) {
        this.aeropuertoCollection = aeropuertoCollection;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }
}
