public class Destination {
    private Destination dependency;
    private boolean visited;

    Destination(){
    }

    Destination(Destination dependency){
        this.dependency = dependency;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Destination getDependency() {
        return dependency;
    }

    public void setDependency(Destination dependency) {
        this.dependency = dependency;
    }
}