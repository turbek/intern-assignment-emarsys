import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by turbek on 20.03.17.
 */
public class TestDestinationOrganizer {

    @Test
    public void testIfReturnsParameters() throws Exception {
        DestinationOrganizer destinationOrganizer = new DestinationOrganizer();
        Destination x = new Destination();
        ArrayList<Destination> trueList = new ArrayList<Destination>();
        trueList.add(x);
        assertEquals(trueList, destinationOrganizer.organize(x));
    }

}
