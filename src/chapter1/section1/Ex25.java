package chapter1.section1;

/**
 * @author liujinlc
 * @date 2021/4/14 22:17
 **/
public class Ex25 {
    public static void main(String[] args) {
        /*
        Greatest common divisor(Fgcd)

        c = gcd(a, b) => exist m,n -> a = m * c, b = n * c)
        let r = a mod b => exist k -> r = a - k * b = m * c - k * n * c = (m - k * n) * c
        => gcd(b, a mod b) = gcd(b, r) = gcd(n * c, (m - k * n) * c) = gcd(n, m - k * b) * c
        => c = cd(b, a mod b)

        let d = gcd(n, m - k * b) => exit x,y -> n = xd, m - k * n = yd
        => m = y * d + k * n = y * d + k * x * d = (y + k * x) * d
        => a = mc = (y + k * x) * d * c, b = n * c = x * d * c
        => gcd(a, b) = gcd((y + k * x) * d * c, x * d * c) = dc

        for gcd(a,b) = c => d = 1
        => gcd(n, m - k * b) = 1 => gcd(b,a mod b) = c
        => gcd(a,b) = gcd(b,a mod b).
         */
    }
}
