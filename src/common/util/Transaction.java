package common.util;

/**
 * @author liujinlc
 * @date 2021/4/23 11:19
 **/
public class Transaction implements Comparable<Transaction> {

    public static final double EQUAL_AMOUNT = 0.00001;
    private final String who;
    private final SmartDate when;
    private final double amount;

    public Transaction(String who, SmartDate when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] fields = transaction.split("\\s+");
        this.who = fields[0];
        this.when = new SmartDate(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        }
    }

    public String who() {
        return this.who;
    }

    public SmartDate when() {
        return this.when;
    }

    public double amount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return String.format("%s cost %.3f at %s", this.who, this.amount, this.when);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + this.who.hashCode();
        hash = 31 * hash + Integer.parseInt(String.format("%.0f", this.amount * 1000));
        hash = 31 * hash + this.when.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Transaction other = (Transaction) obj;
        if (this.who() == null) {
            return other.who() == null;
        }
        if (!this.who().equals(other.who())) {
            return false;
        }
        if (Math.abs(this.amount() - other.amount()) > EQUAL_AMOUNT) {
            return false;
        }
        if (this.when() == null) {
            return other.when() == null;
        }
        return this.when().equals(other.when);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Transaction o) {
        if (Math.abs(this.amount() - o.amount()) > EQUAL_AMOUNT) {
            return this.amount() > o.amount() ? 1 : -1;
        }
        if (this.when() == null) {
            return o.when() == null ? 0 : -1;
        }
        if (this.when().compareTo(o.when()) != 0) {
            return this.when().compareTo(o.when());
        }
        if (this.who() == null) {
            return o.who() == null ? 0 : -1;
        }
        return this.who().compareTo(o.who());
    }
}
