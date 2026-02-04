package daw.entregas.clases;

import daw.entregas.enums.TipoReserva;

import java.time.LocalDate;

public class Reserva {
    //Atributos
    private String identificadorDeLaReserva;
    private String nombreDelCliente;
    private LocalDate fechaDeLaReserva;
    private TipoReserva tipoReserva;

    //Constructores
    public Reserva(String identificadorDeLaReserva, String nombreDelCliente, LocalDate fechaDeLaReserva, TipoReserva tipoReserva) {
        this.identificadorDeLaReserva = identificadorDeLaReserva;
        this.nombreDelCliente = nombreDelCliente;
        this.fechaDeLaReserva = fechaDeLaReserva;
        this.tipoReserva = tipoReserva;
    }
    //Getters y Setters

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String getIdentificadorDeLaReserva() {
        return identificadorDeLaReserva;
    }

    public void setIdentificadorDeLaReserva(String identificadorDeLaReserva) {
        this.identificadorDeLaReserva = identificadorDeLaReserva;
    }

    public LocalDate getFechaDeLaReserva() {
        return fechaDeLaReserva;
    }

    public void setFechaDeLaReserva(LocalDate fechaDeLaReserva) {
        this.fechaDeLaReserva = fechaDeLaReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    //ToString

    @Override
    public String toString() {
        return String.format("Reserva: %s, Fecha de la reserva: %s, Nombre del cliente: %s, Identificador de la reserva: %s",tipoReserva,fechaDeLaReserva,nombreDelCliente,identificadorDeLaReserva);
    }
}
