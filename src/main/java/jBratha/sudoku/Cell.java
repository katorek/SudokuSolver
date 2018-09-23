package jBratha.sudoku;


import java.util.Arrays;
import java.util.stream.IntStream;

public class Cell {
    private int[] posib;
    private int certainNumber;

    public Cell(int certainNumber) {
        posib = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.certainNumber = certainNumber;
    }

    public Cell() {
        this(0);
    }

    public int[] getPosib() {
        return Arrays.stream(posib).filter(e -> e != 0).toArray();
    }

    public void setPosib(int[] posib) {
        this.posib = posib;
    }

    public int get() {
        return certainNumber;
    }

    public void setCertainNumber(int certainNumber) {
        posib[certainNumber] = 0;
        this.certainNumber = certainNumber;
    }

    public void setVal(int val) {
        this.certainNumber = val;
    }

    public boolean isCertainInPosibs(int certain) {
        return posib[certain - 1] == certain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return certainNumber == cell.certainNumber;
    }

    @Override
    public int hashCode() {
        return certainNumber;
    }

    public void addPosibility(int val) {
        if (Arrays.stream(posib).anyMatch(e -> e == val)) return;
        posib[val - 1] = val;
    }

    public void deletePosibility(int val) {
        posib[val - 1] = 0;
//        for (int i = 0; i < posib.length; i++) {
//            if(posib[i]==val) posib[i]=0;
//        }
    }

    public void clearPosibilities() {
        IntStream.range(1, 9).forEach(this::deletePosibility);
    }
}
