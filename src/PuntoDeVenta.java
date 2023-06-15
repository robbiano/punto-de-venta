import entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PuntoDeVenta {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        //id de venta
        long ventaId = 1;

        ArrayList<Venta> ventas = new ArrayList<>(); // ArrayList para almacenar las ventas
        ArrayList<Producto> listaProductos = new ArrayList<>(); // ArrayList para almacenar productos
        ArrayList<Vendedor> vendedores = new ArrayList<>(); // ArrayList para almacenar vendedores
        ArrayList<Cliente> clientes = new ArrayList<>(); // ArrayList para almacenar clientes

        // Creación de productos
        Producto producto1 = new Producto(1, "Galaxy A12", 90000);
        Producto producto2 = new Producto(2, "Galaxy A13", 85000);
        Producto producto3 = new Producto(3, "Galaxy S23", 519000);
        Producto producto4 = new Producto(4, "Galaxy A54", 214000);

        // Agregar productos a la lista
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);

        // Creación de vendedores
        Vendedor vendedor1 = new Vendedor(1,"Leonardo", "Robbiano", 28343000);
        Vendedor vendedor2 = new Vendedor(2,"Jorge", "Tuvoreff", 85777000);
        Vendedor vendedor3 = new Vendedor(3,"Gabriel", "Zurschmitten", 5169000);
        Vendedor vendedor4 = new Vendedor(4,"Lucas", "Díaz\n", 21784000);

        // Agregar vendedores a la lista
        vendedores.add(vendedor1);
        vendedores.add(vendedor2);
        vendedores.add(vendedor3);
        vendedores.add(vendedor4);

        // Menú
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("*              Bienvenido              *");
        System.out.println("****************************************");

        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Por favor ingrese una opción: ");
            System.out.println("1- NUEVA VENTA");
            System.out.println("2- OBTENER TOTAL");
            System.out.println("3- SALIR");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("*****************************************");
                    System.out.println("*             Nueva venta               *");
                    System.out.println("*****************************************");
                    System.out.println();

                    // Se pide el tipo de pago
                    System.out.print("Introduce el tipo de pago\n");
                    System.out.print("1-Tarjeta\n");
                    System.out.print("2-efectivo");
                    int tipoPago = scanner.nextInt();
                    scanner.nextLine();

                    // Se pide el ID del vendedor
                    System.out.print("Introduce el ID del vendedor: ");
                    int idVendedor = scanner.nextInt();
                    scanner.nextLine();

                    // Buscar vendedor por ID
                    Vendedor ventaVendedor = null;
                    for (Vendedor vendedor : vendedores) {
                        if (vendedor.getId() == idVendedor) {
                            ventaVendedor = vendedor;
                            System.out.println("Vendedor: " + vendedor.getNombre());
                            break;
                        }
                    }

                    // Se pide el ID del producto
                    System.out.print("Introduce el ID del producto: ");
                    int idProducto = scanner.nextInt();
                    scanner.nextLine();

                    // Buscar producto por ID
                    Producto ventaProducto = null;
                    for (Producto producto : listaProductos) {
                        if (producto.getId() == idProducto) {
                            ventaProducto = producto;
                            System.out.println("Producto: " + producto.getDescripcion());
                            System.out.println("Valor: $" + producto.getValor());
                            break;
                        }
                    }

                    // Se piden los datos del cliente
                    System.out.print("Introduce el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();

                    System.out.print("Introduce el apellido del cliente: ");
                    String apellidoCliente = scanner.nextLine();

                    System.out.print("Introduce el DNI del cliente: ");
                    int dniCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente ventaCliente = new Cliente(1, nombreCliente, apellidoCliente, dniCliente);

                    String metodoPago ="";
                    if(tipoPago == 1){
                        // Crear instancia de VentaTarjeta
                        VentaTarjeta ventaTarjeta = new VentaTarjeta( ventaId, ventaProducto.getValor(), "Tarjeta", ventaCliente, ventaProducto, ventaVendedor, 54433440);
                        ventas.add(ventaTarjeta);
                        metodoPago = "Tarjeta";
                        ventaId++;
                    }else{
                        // Crear instancia de VentaEfectivo
                        VentaEfectivo ventaEfectivo = new VentaEfectivo(ventaId, ventaProducto.getValor(), "efectivo", ventaCliente, ventaProducto, ventaVendedor, 5000);
                        ventas.add(ventaEfectivo);
                        metodoPago = "Efectivo";
                        ventaId++;
                    }

                    for (Venta venta : ventas) {
                        System.out.println("\n");
                        System.out.println("Detalle de la venta:");
                        System.out.println("ID de venta: " + venta.getId());
                        System.out.println("Cliente: " + venta.getCliente().getNombre() + " " + venta.getCliente().getApellido());
                        System.out.println("Vendedor: " + venta.getVendedor().getNombre() + " " + venta.getVendedor().getApellido());
                        System.out.println("Producto: " + venta.getProducto().getDescripcion());
                        System.out.println("Total de venta: $" + venta.getTotal());
                        System.out.println("\n");
                    }

                    // Imprimir el ticket de compra
                    System.out.println("---------------------------------------");
                    System.out.println("            Samsung Store              ");
                    System.out.println("         www.samsungstore.com          ");
                    System.out.println("");
                    System.out.println("Vendedor: " + ventaVendedor.getNombre());
                    System.out.println("---------------------------------------");
                    System.out.printf("%-15s %10s %n", "Producto", "Precio");
                    System.out.printf("%-15s %10s %n", "--------", "-------");
                    System.out.printf("%-15s %10.2f %n", ventaProducto.getDescripcion(), ventaProducto.getValor());
                    System.out.println("\n");
                    System.out.printf("%-15s %10.2f %n", "Total", ventaProducto.getValor());
                    System.out.printf("%-15s %s %n", "Metodo de pago", metodoPago);
                    System.out.println("---------------------------------------");
                    System.out.println(" * * * * Gracias por su compra * * * * ");
                    System.out.println("---------------------------------------");
                    System.out.println("\n");
                    break;
                case 2:
                    // Obtener el total de las ventas y mostrarlo por consola
                    double totalVentas = 0;
                    for (Venta venta : ventas) {
                        totalVentas += venta.getTotal();
                    }
                    System.out.println("\n");
                    System.out.println("El total de las ventas es: $" + totalVentas);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese nuevamente.");
                    break;
            }
        }
    }
}



