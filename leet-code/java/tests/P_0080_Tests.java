import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P_0080_Tests {
    @Test
    public void removeDuplicates_e1() {
        int[] nums = {1,1,1,2,2,3};
        int[] expected = {1,1,2,2,3};
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(nums);

        Assert.assertEquals(5, result);
        Assert.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeDuplicates_e2() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int[] expected = {0,0,1,1,2,3,3};
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(nums);

        Assert.assertEquals(7, result);
        Assert.assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, expected.length));
    }

    @Test
    public void removeDuplicates_emptyArray() {
        int[] nums = {};
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(nums);

        Assert.assertEquals(0, result);
    }

    @Test
    public void removeDuplicates_nullArray() {
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(null);

        Assert.assertEquals(0, result);
    }

    @Test
    public void removeDuplicates_oneElement() {
        int[] nums = {1};
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(nums);

        Assert.assertEquals(1, result);
    }

    @Test
    public void removeDuplicates_noDuplicates() {
        int[] nums = {0,1,2,3,4,5,6,7};
        int[] expected = {0,1,2,3,4,5,6,7};
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(nums);

        Assert.assertEquals(expected.length, result);
        Assert.assertArrayEquals(expected, nums);
    }

    @Test
    public void removeDuplicates_noDoubleDuplicates() {
        int[] nums = {0,0,1,1,2,2,3,3,4,4};
        int[] expected = {0,0,1,1,2,2,3,3,4,4};
        P_0080 CUT = new P_0080();

        int result  = CUT.removeDuplicates(nums);

        Assert.assertEquals(expected.length, result);
        Assert.assertArrayEquals(expected, nums);
    }
}