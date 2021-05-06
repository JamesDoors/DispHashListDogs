public class Elemento {
    Socio socio;
    Elemento sgte;
    
    public Elemento(Socio e) {
        socio = e;
        sgte = null;
    }
    
    public Socio getSocio() {
        return socio;
    }
};