import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String opc;
        
        DispersionHashList tabla = new DispersionHashList();

        do {
            System.out.println("            MENÚ");
            System.out.println("----------------------------");
            System.out.println("1 - LEER ARCHIVO DE PERROS");
            System.out.println("2 - CARGAR PERRO MANUALMENTE");
            System.out.println("3 - BUSCAR PERRO");
            System.out.println("4 - ELIMINAR PERRO");
            System.out.println("----------------------------");
            System.out.println("0 - SALIR");
            System.out.println("");
            System.out.print("Opción: ");
            opc = entrada.readLine();
            switch (opc) {
                case "0":
                    //Sale del ciclo y finaliza
                break;
                case "1":
                    try {
                        Scanner scan = new Scanner(new File("D:\\ProyectosJava\\DispHashListDogs\\src\\data.csv"));

                        while (scan.hasNext()) {
                            String [] cadena = scan.next().split(",");
                            Dogs d = new Dogs(Integer.parseInt(cadena[0]), cadena[1], cadena[2], cadena[3], cadena[4], Integer.parseInt(cadena[5]), Boolean.parseBoolean(cadena[6]));
                            tabla.insertar(d);
                        }
                        scan.close();
                    }
                    catch (FileNotFoundException fnf) {
                        System.out.println("Error al abrir el archivo.");
                    }    
                break;
                case "2":
                    Dogs d = new Dogs();
                    tabla.insertar(d);
                break;
                case "3":
                    if (tabla.getnumElementos() != 0) {
                        System.out.print("Ingrese el código a buscar: ");
                        Element e = tabla.buscar(Integer.parseInt(entrada.readLine()));
                        if (e != null && e.getDog() != null) {
                            System.out.println(e.getDog().toString());
                        }
                        else {
                            System.out.println("No se encuentra perro con ese número");
                        }
                    }
                    else {
                        System.out.println("La tabla de perros está vacía");
                    }
                break;
                case "4":
                    if (tabla.getnumElementos() != 0) {
                        System.out.print("Ingrese el código del perro a eliminar: ");
                        tabla.eliminar(Integer.parseInt(entrada.readLine()));
                    }
                    else {
                        System.out.println("La tabla de perros está vacía");
                    }
                break;
                default:
                    System.out.println("OPCIÓN INCORRECTA");
                break;
            }
        } while (!opc.equals("0"));  
    }
}