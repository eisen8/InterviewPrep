import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class P_0027_Tests {
    @Test
    public void removeElement_e1() {
        int[] nums = {3,2,2,3};
        int[] expected = {2,2};
        int val = 3;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement(nums, val);

        Assertions.assertEquals(expected.length, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeElement_e2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int[] expected = {0,1,3,0,4};
        int val = 2;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement(nums, val);

        Assertions.assertEquals(expected.length, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeElement_AllSameVal() {
        int[] nums = {3,3,3,3};
        int val = 3;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement(nums, val);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void removeElement_NoVal() {
        int[] nums = {1,2,3,4};
        int val = 5;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement(nums, val);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void removeElement2_e1() {
        int[] nums = {3,2,2,3};
        int[] expected = {2,2};
        int val = 3;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement2(nums, val);

        Assertions.assertEquals(expected.length, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeElement2_e2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int[] expected = {0,1,4,0,3};
        int val = 2;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement2(nums, val);

        Assertions.assertEquals(expected.length, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeElement2_AllSameVal() {
        int[] nums = {3,3,3,3};
        int val = 3;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement2(nums, val);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void removeElement2_NoVal() {
        int[] nums = {1,2,3,4};
        int val = 5;
        P_0027 CUT = new P_0027();

        int result  = CUT.removeElement2(nums, val);

        Assertions.assertEquals(4, result);
    }
}