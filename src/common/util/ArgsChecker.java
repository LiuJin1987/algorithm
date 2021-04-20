package common.util;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/21 11:28
 **/
public class ArgsChecker {
    public static void checkArgs(Runnable runnable, String errorInfo) {
        try {
            runnable.run();
        } catch (ArrayIndexOutOfBoundsException e) {
            StdOut.println(errorInfo);
        }
    }
}
