public class Destination {
    private Destination dependency;

    Destination(){
    }

    Destination(Destination dependency){
        this.dependency = dependency;
    }

    public Destination getDependency() {
        return dependency;
    }

    public void setDependency(Destination dependency) {
        this.dependency = dependency;
    }
}