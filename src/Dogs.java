import java.io.*;
import java.time.LocalDate;

public class Dogs {

    private int codigo;
    private String raza;
    private String nombre;
    private String duenio;
    private LocalDate fechaNac;
    private int edad;
    private boolean vacunado;
    
    public Dogs(int codigo, String raza, String nombre, String duenio, String fechaNac, int edad, boolean vacunado) {
        this.codigo = codigo;
        this.raza = raza;
        this.nombre = nombre;
        this.duenio = duenio;
        this.fechaNac = LocalDate.of(Integer.parseInt(fechaNac.split("/")[2]),
                                  Integer.parseInt(fechaNac.split("/")[1]),
                                  Integer.parseInt(fechaNac.split("/")[0]));
        this.edad = edad;
        this.vacunado = vacunado;
    }

    public Dogs() {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                System.out.print("\n Código: ");
                int codigo = Integer.parseInt(scan.readLine());
                if (codigo<1001 && codigo>2000) {
                    System.out.println("El valor ingresado es incorrecto.");
                }
                else {
                    this.codigo = codigo;
                }
            } while (codigo<1001 && codigo>2000);
            System.out.print("\n Raza: ");
            this.raza = scan.readLine();
            System.out.print("\n Nombre: ");
            this.nombre = scan.readLine();
            System.out.print("\n Dueño: ");
            this.duenio = scan.readLine();
            boolean fechaValida = false;
            do {
                System.out.print("Fecha de Nacimiento (Formato: dd/mm/aaaa): ");
                String fecha = scan.readLine();
                fechaValida = validaFecha(fecha);
                if (!fechaValida) {
                    System.out.println("El valor ingresado es incorrecto.");
                }
                else {
                    this.fechaNac = LocalDate.of(Integer.parseInt(fecha.split("/")[2]),
                                              Integer.parseInt(fecha.split("/")[1]),
                                              Integer.parseInt(fecha.split("/")[0]));
                }
            } while (!fechaValida);
            System.out.print("\n Edad: ");
            this.edad = Integer.parseInt(scan.readLine());
            System.out.println("¿Tiene todas las vacunas aplicadas?");
            System.out.println("('1' para confirmar - '0' para cancelar)");
            System.out.print("Opción: ");
            int opcion = Integer.parseInt(scan.readLine());
            if (opcion == 1) {
                this.vacunado = true;
            }
            else {
                this.vacunado = false;
            }
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean getVacunado() {
        return vacunado;
    }

    public void setVcacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String toString() {
        return "Perro => {" + "Código: " + codigo + ", Raza: " + raza + ", Nombre: " + nombre + ", Dueño: " + duenio + ", Fecha de Nac.: " + fechaNac + ", Edad: " + edad + ", Vacunado?: " + vacunado + '}';
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