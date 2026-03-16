package FicherosCompra;

public class producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad += cantidad;
    }
    public double calculartotal(){
        return cantidad*precio;
    }
}
