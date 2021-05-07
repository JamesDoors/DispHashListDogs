import java.io.*;

public class DispersionHashList {
    
    private static final double R = 0.618034;
    private static int M = 97;
    private Element[] tabla;
    private int numElementos;

    public DispersionHashList() {
        tabla = new Element[M];
        for (int k = 0; k < M; k++)
        tabla[k] = null;
        numElementos = 0;
    }

    public int getnumElementos() {
        return numElementos;
    }

    static int dispersion(long x) {
        double t;
        int v;
        t = R * x - Math.floor(R * x); // parte decimal
        v = (int) (M * t);
        return v;
    }

    public void insertar(Dogs d) {
        int posicion;
        Element nuevo;
        posicion = dispersion(d.getCodigo());
        nuevo = new Element(d);
        nuevo.sgte = tabla[posicion];
        tabla[posicion] = nuevo;
        numElementos++;
    }

    boolean conforme(Dogs d) throws NumberFormatException, IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(d.toString());
        System.out.println("¿Confirma que desea eliminar este socio?");
        System.out.println("('1' para confirmar - '0' para cancelar)");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(scan.readLine());
        if (opcion == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void eliminar(int codigo) throws NumberFormatException, IOException {
        int posicion;
        posicion = dispersion(codigo);
        if (tabla[posicion] != null) {// no está vacía
            Element anterior, actual;
            anterior = null;
            actual = tabla[posicion];
            while ((actual.sgte != null) && (actual.getDog().getCodigo() != codigo)) {
                anterior = actual;
                actual = actual.sgte;
            }
            if (actual.getDog().getCodigo() != codigo) {
                System.out.println("No se encuentra en la tabla el perro "+ codigo);
            }
            else {
                if (conforme (actual.getDog())) {//se retira el nodo
                    if (anterior == null) {// primer nodo
                        tabla[posicion] = actual.sgte;
                    }
                    else {
                        anterior.sgte = actual.sgte;
                        actual = null;
                    }
                    numElementos--;
                    System.out.println("El perro fue eliminado.");
                }
                else {
                    System.out.println("Se canceló la eliminación del perro.");
                }
            } 
        }
        else {
            System.out.println("No se encuentra en la tabla el perro "+ codigo);
        }
    }

    public Element buscar(int codigo) {
        Element p = null;
        int posicion;
        posicion = dispersion(codigo);
        if (tabla[posicion] != null) {
            p = tabla[posicion];
            while ((p.sgte != null) && p.dog.getCodigo() != codigo) {
                p = p.sgte;
            }
            if (p.dog.getCodigo() != codigo) {
                p = null;
            }
        }
        return p;
    }
}
