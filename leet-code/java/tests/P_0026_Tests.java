import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class P_0026_Tests {
    @Test
    public void removeDuplicates_e1() {
        int[] nums = {1,1,2};
        int[] expected = {1,2};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(nums);

        Assertions.assertEquals(2, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeDuplicates_e2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expected = {0,1,2,3,4};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(nums);

        Assertions.assertEquals(5, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeDuplicates_emptyArray() {
        int[] nums = {};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(nums);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void removeDuplicates_nullArray() {
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(null);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void removeDuplicates_oneElement() {
        int[] nums = {1};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(nums);

        Assertions.assertEquals(1, result);
    }

    @Test
    public void removeDuplicates_noDuplicates() {
        int[] nums = {0,1,2,3,4,5,6,7};
        int[] expected = {0,1,2,3,4,5,6,7};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(nums);

        Assertions.assertEquals(expected.length, result);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void removeDuplicates2_e1() {
        int[] nums = {1,1,2};
        int[] expected = {1,2};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(nums);

        Assertions.assertEquals(2, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeDuplicates2_e2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expected = {0,1,2,3,4};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(nums);

        Assertions.assertEquals(5, result);
        Assertions.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeDuplicates2_emptyArray() {
        int[] nums = {};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(nums);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void removeDuplicates2_nullArray() {
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(null);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void removeDuplicates2_oneElement() {
        int[] nums = {1};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(nums);

        Assertions.assertEquals(1, result);
    }

    @Test
    public void removeDuplicates2_noDuplicates() {
        int[] nums = {0,1,2,3,4,5,6,7};
        int[] expected = {0,1,2,3,4,5,6,7};
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(nums);

        Assertions.assertEquals(expected.length, result);
        Assertions.assertArrayEquals(expected, nums);
    }
}