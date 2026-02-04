package daw.entregas;

import daw.entregas.clases.Reserva;
import daw.entregas.enums.TipoReserva;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionFecha {
    private static  final MyScanner sc = new MyScanner();

    private static Reserva[] reservas = new Reserva[30];
    private static int contador = 0;

    public static void main(String[] args) {
        boolean salida;
        do {
            salida = false;
            int opcion = sc.pedirNumero("-----Reservas------" +
                    "\n1. Añadir Reserva" +
                    "\n2. Mostrar Reserva" +
                    "\n3. Filtrar por año" +
                    "\n4. Filtrar por mes" +
                    "\n5. Filtrar por rango" +
                    "\n6. Salir" +
                    "\nIngrese la opción");
            switch (opcion){
                case 1:
                    addReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    filtroYear();
                    break;
                case 4:
                    filtroMonth();
                    break;
                case 5:
                    filtroRango();
                    break;
                case 6:
                    System.out.println("Saliendo ....");
                    salida = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }

        } while (!salida);
    }

    //Metodos
    public static void addReserva() {
        boolean correcto;
        LocalDate fechaDeLaReserva = null;
        do {
            correcto = true;
            try {
                String fecha = sc.pideTexto("Ingrese la fecha de la Reserva (YYYY-MM-DD): ");
                fechaDeLaReserva = LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        TipoReserva tipo_reserva = Utilidades.pedirEnum(TipoReserva.class, "Seleccione el tipo de la reserva: ");

        String identificadorDeLaReserva = sc.pideTexto("Ingrese el identificador de la reserva: ");

        String nombreDelCliente = sc.pideTexto("Ingrese el nombre del cliente: ");

        if (contador < reservas.length) {
            reservas[contador] = new Reserva(identificadorDeLaReserva,nombreDelCliente,fechaDeLaReserva,tipo_reserva);
            contador++;
        } else {
            System.out.println("La lista de registros ya esta llena.");
        }
    }

    public static void mostrarReservas() {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                System.out.println(reservas[i]);
            }
        }
    }

    public static void filtroYear() {
        int year = sc.pedirNumero("Ingrese el año para filtrar: ");
        obtenerReservaPorAnio(year);
    }

    public static void filtroMonth() {
        int month = sc.pedirNumero("Ingrese el mes para filtrar: ");
        obtenerReservaPorMes(month);
    }

    public static void filtroRango() {
        int min_year = sc.pedirNumero("Ingrese el año mínimo: ");
        int max_year = sc.pedirNumero("Ingrese el año máximo: ");
        obtenerReservaEnRango(min_year, max_year);
    }

    public static void obtenerReservaPorAnio(int year) {
        for (int i = 0; i < reservas.length ; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFechaDeLaReserva().getYear() == year) {
                    System.out.println(reservas[i]);
                }
            }
        }
    }

    public static void obtenerReservaPorMes(int month) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFechaDeLaReserva().getMonthValue() == month) {
                System.out.println(reservas[i]);
                }
            }
        }
    }

    public static void obtenerReservaEnRango (int min_year, int max_year) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i]!=null) {
            int year = reservas[i].getFechaDeLaReserva().getYear();

                if (min_year < year && year < max_year) {
                    System.out.println(reservas[i]);
                }
            }
        }
    }

}
