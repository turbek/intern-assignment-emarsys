import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestDestinationOrganizer {

    private DestinationOrganizer destinationOrganizer;
    private ArrayList<Destination> returnList;
    private Destination x;

    @Before
    public void setUp() throws Exception {
        destinationOrganizer = new DestinationOrganizer();
        returnList = new ArrayList<>();
        x = new Destination();
    }

    @After
    public void tearDown() throws Exception {
        destinationOrganizer = null;
        returnList = null;
        x = null;
    }

    @Test
    public void testIfReturnsOneParameter() {
        returnList.add(x);
        assertEquals(returnList, destinationOrganizer.organize(x));
    }

    @Test
    public void testIfDependencyAlreadyVisited(){
        Destination y = new Destination();
        y.setVisited(false);
        x.setDependency(y);
        assertEquals(returnList, destinationOrganizer.organize(x));
    }
}
