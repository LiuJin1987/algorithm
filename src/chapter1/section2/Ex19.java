package chapter1.section2;

import common.util.Transaction;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/26 9:03
 **/
public class Ex19 {
    public static void main(String[] args) {
        Transaction transaction = new Transaction("John 2/23/2021 0.75");
        StdOut.println(transaction);
    }
}
