package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class EstacionamientoTest {

    private Estacionamiento estacionamiento;

    @Before
    public void setUp() {
        estacionamiento = new Estacionamiento();
    }


    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Vehiculo v = new Vehiculo("KPA171", "Toyota", Vehiculo.Tipo.SUV);
        estacionamiento.ingresarVehiculo("2547", "stefano", v);


        Ticket ticket = estacionamiento.retirarVehiculo("KPA171");
        assertNotNull(ticket);
        assertNotNull(ticket.getHoraSalida());
        assertEquals("stefano", ticket.getCliente().getNombre());


    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente cliente = new Cliente("1456", "Felipe");
        Vehiculo vehiculo = new Vehiculo("SDF191", "Ka", Vehiculo.Tipo.AUTO);
        Ticket ticket = new Ticket(cliente, vehiculo);


        ticket.setHoraSalida(ticket.getHoraEntrada().plusMinutes(80));

        long minutos = ticket.calcularMinutos();
        assertEquals(80, minutos);

        double precio = ticket.calcularPrecio();
        assertEquals(100 * 2, precio, 0.01);



    }
}