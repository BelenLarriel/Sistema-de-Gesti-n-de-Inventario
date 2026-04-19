package com.pruebaventas.ventasempresa.Dto;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class VentasDto {

    @NotBlank(message = "El campo no puede estar vacio ")
    @NotNull(message = "El campo no puede ser null")
    @Size(min = 3, max = 10)
    private String name;

    // Pattern \d = un número del 0 al 9
    // \\d+ = muchos números seguidos

    @Pattern(regexp = "PROD- \\d+", message = "El formato no es el correcto")
    private String sku;

    @PositiveOrZero(message = "El precio debe ser un numero positivo mayor  a cero")
    private double price;

    @Negative(message = "No puede ser negativo")
    private int stock;

    public VentasDto() {
    }

    public VentasDto(String name, String sku, double price, int stock) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
