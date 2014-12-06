package MontyHallProblem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 28.02.14.
 */

public class ParadoxModelImplTest {

    private ParadoxModelImpl test = new ParadoxModelImpl(30L);

    @Test (expected = IllegalArgumentException.class) // repeats number must be positive
    public void testGetProbabilityRepeatsNumber() {
        test.getProbability(0);
    }

    @Test
    public void testProbabilityIsCorrect() {
        assertEquals(0.33, test.getProbability(1000).getIfNotChange(), 0.05);
        assertEquals(0.66, test.getProbability(1000).getIfChange(), 0.05);
    }
}
