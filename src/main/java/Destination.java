public class Destination {
    private Destination dependency;
    private Destination parent;
    private boolean visited;

    Destination(){
    }

    Destination(Destination dependency){
        this.dependency = dependency;
    }

    public Destination getParent() {
        return parent;
    }

    public void setParent(Destination parent) {
        if(this.getParent() != null){
            throw new IllegalArgumentException("This Destination already has a parent!");
        }
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