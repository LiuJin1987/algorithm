package chapter1.section1;

/**
 * @author liujinlc
 * @date 2021/4/14 9:17
 **/
public class Ex17 {
    /**
    function will not stop until a stack overflow error occurs
     */
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }
}
