import java.io.*;

public class TablaDispersaEnlazada {
    
    private static final double R = 0.618034;
    private static int M = 97;
    private Elemento[] tabla;
    private int numElementos;

    public TablaDispersaEnlazada() {
        tabla = new Elemento[M];
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

    public void insertar(Socio s) {
        int posicion;
        Elemento nuevo;
        posicion = dispersion(s.getCodigo());
        nuevo = new Elemento(s);
        nuevo.sgte = tabla[posicion];
        tabla[posicion] = nuevo;
        numElementos++;
    }

    boolean conforme(Socio a) throws NumberFormatException, IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(a.toString());
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
            Elemento anterior, actual;
            anterior = null;
            actual = tabla[posicion];
            while ((actual.sgte != null) && (actual.getSocio().getCodigo() != codigo)) {
                anterior = actual;
                actual = actual.sgte;
            }
            if (actual.getSocio().getCodigo() != codigo) {
                System.out.println("No se encuentra en la tabla el socio "+ codigo);
            }
            else {
                if (conforme (actual.getSocio())) {//se retira el nodo
                    if (anterior == null) {// primer nodo
                        tabla[posicion] = actual.sgte;
                    }
                    else {
                        anterior.sgte = actual.sgte;
                        actual = null;
                    }
                    numElementos--;
                    System.out.println("El socio fue eliminado.");
                }
                else {
                    System.out.println("Se canceló la eliminación del socio.");
                }
            } 
        }
        else {
            System.out.println("No se encuentra en la tabla el socio "+ codigo);
        }
    }

    public Elemento buscar(int codigo) {
        Elemento p = null;
        int posicion;
        posicion = dispersion(codigo);
        if (tabla[posicion] != null) {
            p = tabla[posicion];
            while ((p.sgte != null) && p.socio.getCodigo() != codigo) {
                p = p.sgte;
            }
            if (p.socio.getCodigo() != codigo) {
                p = null;
            }
        }
        return p;
    }
}
