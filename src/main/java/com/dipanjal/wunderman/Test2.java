package com.dipanjal.wunderman;

import java.util.List;

/**
 * @author dipanjal
 * @since 5/27/2021
 */

public class Test2 {

    public static void printResult(final List<Triangle> triangles) {
        for(Triangle t : triangles){
            boolean isABC = t.a + t.b > t.c;
            boolean isBCA = t.b + t.c > t.a;
            boolean isCAB = t.c + t.a > t.b;
            if(isABC && isBCA && isCAB){
                if(t.a == t.b && t.b == t.c){
                    System.out.println("Equilateral");
                }else if((t.a == t.b) || (t.b == t.c) || (t.c == t.a)) {
                    System.out.println("Isosceles");
                }else{
                    System.out.println("Scalene");
                }
            }else{
                System.out.println("Not A Triangle");
            }
        }
    }

    private static class Triangle {
        private final int a;
        private final int b;
        private final int c;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }
    }

    public static void main(String[] args) {
        List<Triangle> triangles = List.of(
                new Triangle(20,20,23),
                new Triangle(20,20,20),
                new Triangle(20,21,22),
                new Triangle(13,14,30)
        );

        printResult(triangles);
    }
}
