package lesson14.ClassWork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import softing.UBaH4ukDev.Lesson14.Calculator;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntPredicate;
/****
 Project HomeWork
 Package lesson14.ClassWork

 Created by Ivan Sheynmaer

 2021.02.24
 v1.0
 */
@RunWith(Parameterized.class)
public class ParametrizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {4, 5, 9},
                {7, 8, 15},
                {8, 8, 16},
                {9, 8, 17}
//                {Arrays.asList(16, 17, 18), 8, 24}
        });
    }

    private int n1, n2, res;

//    private int[] n1;
//    private int n2, res;
    private Calculator calculator;

//    public ParametrizedTest(int[] n1, int n2, int res) {
//        this.n1 = n1;
//        this.n2 = n2;
//        this.res = res;
//    }

    public ParametrizedTest(int n1, int n2, int res) {
        this.n1 = n1;
        this.n2 = n2;
        this.res = res;
    }

    @Before
    public void init() {
        //int[] a = {1, 2, 3, 4, 5};

        //Arrays.stream(a).filter(v -> v % 3 == 0)
        calculator = new Calculator();
    }

    @Test
    public void calcAddTest() {
        Assert.assertEquals(res, calculator.add(n1, n2));
    }
}
