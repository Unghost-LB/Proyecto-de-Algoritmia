package Proyect;

import java.util.Scanner;

public class reporte {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int cantidadServicios;
        int contador = 0;

        System.out.println("Digite la cantidad de Servicios a ingresar");
        cantidadServicios = lectura.nextInt();

        String[] NombreServicios = new String[cantidadServicios];
        int[] PrecioServicios = new int[cantidadServicios];
        int[] CantidadServicios = new int[cantidadServicios];
        int[] PagoServicios = new int[cantidadServicios];

        while (contador < cantidadServicios) {

            System.out.println("Digite el nombre del servicio " + (contador + 1));
            NombreServicios[contador] = lectura.next();

            System.out.println("Digite el precio del servicio " + (contador + 1));
            PrecioServicios[contador] = lectura.nextInt();

            System.out.println("Digite la cantidad de servicios " + (contador + 1));
            CantidadServicios[contador] = lectura.nextInt();

            PagoServicios[contador] = PrecioServicios[contador] * CantidadServicios[contador];
            contador++;
        }

        CambiarServicios(NombreServicios, PrecioServicios, CantidadServicios, PagoServicios);
    }

    public static void CambiarServicios(String[] NombreServicios, int[] PrecioServicios, int[] CantidadServicios, int[] PagoServicios) {

        Scanner lectura = new Scanner(System.in);
        int totalServicios = 0;
        int totalPago = 0;

        for (int i = 0; i < NombreServicios.length; i++) {
            System.out.println("Ingrese la cantidad de servicios nuevos para el servicio " + NombreServicios[i] + ": ");
            int cantidadNuevosServicios = lectura.nextInt();

            CantidadServicios[i] += cantidadNuevosServicios;
            PagoServicios[i] = PrecioServicios[i] * CantidadServicios[i];

            totalServicios += CantidadServicios[i];
            totalPago += PagoServicios[i];
        }

        System.out.println("\n--- Reporte Final ---");
        for (int i = 0; i < NombreServicios.length; i++) {
            System.out.println("Servicio: " + NombreServicios[i]);
            System.out.println("Precio: " + PrecioServicios[i]);
            System.out.println("Cantidad: " + CantidadServicios[i]);
            System.out.println("Pago Total: " + PagoServicios[i]);
            System.out.println();
        }

        System.out.println("Total de Servicios Realizados: " + totalServicios);
        System.out.println("Pago Total: " + totalPago);
    }
}
