package controller;

/**
 * A pair of row and column for a location.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class Pair{

    private final int left;
    private final int right;

    /**
     * The constructor of a pair.
     * @param left the row.
     * @param right the column.
     */
    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /**
     * @return the row.
     */
    public int getLeft() { return left; }

    /**
     * @return the column.
     */
    public int getRight() { return right; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.left == pairo.getLeft() && this.right == pairo.getRight();
    }

}
