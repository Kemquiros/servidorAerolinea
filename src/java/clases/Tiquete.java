package clases;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tiquete")

public class Tiquete implements Serializable {

    @ManyToOne(optional = false, targetEntity = Pasajero.class)
    @JoinColumn(name = "pasajero", referencedColumnName = "cedula", insertable = false, updatable = false)
    private Pasajero pasajero1;

    @Column(name = "pasajero", table = "tiquete", nullable = false, length = 35)
    @Id
    private String pasajero;

    @ManyToOne(optional = false, targetEntity = Vuelo.class)
    @JoinColumn(name = "vuelo", referencedColumnName = "idVuelo", insertable = false, updatable = false)
    private Vuelo vuelo1;

    @Column(name = "vuelo", table = "tiquete", nullable = false)
    @Id
    private int vuelo;

    @Column(name = "reserva", table = "tiquete")
    @Basic
    private Boolean reserva;

    @Column(name = "paga", table = "tiquete")
    @Basic
    private Boolean paga;

    public Tiquete() {

    }

    public Pasajero getPasajero1() {
        return this.pasajero1;
    }

    public void setPasajero1(Pasajero pasajero1) {
        this.pasajero1 = pasajero1;
    }

    public String getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo1() {
        return this.vuelo1;
    }

    public void setVuelo1(Vuelo vuelo1) {
        this.vuelo1 = vuelo1;
    }

    public int getVuelo() {
        return this.vuelo;
    }

    public void setVuelo(int vuelo) {
        this.vuelo = vuelo;
    }

    public Boolean isReserva() {
        return this.reserva;
    }

    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }

    public Boolean isPaga() {
        return this.paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }
}
