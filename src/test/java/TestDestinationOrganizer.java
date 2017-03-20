import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by turbek on 20.03.17.
 */
public class TestDestinationOrganizer {

    private DestinationOrganizer destinationOrganizer;
    private ArrayList<Destination> returnList;

    @Before
    public void setUp() throws Exception {
        destinationOrganizer = new DestinationOrganizer();
        returnList = new ArrayList<>();
    }

    @Test
    public void testIfReturnsParameters() throws Exception {
        Destination x = new Destination();
        returnList.add(x);
        assertEquals(returnList, destinationOrganizer.organize(x));
    }

}
