package com.pruebaventas.ventasempresa.Dto;

public class VentasDto {

    private String name;

    private int sku;

    private double price;

    public VentasDto() {
    }

    public VentasDto(String name, int sku, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
