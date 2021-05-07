public class Element {
    Dogs dog;
    Element sgte;
    
    public Element(Dogs d) {
        dog = d;
        sgte = null;
    }
    
    public Dogs getDog() {
        return dog;
    }
};