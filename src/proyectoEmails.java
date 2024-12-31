import java.util.*;
public class proyectoEmails {
    static Scanner s = new Scanner(System.in);
    static Random r = new Random();
   public static void main(String[] args) {
     System.out.printf("\n%s%n", "=============================================");
     System.out.printf("\t\t\t*** BIENVENIDO ***%n");
     System.out.printf("=============================================%n");
     System.out.printf("\n¿Quiere saber cómo generar un email solo con su nombre y apellido?%n");
     System.out.printf("\n\tIngrese '%s' para CONTINUAR%n\tIngrese '%s' para FINALIZAR%n", "true", "false");
     System.out.print("\nIngrese un valor: ");
     
    String referencia = s.nextLine();
    // verificamos el número y si está en lo correcto 
    while (referencia.isEmpty()) {
        System.out.print("\n[!] El valor ingresado no es correcto. Recuerde: 'true' o 'false'\nIngrese de nuevo el valor: ");
        referencia = s.nextLine();
    }
    // verificamos que la entrada sea correctamente true o false
    while (!referencia.equalsIgnoreCase("true") && !referencia.equalsIgnoreCase("false")) {
        System.out.println("\n[!] La entrada tiene que ser booleana ('true' o 'false')");
        System.out.print("Ingrese un valor: ");
        referencia = s.nextLine();
    }
    // pasamos la entrada a una variable de tipo booleana y empezamos a realizar todo el programa solicitando los datos que se van a utilizar 
    boolean valor = Boolean.parseBoolean(referencia);
    while (valor) {
        if (valor == true){
            try {
                System.out.print("\nIngrese su nombre: ");
                while (!s.hasNextLine()) {
                    System.out.println("\n[!] Su nombre debe ser una cadena de caracteres válida (sin símbolos raros)");
                    System.out.print("Ingrese su nombre: ");
                    s.next();
                }
                String name = s.nextLine();
                /* verificamos que la entrada no sea vacía y si es así volvemos a solicitar los datos  */
                while (name.isEmpty()) {
                    System.out.print("\n[!] La entrada está vacía. Por favor, vuelva a ingresar los datos\nIngrese su nombre: ");
                    name = s.nextLine();
                }
                /* ahora solicitamos el apellido de la persona */
                System.out.print("Ingrese su apellido: ");
                String lastName = s.nextLine();
                /* verificamos que la entrada no sea vacía de nuevo */
                while (lastName.isEmpty()) {
                    System.out.print("\n[!] La entrada está vacía. Por favor, vuelva a ingresar los datos\nIngrese su apellido: ");
                    lastName = s.nextLine();
                }
                // llamamos al método y mostramos el resultado 
                System.out.println("\n---------------------------------------------");
                System.out.println("¡Correo electrónico generado exitosamente!");
                System.out.println("Su correo es: " + generador(name, lastName));
                System.out.println("---------------------------------------------");
            } catch (Exception e) {
                System.out.println("\n[ERROR] " + e.getLocalizedMessage());
            }
        }else{
            System.out.println("\nGracias por utilizar nuestro programa...");
            valor = false;
        }
        valor = false;
    }
    
   }    
   public static String generador(String name, String lastName) {
    name = name.toLowerCase().trim();
    lastName = lastName.toUpperCase().trim();
    // verificamos la longitud de los caracteres antes de generar el correo 
    String namepart = name.length() >= 4 ? name.substring(0, 4) : name;
    String lasnamepart = lastName.length() >= 4 ? lastName.substring(0, 4) : lastName;
    // ahora que tenemos el nombre en minúscula y el apellido en mayúscula, pasamos a realizar lo que se nos solicita 
    String correo = namepart + lasnamepart + Integer.toString(r.nextInt(0, 1000)) + "@aol.com";
    if (correo.isEmpty()) {
        correo = namepart + lasnamepart + "@aol.com";
    }
    return correo;
   }
}
