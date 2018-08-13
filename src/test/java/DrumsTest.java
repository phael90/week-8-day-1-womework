import models.Drums;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrumsTest {

        Drums drums;

        @Before
        public void before() {
            drums = new Drums("Gretch");
        }

        @Test
        public void hasName() {
            assertEquals("Gretch", drums.getName());
        }
    }
