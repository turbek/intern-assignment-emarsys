import java.util.ArrayList;

public class DestinationOrganizer {
    private ArrayList<Destination> OrganizedDestinations = new ArrayList<>();

    public ArrayList<Destination> organize(Destination ... destinations){


        for(Destination destination : destinations){
            if(OrganizedDestinations.contains(destination)){
                throw new IllegalArgumentException("This destination already exists as destination!");
            }

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


}
