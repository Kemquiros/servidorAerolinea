package clases;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "vuelo", uniqueConstraints = @UniqueConstraint(columnNames = {"idVuelo"}))

public class Vuelo implements Serializable {

    @Column(name = "precio", table = "vuelo", nullable = false)
    @Basic
    private int precio;

    @Column(name = "hora", table = "vuelo", nullable = false)
    @Temporal(TemporalType.TIME)
    @Basic
    private Date hora;

    @ManyToOne(optional = false, targetEntity = Avion.class)
    @JoinColumn(name = "idAvion", referencedColumnName = "idAvion")
    private Avion idAvion;

    @ManyToOne(optional = false, targetEntity = Piloto.class)
    @JoinColumn(name = "idPiloto", referencedColumnName = "cedula")
    private Piloto idPiloto;

    @Column(name = "idVuelo", table = "vuelo", nullable = false)
    @Id
    private Integer idVuelo;

    @ManyToOne(optional = false, targetEntity = Aeropuerto.class)
    @JoinColumn(name = "origen", referencedColumnName = "idAeropuerto")
    private Aeropuerto origen;

    @ManyToOne(optional = false, targetEntity = Aeropuerto.class)
    @JoinColumn(name = "destino", referencedColumnName = "idAeropuerto")
    private Aeropuerto destino;

    @Column(name = "dia", table = "vuelo", nullable = false)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dia;

    @OneToMany(targetEntity = Tiquete.class, mappedBy = "vuelo1")
    private Collection<Tiquete> tiqueteCollection;

    public Vuelo() {

    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getHora() {
        return this.hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Avion getIdAvion() {
        return this.idAvion;
    }

    public void setIdAvion(Avion idAvion) {
        this.idAvion = idAvion;
    }

    public Piloto getIdPiloto() {
        return this.idPiloto;
    }

    public void setIdPiloto(Piloto idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Integer getIdVuelo() {
        return this.idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Aeropuerto getOrigen() {
        return this.origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return this.destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Date getDia() {
        return this.dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Collection<Tiquete> getTiqueteCollection() {
        return this.tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }

    /*@Override
    public String toString() {
        return "Vuelo[" + "precio=" + precio + ", hora=" + hora + ", idAvion=" + idAvion + ", idPiloto=" + idPiloto + ", idVuelo=" + idVuelo + ", origen=" + origen + ", destino=" + destino + ", dia=" + dia + ']';
    }*/
    @Override
     public String toString() {
        return "{" + "'precio':'" + precio + "', 'idAvion':'" + idAvion.getNombre() + "', 'piloto':'" + idPiloto.getNombre() + "', 'vuelo':'" + idVuelo + "', 'origen':'" + origen.getNombre() + "', 'destino':'" + destino.getNombre() +  "'}";
    }

    
}
