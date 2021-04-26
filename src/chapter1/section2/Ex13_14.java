package chapter1.section2;

import common.util.SmartDate;
import common.util.Transaction;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/23 11:04
 **/
public class Ex13_14 {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(null, null, 0.0);
        Transaction transaction2 = new Transaction(
                "Alan", new SmartDate(3, 25, 2012), 0.0);
        StdOut.println(transaction1);
        StdOut.println(transaction1.equals(transaction2));
        StdOut.println(transaction1.compareTo(transaction2));
    }
}
