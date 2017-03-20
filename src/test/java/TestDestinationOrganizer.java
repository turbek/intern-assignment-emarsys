import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDestinationOrganizer {

    private DestinationOrganizer destinationOrganizer;
    private ArrayList<Destination> returnList;
    private Destination x;
    private Destination y;

    @Before
    public void setUp() throws Exception {
        y = new Destination();
        x = new Destination();
        destinationOrganizer = new DestinationOrganizer();
        returnList = new ArrayList<>();
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
        x.setDependency(y);
        assertEquals(returnList, destinationOrganizer.organize(x));
    }

    @Test
    public void testIfDependencyIsVisitedIsTrue(){
        y.setVisited(true);
        x.setDependency(y);
        assertTrue(destinationOrganizer.organize(x).get(0).isVisited());
    }

}
