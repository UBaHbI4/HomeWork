package lesson14.ClassWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import softing.UBaH4ukDev.Lesson14.ClassWork.Calculator;

/****
 Project HomeWork
 Package lesson14

 Created by Ivan Sheynmaer

 2021.02.24
 v1.0
 */
public class calcTest {
    Calculator c;

    @Before
    public void init() {
        c = new Calculator();
        System.out.println("Before");
    }

    @After
    public void close() {
        System.out.println("After");
    }

    @Test
    public void addTest() {
        Assert.assertEquals(4, c.add(1, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
    }

    @Test
    public void subTest() {
        Assert.assertEquals(6, c.sub(9, 3));
    }

    @Test
    public void divTest() {
        Assert.assertEquals(2, c.div(4, 2));
    }

    @Test
    public void mulTest() {
        Assert.assertEquals(6, c.mul(2, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void divByZeroTest() {
        c.div(10, 0);
    }
}
