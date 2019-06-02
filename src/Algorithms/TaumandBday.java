package Algorithms;

public class TaumandBday {

    public static int taumBday(int b, int w, int bc, int wc, int z) {
        int x,y;

        x = (w+z < b) ? w+z : b;
        y = (b+z < w) ? b+z : w;

        return x * b + y * w;

//        if (bc == wc && wc == z) {
//            return (b * bc) + (w * wc);
//        }
//
//        return Math.min(getThird(b,w,bc,wc,z),Math.min(getFirst(b,w,bc,wc,z), getSecond(b,w,bc,wc,z)));
    }

    protected static int getFirst(int b, int w, int bc, int wc, int z) {
        return (b * bc) + (w * wc);
    }

    protected static int getSecond(int b, int w, int bc, int wc, int z) {
        return (b * (wc + z)) + w * wc;
    }

    protected static int getThird(int b, int w, int bc, int wc, int z) {
        return (w * (bc + z)) + b * bc;
    }
}
