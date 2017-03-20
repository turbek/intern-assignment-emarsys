public class Destination {
    private Destination dependency;
    private Destination parent;
    private boolean visited;

    Destination(){
    }

    Destination(Destination dependency){
        if (this == dependency){
            throw new IllegalArgumentException("Object can't be it's own dependency!");
        }
        this.dependency = dependency;
    }

    public Destination getParent() {
        return parent;
    }

    public void setParent(Destination parent) {
        this.parent = parent;
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

}