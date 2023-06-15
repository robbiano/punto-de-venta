package entity;

public class Venta {
    private  long id;
    private  double total;
    private  String medioDePago;
    private   Cliente cliente;
    private  Producto producto;
    private Vendedor vendedor;

    public Venta(long id, double total, String medioDePago, Cliente cliente, Producto producto, Vendedor vendedor) {
        this.id = id;
        this.total = total;
        this.medioDePago = medioDePago;
        this.cliente = cliente;
        this.producto = producto;
        this.vendedor = vendedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
