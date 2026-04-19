package com.pruebaventas.ventasempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaventas.ventasempresa.Entities.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long> {

}