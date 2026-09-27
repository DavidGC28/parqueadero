package com.krakedev.parqueadero.modelo;

public class Auto extends Vehiculo {
	
	private int nuneroPuertas;
	
	public Auto(String placa, String propietario, int nuneroPuertas) {
		super(placa, propietario);
		this.nuneroPuertas = nuneroPuertas;
	}
	
	@Override
	public double calcularTarifa(int horasPermanencia) {
		double tarifaRegular = horasPermanencia * 1.50;
		if (horasPermanencia > 4) {
			return tarifaRegular + 2.00;
		}
		return tarifaRegular;
	}
	
	public int getNuneroPuertas(int nuneroPuertas) {
		return this.nuneroPuertas = nuneroPuertas;
	}

	@Override
	
	public String toString() {
		return "Auto /" + super.toString() + ", numero de Puertas = " + nuneroPuertas + "/";
		
	}
}
