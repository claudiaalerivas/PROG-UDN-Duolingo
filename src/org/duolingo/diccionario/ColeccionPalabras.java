package org.duolingo.diccionario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ColeccionPalabras {
  static Map<String, Set<String>> coleccionPalabras = new HashMap<>();  

  public static void verPalabrasPorInicial(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce UNA LETRA, que sera la inicial de las palabras que quieras ver en la coleccion: ");
    String letraInicial = scanner.nextLine();
    if(letraInicial.length()>1){
      System.out.println("Debe introducir una letra");
    } else {
      if (coleccionPalabras.containsKey(letraInicial)) {
        Set<String> palabrasCoinciden = coleccionPalabras.get(letraInicial);
        System.out.println("Palabras que comienzan con '" + letraInicial + "': " + palabrasCoinciden);
      } else {
        System.out.println("No se encontraron palabras que comiencen con '" + letraInicial + "'");
      }
    }
  }
}
