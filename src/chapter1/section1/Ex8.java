package chapter1.section1;

/**
 * @author liujinlc
 * @date 2021/4/13 15:30
 **/
public class Ex8 {
    /**
    ASCII code:
     'a' -> 97 or 0x61
     'b' -> 98 or 0x62
     'c' -> 99 or 0x63
     'e' -> 101 or 0x67
     */
    public static void main(String[] args) {
        /*
        b
        a singular character will be cast to a String by its toString() method
         */
        System.out.println('b');
        /*
        197
        '+' in this context means math add but not the overridden '+' in String,
        thus a 'b' will be upcast to an Integer 98 and a 'c' will be upcast to
        an Integer 99, then the result of 'b' + 'c' is 199
         */
        System.out.println('b' + 'c');
        /*
        e
        in expression 'a' + 4, 'a' will be upcast to 97 thus the whole
        expression values 101, which is an 'e' when force casted to char
         */
        System.out.println((char) ('a' + 4));
    }
}
