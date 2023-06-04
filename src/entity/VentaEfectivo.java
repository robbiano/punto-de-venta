package entity;

public class VentaEfectivo extends Venta{

    int efectivo;

    public VentaEfectivo(long id, double total, String medioDePago, Cliente cliente, Producto producto, Vendedor vendedor, int efectivo) {
        super(id, total, medioDePago, cliente, producto, vendedor);
        this.efectivo = efectivo;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }
}
