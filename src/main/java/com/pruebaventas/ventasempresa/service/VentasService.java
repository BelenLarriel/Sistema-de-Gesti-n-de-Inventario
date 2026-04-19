package com.pruebaventas.ventasempresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaventas.ventasempresa.Dto.VentasDto;
import com.pruebaventas.ventasempresa.Entities.Ventas;
import com.pruebaventas.ventasempresa.repositories.VentasRepository;

@Service
public class VentasService {

    @Autowired
    public VentasRepository repository;

    public List<VentasDto> listaproductos() {

        List<Ventas> listar = repository.findAll();

        // stream es solo para listas OJO
        return listar.stream()

                .map(e -> new VentasDto(e.getName(), e.getSku(), e.getPrice(), e.getStock())).toList();

    }

    public VentasDto detalleobtiene(Long id) {

        // findById(id) devuleve un OPTIONAL<VENTAS>
        Ventas cajita = repository.findById(id)

                .orElseThrow(() -> new RuntimeException("No existe el id"));

        return new VentasDto(

                cajita.getName(),
                cajita.getSku(),
                cajita.getPrice(),
                cajita.getStock()

        );

    }

    public VentasDto enviarlo(VentasDto productosdos) {

        Ventas cajita = new Ventas();

        cajita.setName(productosdos.getName()); // get obtiene lo que yo coloco en el parametro en productosdos
        cajita.setSku(productosdos.getSku());// set guarda en cajita
        cajita.setPrice(productosdos.getPrice());
        cajita.setStock(productosdos.getStock());

        Ventas guardar = repository.save(cajita);

        return new VentasDto(

                guardar.getName(),
                guardar.getSku(),
                guardar.getPrice(),
                guardar.getStock()

        );

    }

    // //En el service del PUT haces esto:

    // 👉 Buscas el registro por ID en la base de datos
    // 👉 Si no existe, lanzas error (o lo manejas)
    // 👉 Si existe, actualizas los campos con los datos del DTO
    // 👉 Guardas nuevamente la entidad ya modificada
    // 👉 Devuelves el resultado actualizado

    // 💡 Idea clave:
    // “buscar → modificar → guardar otra vez”

    public VentasDto actualiza(Long id, VentasDto canjitados) {

        Ventas valor = repository.findById(id)

                .orElseThrow(() -> new RuntimeException("No existe el id"));

        // Ventas valordos = new Ventas();

        valor.setName(canjitados.getName()); // get obtiene lo que yo coloco en el parametro en productosdos
        valor.setSku(canjitados.getSku());// set guarda en cajita
        valor.setPrice(canjitados.getPrice());
        valor.setStock(canjitados.getStock());

        // no hace falta crear variable
        // valor ya está actualizado en memoria save() solo lo sincroniza con la BD
        repository.save(valor);

        return new VentasDto(

                valor.getName(),
                valor.getSku(),
                valor.getPrice(),
                valor.getStock()

        );

    }

    public void eliminado(Long id) {

        Optional<Ventas> cajita = repository.findById(id);

        if (cajita.isPresent())

            repository.deleteById(id);

    }

}
