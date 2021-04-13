package chapter1.section1;

/**
 * @author liujinlc
 * @date 2021/4/13 15:05
 **/
public class Ex4 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        /*
        Without define a, b, c and initiating a, b,
        all the code below will not work
         */
        int a = 1;
        int b = 2;
        int c;
        /*
        //Cannot resolve symbol 'then'
        if (a > b) then c = 0;
        */
        // OK
        if (a > b) {
            c = 0;
        }
        // OK
        if (a > b) c = 0;
        /*
        // ';' expected after "c = 0"
        if (a > b) c = 0 else b = 0;
        */
    }
}
