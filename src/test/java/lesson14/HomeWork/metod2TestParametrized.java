package lesson14.HomeWork;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
public class metod2TestParametrized {
    //[ 1 1 1 4 4 1 4 4 ] -> true
    //[ 1 1 1 1 1 1 ] -> false
    //[ 4 4 4 4 ] -> false
    //[ 1 4 4 1 1 4 3 ] -> false

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true},
                {new int[]{1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4}, false},
                {new int[]{1, 4, 4, 1, 1, 4, 3}, false}
        });
    }

    private int[] testArr;
    private boolean res;

    private HomeWork14 hw;

    public metod2TestParametrized(int[] testArr, boolean res) {
        this.testArr = testArr;
        this.res = res;
    }

    @Before
    public void init() {
        hw = new HomeWork14();
    }

    @Test
    public void elementsTest() {
        Assert.assertEquals(res, hw.checkArray(testArr));
    }
}