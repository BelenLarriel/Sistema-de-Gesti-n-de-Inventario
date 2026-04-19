package com.pruebaventas.ventasempresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pruebaventas.ventasempresa.Dto.VentasDto;
import com.pruebaventas.ventasempresa.service.VentasService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")

public class VentasController {

    @Autowired
    public VentasService service;

    // GET /api/products: Listar todos.
    // GET /api/products/{id}: Obtener detalle.
    // POST /api/products: Crear
    // PUT /api/products/{id}: Actualizar
    // DELETE /api/products/{id}: Borrar.

    @GetMapping("/products")
    public List<VentasDto> listar() {

        return service.listaproductos();

    }

    @GetMapping("/products/{id}")
    public VentasDto obtenerdetalle(@PathVariable(name = "id") Long id) {

        return service.detalleobtiene(id);

    }

    @PostMapping("/produtos")
    public VentasDto enviar(@Valid @RequestBody VentasDto productosdos) {
        // TODO: process POST request

        return service.enviarlo(productosdos);
    }

    // PUT /api/products/{id}: Actualizar

    @PutMapping("products/{id}")
    public VentasDto Actualizar(@PathVariable Long id, @RequestBody VentasDto cajitados) {
        // TODO: process PUT request

        return service.actualiza(id, cajitados);

    }

    // DELETE /api/products/{id}: Borrar.
    @DeleteMapping("/products/{id}")
    public String Eliminar(@PathVariable(name = "id") Long id) {

        service.eliminado(id);

        return "Eliminado";

    }

}
