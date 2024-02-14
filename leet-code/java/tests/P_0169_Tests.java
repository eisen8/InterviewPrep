import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P_0169_Tests {
    @Test
    public void majorityElement_e1() {
        int[] nums = {3,2,3};
        int expected = 3;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement_e2() {
        int[] nums = {2,2,1,1,1,2,2};
        int expected = 2;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement_OneElement_ReturnsElement() {
        int[] nums = {5};
        int expected = 5;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement_TwoElements_ReturnsElement() {
        int[] nums = {5,5};
        int expected = 5;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement2_e1() {
        int[] nums = {3,2,3};
        int expected = 3;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement2(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement2_e2() {
        int[] nums = {2,2,1,1,1,2,2};
        int expected = 2;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement2(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement2_OneElement_ReturnsElement() {
        int[] nums = {5};
        int expected = 5;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement2(nums);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void majorityElement2_TwoElements_ReturnsElement() {
        int[] nums = {5,5};
        int expected = 5;
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement2(nums);

        Assert.assertEquals(expected, result);
    }
}