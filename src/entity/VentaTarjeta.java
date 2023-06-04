package entity;

public class VentaTarjeta extends Venta{

    int numeroDeTarjeta;

    public VentaTarjeta(long id, double total, String medioDePago, Cliente cliente, Producto producto, Vendedor vendedor, int numeroDeTarjeta) {
        super(id, total, medioDePago, cliente, producto, vendedor);
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public int getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(int numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }
}
