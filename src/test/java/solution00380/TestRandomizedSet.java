package solution00380;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestRandomizedSet {
    @Test
    public void TestRandomizedSet() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertEquals(true, randomizedSet.insert(1));
        assertEquals(false, randomizedSet.insert(1));
        assertEquals(true, randomizedSet.insert(2));
        assertEquals(false, randomizedSet.insert(2));

        var r = randomizedSet.getRandom();
        if (r != 1 && r != 2) {
            fail("either 1 or 2");
        }

        assertEquals(true, randomizedSet.remove(2));
        assertEquals(false, randomizedSet.remove(2));
        assertEquals(1, randomizedSet.getRandom());

        assertEquals(true, randomizedSet.remove(1));
        assertEquals(false, randomizedSet.remove(1));
    }
}
