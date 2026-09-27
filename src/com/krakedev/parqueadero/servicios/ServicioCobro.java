package com.krakedev.parqueadero.servicios;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.krakedev.parqueadero.modelo.TicketCobro;
import com.krakedev.parqueadero.modelo.Vehiculo;

@Service

public class ServicioCobro {
	
    private final ServicioVehiculos servicioVehiculos;
    private ArrayList<TicketCobro> historicoTickets = new ArrayList<>();

    public ServicioCobro(ServicioVehiculos servicioVehiculos) {
        this.servicioVehiculos = servicioVehiculos;
    }

    public TicketCobro procesarSalida(String placa, int horas) {
        Vehiculo vehiculo = servicioVehiculos.retirarVehiculo(placa);
        if (vehiculo == null) {
        	
            return null;
        }

     
        double total = vehiculo.calcularTarifa(horas);
        
        String codigoAleatorio = "TCK-" + (int)(Math.random() * 900 + 100);

        TicketCobro ticket = new TicketCobro(codigoAleatorio, vehiculo, horas, total);
        historicoTickets.add(ticket);
        return ticket;
    }

    public double calcularTotalRecaudado() {
    	
        double totalRecaudado = 0;
        for (TicketCobro t : historicoTickets) {
        	
            totalRecaudado += t.getTotalPagar();
        }
        return totalRecaudado;
    }

    public ArrayList<TicketCobro> listarTickets() {
        return historicoTickets;
    }
}