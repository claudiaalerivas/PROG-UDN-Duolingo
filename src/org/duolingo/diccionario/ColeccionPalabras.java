package org.duolingo.diccionario;

import java.util.HashMap;
import java.util.HashSet;
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

  public static void eliminarPalabraColeccion(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese palabra a eliminar: ");
    String palabraEliminar = scanner.nextLine().toLowerCase();
    String letraInicial = palabraEliminar.substring(0, 1);
    
    if (coleccionPalabras.containsKey(letraInicial)){
      Set<String> palabras = coleccionPalabras.get(letraInicial);
      if (palabras.contains(palabraEliminar)) {
        palabras.remove(palabraEliminar);
        System.out.println("Palabra '" + palabraEliminar + "' eliminada de la colección");
      } else {
        System.out.println("La palabra '" + palabraEliminar + "' no está en la colección");
      }
    } else {
    System.out.println("No se encontraron palabras que comiencen con '" + letraInicial + "'");
    }
  }

  public static void mostrarIniciales(){
    System.out.println("Iniciales Almacenadas: " + coleccionPalabras.keySet());
  } 
  
  public static void ingresarPalabrasColeccion(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa Palabra que quieres añadir a la coleccion");
    String palabraUsuario = scanner.nextLine().toLowerCase();
    String pattern = "\\s+(\\*)\\s+|\\s+";
    palabraUsuario = palabraUsuario.replaceAll(pattern, "");
    String letraInicial = palabraUsuario.substring(0, 1);
    if (coleccionPalabras.containsKey(letraInicial) && coleccionPalabras.get(letraInicial).size() >= 1) {
      Set<String> auxiliar = coleccionPalabras.get(letraInicial);
      for(String elemento : auxiliar){
        if(palabraUsuario.equals(elemento)){
          System.out.println("La palabra existe");
        } 
      }
    } else {
      Set<String> palabras = coleccionPalabras.computeIfAbsent(letraInicial, k -> new HashSet<>());
      palabras.add(palabraUsuario);
      System.out.println("Palabra '" + palabraUsuario + "' ingresada en la colección");
    }
  }
  
}
