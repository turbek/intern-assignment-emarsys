import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDestinationOrganizer {

    private DestinationOrganizer destinationOrganizer;
    private ArrayList<Destination> testList;
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
        testList = new ArrayList<>();
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
        testList = null;
    }

    @Test
    public void testIfReturnsOneParameter() {
        testList.add(test1);
        assertEquals(testList, destinationOrganizer.organize(test1));
    }

    @Test
    public void testIfDependencyIsVisitedIsTrue(){
        test2.setVisited(true);
        test1 = new Destination(test2);
        assertTrue(destinationOrganizer.organize(test1).get(0).isVisited());
    }

    @Test
    public void testWithThreeInputsWithoutDependency(){
        Destination a = new Destination();
        Destination b = new Destination();
        Destination c = new Destination();
        testList.addAll(Arrays.asList(a, b, c));

        assertEquals(testList, destinationOrganizer.organize(a, b, c));
    }

    @Test
    public void testWithThreeInputsWithDependency(){
        Destination z = new Destination();
        Destination y = new Destination(z);
        Destination x = new Destination();
        z.setParent(y);
        testList.addAll(Arrays.asList(x, z, y));

        assertEquals(testList, destinationOrganizer.organize(x, y, z));
    }

    @Test
    public void testWithSixInputsWithDependencies(){
        ArrayList<Destination> checkList = new ArrayList<>();
        checkList.addAll(Arrays.asList(u, x, z, w, v, y));

        assertEquals(checkList, destinationOrganizer.organize(u, z, w, v, x, y));
    }

    @Test
    public void testWithSixInputsWithDependencies_ChangeOrder(){
        testList.addAll(Arrays.asList(z, w, v, y, u, x));

        assertEquals(testList, destinationOrganizer.organize(w, x, v, u, y, z));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoInput(){

        destinationOrganizer.organize();
    }


}
