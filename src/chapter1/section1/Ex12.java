package chapter1.section1;

/**
 * @author liujinlc
 * @date 2021/4/13 22:58
 **/
public class Ex12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println(a[i]);
        }
    }
}
