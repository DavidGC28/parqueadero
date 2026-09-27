package com.krakedev.parqueadero.modelo;

public class Moto extends Vehiculo {
	private int cilindraje;
	
	public Moto(String placa, String propietario , int cilindraje) {
		super (placa, propietario);
		this.cilindraje =cilindraje;
		
				
	}
@Override
public double calcularTarifa(int horasPermanencia) {
	double costoHora = (cilindraje > 250) ? 1.00 : 0.75;
	return horasPermanencia * costoHora;
	
}

public int getCilindraje() {
 
	return cilindraje;
}

public void setCilindraje(int cilindraje) {
	this.cilindraje = cilindraje;
}

@Override

public String toString() {
	return "Moto /" + super.toString() + ", Cilindrajre = " + cilindraje + "/";
	
}
}
