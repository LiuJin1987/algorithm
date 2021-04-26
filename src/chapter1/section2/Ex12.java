package chapter1.section2;

import common.util.SmartDate;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.time.DayOfWeek;

/**
 * @author liujinlc
 * @date 2021/4/23 9:01
 **/
public class Ex12 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SmartDate smartDate = null;
            try {
                smartDate = new SmartDate(
                        StdRandom.uniform(2000, 2100),
                        StdRandom.uniform(1, 13),
                        StdRandom.uniform(1, 32));
            } catch (IllegalArgumentException e) {
                StdOut.println(e.getMessage());
            }
            assert smartDate != null;
            StdOut.printf("Date %s is %s of the week%n",
                    smartDate.toString(),
                    smartDate.dayOfTheWeek());
        }
    }
}
