import java.util.ArrayList;

public class DestinationOrganizer {
    private ArrayList<Destination> OrganizedDestinations = new ArrayList<Destination>();

    public ArrayList<Destination> organize(Destination ... destinations){

        for(Destination destination : destinations){
            OrganizedDestinations.add(destination);
        }

        return OrganizedDestinations;
    }


}
