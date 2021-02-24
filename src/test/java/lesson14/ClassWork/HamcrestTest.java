package lesson14.ClassWork;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
/****
 Project HomeWork
 Package lesson14.ClassWork

 Created by Ivan Sheynmaer

 2021.02.24
 v1.0
 */
public class HamcrestTest {
    @Test
    public void hamcrestTest() {
//        String a = "Java";
//        String b = "  Java  ";
//        MatcherAssert.assertThat(a, Matchers.equalToIgnoringWhiteSpace(b));

        MatcherAssert.assertThat(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Matchers.arrayContainingInAnyOrder(4, 3, 1, 2, 5, 6, 7));

//        MatcherAssert.assertThat(a, Matchers.equalToIgnoringWhiteSpace());
    }
}
