package chapter1.section2;

import common.util.SmartDate;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/23 8:58
 **/
public class Ex11 {
    public static void main(String[] args) {
        try {
            new SmartDate(111, 111, 111);
        } catch (IllegalArgumentException e) {
            assert "Invalid date".equals(e.getMessage());
            StdOut.println(e.getMessage());
        }
    }
}
