package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakedev.parqueadero.modelo.Auto;
import com.krakedev.parqueadero.modelo.Motocicleta;
import com.krakedev.parqueadero.modelo.Vehiculo;
import com.krakedev.parqueadero.servicios.ServicioVehiculos;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final ServicioVehiculos servicioVehiculos;

    public VehiculoController(ServicioVehiculos servicioVehiculos) {
        this.servicioVehiculos = servicioVehiculos;
    }

    @PostMapping("/auto")
    public ResponseEntity<String> ingresarAuto(@RequestBody Auto auto) {
        boolean exito = servicioVehiculos.ingresarVehiculo(auto);
        if (exito) {
            return new ResponseEntity<>("Auto ingresado exitosamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No se pudo ingresar el auto (Parqueadero lleno o placa duplicada)", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/moto")
    public ResponseEntity<String> ingresarMoto(@RequestBody Motocicleta moto) {
        boolean exito = servicioVehiculos.ingresarVehiculo(moto);
        if (exito) {
            return new ResponseEntity<>("Motocicleta ingresada exitosamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No se pudo ingresar la moto (Parqueadero lleno o placa duplicada)", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ArrayList<Vehiculo> listarVehiculos() {
        return servicioVehiculos.listarVehiculos();
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Vehiculo> buscarPorPlaca(@PathVariable String placa) {
        Vehiculo vehiculo = servicioVehiculos.buscarPorPlaca(placa);
        if (vehiculo != null) {
            return new ResponseEntity<>(vehiculo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}