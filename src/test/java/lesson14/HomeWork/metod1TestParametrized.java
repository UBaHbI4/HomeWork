package lesson14.HomeWork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import softing.UBaH4ukDev.Lesson14.HomeWork.HomeWork14;

import java.util.Arrays;
import java.util.Collection;

/****
 Project HomeWork
 Package lesson14.HomeWork

 Created by Ivan Sheynmaer

 2021.02.24
 v1.0
 */

@RunWith(Parameterized.class)
public class metod1TestParametrized {

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{1, 3, 4, 19, 20, 22}, new int[]{19, 20, 22}},
                {new int[]{2, 2, 4}, new int[]{}},
                {new int[]{4, 9, 18}, new int[]{9, 18}},
                {new int[]{2, 2, 3}, new int[]{5}},
        });
    }

    private int[] testArr;
    private int[] res;

    private HomeWork14 hw;

    public metod1TestParametrized(int[] testArr, int[] res) {
        this.testArr = testArr;
        this.res = res;
    }

    @Before
    public void init() {
        hw = new HomeWork14();
    }

    @Test
    public void elementsTest() {
        Assert.assertArrayEquals(res, hw.getAfterFourArray(testArr));
    }
}
