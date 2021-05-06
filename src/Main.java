import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String opc;
        
        TablaDispersaEnlazada tabla = new TablaDispersaEnlazada();

        do {
            System.out.println("            MENÚ");
            System.out.println("----------------------------");
            System.out.println("1 - LEER ARCHIVO DE SOCIOS");
            System.out.println("2 - CARGAR SOCIO MANUALMENTE");
            System.out.println("3 - BUSCAR SOCIO");
            System.out.println("4 - ELIMINAR SOCIO");
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
                        Scanner scan = new Scanner(new File("D:\\ProyectosJava\\DispersionHashList\\src\\datos.csv"));

                        while (scan.hasNext()) {
                            String [] cadena = scan.next().split(",");
                            Socio s = new Socio(cadena[1], Integer.parseInt(cadena[0]), Integer.parseInt(cadena[2]), cadena[3]);
                            tabla.insertar(s);
                        }
                        scan.close();
                    }
                    catch (FileNotFoundException fnf) {
                        System.out.println("Error al abrir el archivo.");
                    }    
                break;
                case "2":
                    Socio s = new Socio();
                    tabla.insertar(s);
                break;
                case "3":
                    if (tabla.getnumElementos() != 0) {
                        System.out.print("Ingrese el código a buscar: ");
                        Element e = tabla.buscar(Integer.parseInt(entrada.readLine()));
                        if (e != null && e.getSocio() != null) {
                            System.out.println(e.getSocio().toString());
                        }
                        else {
                            System.out.println("No se encuentra socio con ese número");
                        }
                    }
                    else {
                        System.out.println("La tabla de socios está vacía");
                    }
                break;
                case "4":
                    if (tabla.getnumElementos() != 0) {
                        System.out.print("Ingrese el código del socio a eliminar: ");
                        tabla.eliminar(Integer.parseInt(entrada.readLine()));
                    }
                    else {
                        System.out.println("La tabla de socios está vacía");
                    }
                break;
                default:
                    System.out.println("OPCIÓN INCORRECTA");
                break;
            }
        } while (!opc.equals("0"));  
    }
}