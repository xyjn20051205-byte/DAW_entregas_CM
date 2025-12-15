package daw.entregas;

import java.util.Scanner;

public class GestionAcceso {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion=0;
        //un bucle do-while
        do {
            System.out.println("==== GESTIÓN DE ACCESO ====");
            System.out.println("1. Validar identificador de acceso" +
                    "\n2. Validar clave de seguridad" +
                    "\n3. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            //switch controlar las condiciones
            switch (opcion) {
                case 1:
                    String validacion_identificadorAcceso = validarAcceso() != null ? "Validación correcta" : "Validación incorrecta";
                    System.out.println(validacion_identificadorAcceso);
                    break;
                case 2:
                    String validacion_claveSeguridad = validarClave() != null ? "Validación correcta" : "Validación incorrecta";
                    System.out.println(validacion_claveSeguridad);
                    break;
                case 3:
                    System.out.println("==== Saliendo ====");
                    break;
                default:
                    System.out.println("La opcion tiene que ser numerica.");
                    break;
            }
        } while (opcion != 3);
    }
// Funcion para validar Acceso
    public static String validarAcceso() {
        //Utilizamos try-catch para lanzar excepcion.
        try {
            //crea variable acceso igual al acceso introducido por funcion pideAcceso.
            String acceso= pideAcceso();
            //revuelve acceso.
            return acceso;
        //una vez aparece exception se lanza exception
        } catch (InvalidAccesoException e) {
            //imprime mensaje
            System.out.println(e.getMessage());
            //revuelve nulo
            return null;
        }
    }
    // Funcion para validar Clave
    public static String validarClave() {
        //Utilizamos try-catch para lanzar excepcion.
        try {
            //crea variable acceso igual al acceso introducido por funcion pideAcceso.
            String clave = pideClave();
            //revuelve clave
            return clave;
            //una vez aparece exception se lanza exception
        } catch (InvalidClaveException e) {
            //imprime mensaje
            System.out.println(e.getMessage());
            //revuelve nulo
            return null;
        }
    }
    // Funcion para pedir Acceso utilizamos throws para lanzar exception
    public static String pideAcceso() throws InvalidAccesoException {
        //pedir Acceso
        System.out.println("Introuce el identificador de acceso: ");
        String acceso = sc.nextLine();

        //utiliza if para controlar la condiciones
        //como minimo 3 caracteres y utilizamos matches para controlar rango
        if (acceso.length() >= 3 && acceso.matches("[A-Za-z0-9]+")) {
            //revuelve acceso.
            return acceso;
        }
        throw new InvalidAccesoException("Como minimo debe tener 3 caracteres");
    }

    public static String pideClave() throws InvalidClaveException {
        //pedir clave
        System.out.println("Introduce la clave de seguridad: ");
        String clave = sc.nextLine();

        //utiliza if para controlar la condiciones
        //como minimo 6 caracteres y utilizamos matches para controlar rango
        if (clave.length() >= 6 && clave.matches(".*[0-9].*") && clave.matches(".*[A-Z].*")) {
            //revuelve  clave
            return clave;
        }
        throw new InvalidClaveException("La contraseña debe tener al menos un número, una mayuscula y con 6 caracteres como mínimo.");
    }

}
