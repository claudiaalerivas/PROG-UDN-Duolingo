import java.util.InputMismatchException;
import java.util.Scanner;

import org.duolingo.diccionario.ColeccionPalabras;

public class App {
  public static void main(String[] args) throws Exception {
    
    Scanner scanner = new Scanner(System.in);
    int opcionUsuario;
    boolean repetir = true;
    try {
      
      while (repetir) {
        System.out.println("""
          Bienvenido a la aplicacion: Duolingo Inc.
          Introduce una opcion
        1. Añadir Palabra
        2. Eliminar Palabra
        3. Existe Palabra
        4. Mostrar iniciales posibles 
        5. Ver palabras por inicial 
        0. Cerrar programa 
      """);
      opcionUsuario = scanner.nextInt();

      if (opcionUsuario == 0){
        repetir = false;
      }
      switch (opcionUsuario) {
        case 1:
        ColeccionPalabras.ingresarPalabrasColeccion();
        break;
        case 2:
          ColeccionPalabras.eliminarPalabraColeccion();
          break;
          case 3:
          ColeccionPalabras.existenciaPalabra();
          break;
          case 4:
          ColeccionPalabras.mostrarIniciales();
          break;
          case 5:
          ColeccionPalabras.verPalabrasPorInicial();
          break;
        default:
          System.out.println("Opcion no valida");
          break;
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Error: la opcion no es un numero");
      repetir = false;
    } 
  }
}