// DrummerTest.java

import models.Drummer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrummerTest {

    Drummer drummer;

    @Before
    public void before(){
        drummer = new Drummer("Newman", "Baker");
    }

    @Test
    public void hasFirstName(){
        assertEquals("Newman", drummer.getFirstName());
    }

    @Test
    public void hasLastName(){
        assertEquals("Baker", drummer.getLastName());
    }

}