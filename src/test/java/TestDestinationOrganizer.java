import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDestinationOrganizer {

    private DestinationOrganizer destinationOrganizer;
    private ArrayList<Destination> returnList;
    private Destination test1;
    private Destination test2;
    private Destination u;
    private Destination z;
    private Destination w;
    private Destination v;
    private Destination x;
    private Destination y;

    @Before
    public void setUp() throws Exception {
        destinationOrganizer = new DestinationOrganizer();
        returnList = new ArrayList<>();
        test1 = new Destination();
        test2 = new Destination();
        u = new Destination();
        z = new Destination();
        w = new Destination(z);
        v = new Destination(w);
        x = new Destination(u);
        y = new Destination(v);
        w.setParent(v);
        z.setParent(w);
        u.setParent(x);
        v.setParent(y);
    }

    @After
    public void tearDown() throws Exception {
        destinationOrganizer = null;
        returnList = null;
        test1 = null;
    }

    @Test
    public void testIfReturnsOneParameter() {
        returnList.add(test1);
        assertEquals(returnList, destinationOrganizer.organize(test1));
    }

    @Test
    public void testIfDependencyIsVisitedIsTrue(){
        test2.setVisited(true);
        test1.setDependency(test2);
        assertTrue(destinationOrganizer.organize(test1).get(0).isVisited());
    }

    @Test
    public void testWithThreeInputsWithoutDependency(){
        Destination a = new Destination();
        Destination b = new Destination();
        Destination c = new Destination();
        returnList.add(a);
        returnList.add(b);
        returnList.add(c);
        assertEquals(returnList, destinationOrganizer.organize(a, b, c));
    }

    @Test
    public void testWithThreeInputsWithDependency(){
        Destination z = new Destination();
        Destination y = new Destination(z);
        Destination x = new Destination();
        z.setParent(y);
        returnList.add(x);
        returnList.add(z);
        returnList.add(y);
        assertEquals(returnList, destinationOrganizer.organize(x, y, z));
    }

    @Test
    public void testWithSixInputsWithDependencies(){
        ArrayList<Destination> checkList = new ArrayList<>();
        checkList.add(u);
        checkList.add(x);
        checkList.add(z);
        checkList.add(w);
        checkList.add(v);
        checkList.add(y);

        assertEquals(checkList, destinationOrganizer.organize(u, z, w, v, x, y));
    }

    @Test
    public void testWithSixInputsWithDependencies_ChangeOrder(){
        returnList.add(z);
        returnList.add(w);
        returnList.add(v);
        returnList.add(y);
        returnList.add(u);
        returnList.add(x);

        assertEquals(returnList, destinationOrganizer.organize(w, x, v, u, y, z));
    }

}
