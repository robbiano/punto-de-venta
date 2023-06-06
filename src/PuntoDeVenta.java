import entity.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase representa un programa de punto de venta para una tienda.
 * Debe realizar ventas, obtener el total de una venta y salir del programa.
 *
 * A mejorar:
 *
 * La busqueda de empleados y productos deberian hacerce con una funcion genereica que sirva para buscar las dos cosas
 *
 * Debe hacerce una validacion en el caso que el usuario ingrese un id equivocado y no se encuentre la entidad buscada
 *
 * la opcion obtener total del menu deberia consultar las ventas guardadas en el array y  sumar todos los totales de cada venta e imprimir por consola
 *
 * hacer un loop para que cuando se termine de generar una venta y se muestre el tiket el sistema vuelva al principio permitiendo generar una nueva venta sin tener que correr otra vez el ide
 *
 * la opcion salir debe terminar el programa
 */
public class PuntoDeVenta {

    /**
     * Método principal que inicia el programa de punto de venta.
     *
     * @param args Los argumentos de línea de comandos .
     */

    public static void main(String[] args) {

        // Array para almacenar las ventas  (deberia ser un arraylist)
        Venta[] ventas = new Venta[10];
        boolean efectivo = true;

        // variable de tipo arraylist (lista) para guardar productos
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        // Creación de productos
        Producto producto1 = new Producto(1, "Galaxy A12", 90000);
        Producto producto2 = new Producto(2, "Galaxy A13", 85000);
        Producto producto3 = new Producto(3, "Galaxy S23", 519000);
        Producto producto4 = new Producto(4, "Galaxy A54", 214000);

        //se agregan productos a la lista
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);

        // variable de tipo arraylist (lista) para guardar vendedores
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

        //creacion de vendedores
        Vendedor vendedor1 = new Vendedor(1,"leonardo", "Robbiano", 28343000);
        Vendedor vendedor2 = new Vendedor(2,"Jorge", "Tuvoreff", 85777000);
        Vendedor vendedor3 = new Vendedor(3,"Gabriel", "Zurschmitten", 5169000);
        Vendedor vendedor4 = new Vendedor(4,"Lucas", "Díaz\n", 21784000);

        // se agregan vendedores a la lista
        vendedores.add(vendedor1);
        vendedores.add(vendedor2);
        vendedores.add(vendedor3);
        vendedores.add(vendedor4);

        //cliente (esto esta para revisar porque actualmente el sistema nos solicita ingresar un cliente por consola)
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente(1,"juan","Perez", 34567000);
        clientes.add(cliente1);

        // comienza el menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("*              Bienvenido              *");
        System.out.println("****************************************");

        System.out.println("Por favor ingrese una opcion: ");
        System.out.println("1- NUEVA VENTA");
        System.out.println("2- OBTENER TOTAL");
        System.out.println("3- SALIR");
        int opcion = scanner.nextInt();

        // sise elige opcion 1 se entra aca
        if (opcion == 1 ){

            System.out.println("*****************************************");
            System.out.println("*             Nueva venta               *");
            System.out.println("*****************************************");
            System.out.println("\n");

            // se pide id de vendedor
            System.out.print("Introduce el id del vendedor: ");
            int idVendedor = scanner.nextInt();
            Vendedor ventaVendedor = null;

            // se busca vendedor por id
            for (Vendedor vendedor : vendedores) {
                if (vendedor.getId() == idVendedor) {
                    ventaVendedor = vendedor;
                    System.out.println("Vendedor: " + vendedor.getNombre());
                }
            }

            //se pide datos de producto / se guarda producto en variable
            Producto ventaProducto = null;
            System.out.print("Introduce el id del producto: ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();

            // se busca producto por id ( esto deberia ser una funcion)
            for (Producto producto : listaProductos) {
                if (producto.getId() == idProducto) {
                    ventaProducto = producto;
                    System.out.println("Producto: " + producto.getDescripcion());
                    System.out.println("Valor: $" + producto.getValor());
                }
            }

            // se pide los datos del cliente
            System.out.print("Introduce el nombre del cliente: ");
            String nombreCliente = scanner.nextLine();

            System.out.print("Introduce el apellido del cliente: ");
            String apellidoCliente = scanner.nextLine();

            System.out.print("Introduce el DNI del cliente: ");
            int dniCliente = scanner.nextInt();

            Cliente ventaCliente = new Cliente(1,nombreCliente,apellidoCliente,dniCliente);
            System.out.println("Cliente: " + ventaCliente.getApellido() + ventaCliente.getNombre());

                // se hace instancia de la clase venta
                VentaEfectivo venta = new VentaEfectivo(1, 0000, "efectivo", ventaCliente, ventaProducto,ventaVendedor,5000);

            // se imprimen los datos de la venta por consola (hay que agregar un to string)
            System.out.println(venta.getId());
            System.out.println(venta.getTotal());
            System.out.println(venta.getMedioDePago());
            System.out.println(venta.getCliente());
            System.out.println(venta.getProducto());
            System.out.println(venta.getVendedor());


            // se imprime el tiket de compra
            System.out.println("---------------------------------------");
            System.out.println("            Samsung Store              ");
            System.out.println("         www.samsungstore.com          ");
            System.out.println("");
            System.out.println("Vendedor: " +  ventaVendedor.getNombre());
            System.out.println("---------------------------------------");

            System.out.printf("%-15s %10s %n", "Producto", "Precio");
            System.out.printf("%-15s %10s %n", "--------", "-------");
            // Imprimir los productos del ticket
            System.out.printf("%-15s %10.2f %n", ventaProducto.getDescripcion(), ventaProducto.getValor());
            // Imprimir el total del ticket
            System.out.println("\n");
            System.out.printf("%-15s %10.2f %n", "Total",venta.getTotal());
            System.out.println("---------------------------------------");
            System.out.println(" * * * * Gracias por su compra * * * * ");
            System.out.println("---------------------------------------");


        }

    }
}
