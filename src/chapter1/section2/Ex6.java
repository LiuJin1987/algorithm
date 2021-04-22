package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author liujinlc
 * @date 2021/4/22 15:44
 **/
public class Ex6 {
    public static void main(String[] args) {
        String s = "abcdefghijklmn";
        String t = "ijklmnabcdefgh";
        StdOut.println(isCircularRotation(s, t));
    }

    private static boolean isCircularRotation(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }
        /*System.out.println(s.substring(0, s.indexOf(t.substring(0, 1))));
        System.out.println(s.substring(s.indexOf(t.substring(0, 1))));
        System.out.println(s.substring(s.indexOf(t.substring(0, 1))) + s.substring(0, s.indexOf(t.substring(0, 1))));*/
        return t.equals(s.substring(s.indexOf(t.substring(0, 1))) + s.substring(0, s.indexOf(t.substring(0, 1))));
    }
}
