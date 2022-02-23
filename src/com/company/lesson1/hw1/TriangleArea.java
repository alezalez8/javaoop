package com.company.javaoop.lesson1.hw1;

public class TriangleArea {
    private double sideA;
    private double sideB;
    private double sideC;

    public TriangleArea(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public TriangleArea() {
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getArea() {
        double area = 0;
        if ((sideA + sideB) > sideC
                && (sideA + sideC) > sideB
                && (sideB + sideC) > sideA) {
            double halfPerimeter = (sideA + sideB + sideC) / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - sideA)
                    * (halfPerimeter - sideB)
                    * (halfPerimeter - sideC));
        } else {
            System.out.println("This triangle can't be valid, result = 0");
                   }
        return area;
    }
}

class TriangleTester {

    public static void main(String[] args) {
        TriangleArea triangle1 = new TriangleArea(10, 15, 23);
        TriangleArea triangle2 = new TriangleArea(20, 18, 25);
        TriangleArea triangle3 = new TriangleArea(10, 15, 25);
        TriangleArea triangle4 = new TriangleArea();

        triangle4.setSideA(45);
        triangle4.setSideB(65);
        triangle4.setSideC(82);

        double area = triangle1.getArea();
        System.out.printf("Area is  %.2f \n", area);
        area = triangle2.getArea();
        System.out.printf("Area is  %.2f \n", area);
        area = triangle4.getArea();
        System.out.printf("Area is  %.2f \n", area);
        area = triangle3.getArea();
        System.out.printf("Area is  %.2f \n", area);

    }
}
/*
   ------- output:
*       Area is  54,99
        Area is  178,29
        Area is  1457,69
        This triangle can't be valid, result = 0
        Area is  0,00
* */