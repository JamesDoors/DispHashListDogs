import java.io.*;
import java.time.LocalDate;

public class Socio {

    private int codigo;
    private String nombre;
    private int edad;
    private LocalDate fecha;
    
    /*public Socio(String nombre, int codigo, int edad, int dia, int mes, int anio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.fecha = LocalDate.of(anio, mes, dia);
    }*/

    public Socio(String nombre, int codigo, int edad, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.fecha = LocalDate.of(Integer.parseInt(fecha.split("/")[2]),
                                  Integer.parseInt(fecha.split("/")[1]),
                                  Integer.parseInt(fecha.split("/")[0]));
    }

    public Socio() {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                System.out.print("\n Código: ");
                int codigo = Integer.parseInt(scan.readLine());
                if (codigo<101 && codigo>1999) {
                    System.out.println("El valor ingresado es incorrecto.");
                }
                else {
                    this.codigo = codigo;
                }
            } while (codigo<101 && codigo>1999);
            System.out.print("\n Nombre: ");
            this.nombre = scan.readLine();
            System.out.print("\n Edad: ");
            this.edad = Integer.parseInt(scan.readLine());
            boolean fechaValida = false;
            do {
                System.out.print("Fecha de Alta (Formato: dd/mm/aaaa): ");
                String fechaAlta = scan.readLine();
                fechaValida = validaFecha(fechaAlta);
                if (!fechaValida) {
                    System.out.println("El valor ingresado es incorrecto.");
                }
                else {
                    this.fecha = LocalDate.of(Integer.parseInt(fechaAlta.split("/")[2]),
                                              Integer.parseInt(fechaAlta.split("/")[1]),
                                              Integer.parseInt(fechaAlta.split("/")[0]));
                }
            } while (!fechaValida);
        }
        catch (IOException e) {
            System.out.println(" Excepcion en la entrada de datos " +
            e.getMessage()+ " . No se da de alta");
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "Socio => {" + "Código: " + codigo + ", Nombre: " + nombre + ", Edad: " + edad + ", Fecha: " + fecha + '}';
    }

    static boolean validaFecha(String fecha) {
        boolean valido = true;
        
        int anio = Integer.parseInt(fecha.split("/")[2]); 
        int mes = Integer.parseInt(fecha.split("/")[1]);
        int dia = Integer.parseInt(fecha.split("/")[0]);

        try {
            LocalDate.of(anio, mes, dia);
        }
        catch (Exception e) {
            valido = false;
        }
        
        return valido;
    }
};