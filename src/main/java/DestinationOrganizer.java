import java.util.ArrayList;

public class DestinationOrganizer {
    private ArrayList<Destination> OrganizedDestinations = new ArrayList<>();

    public ArrayList<Destination> organize(Destination ... destinations){

        for(Destination destination : destinations){
            addDestination(destination);
        }

        return OrganizedDestinations;
    }

    private void addDestination(Destination destination) {
        if (destination.getDependency() == null || destination.getDependency().isVisited()) {
            OrganizedDestinations.add(destination);
        }
    }


}
