import java.util.ArrayList;

public class DestinationOrganizer {
    private ArrayList<Destination> OrganizedDestinations = new ArrayList<>();

    public ArrayList<Destination> organize(Destination... destinations){

        checkExceptions(destinations);

        for(Destination destination : destinations){
            addDestination(destination);
        }

        return OrganizedDestinations;
    }

    private void addDestination(Destination destination) {
        if(destination.isVisited()){
            return;
        }
        if(destination.getDependency() == null || destination.getDependency().isVisited()){
            destination.setVisited(true);
            OrganizedDestinations.add(destination);

            if(destination.getParent() != null){
                addDestination(destination.getParent());
            }
        }
        else {
            addDestination(destination.getDependency());
        }
    }

    private void checkExceptions(Destination[] destinations) {
        if(destinations.length < 1){
            throw new IllegalArgumentException("Destinations should contain at least one element!");
        }
    }
}
