package Matrici;

import java.util.Scanner;

public class Matrici {

    public static int inmultireMatrice(int[][] primaMatrice, int[][] aDouaMatrice, int rand, int coloana) {
        int rezultat = 0;
        for (int i = 0; i < aDouaMatrice.length; i++) {
            rezultat += primaMatrice[rand][i] * aDouaMatrice[i][coloana];
        }
        return rezultat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduceti dimensiunea matricei...");
        int matrixDimension = sc.nextInt();
        int[][] matriceA = new int[matrixDimension][matrixDimension];

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementelor de pe diagonala principala.");
        int mainDiagValue = sc.nextInt();

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementelor de pe diagonala secundara.");
        int sndDiagValue = sc.nextInt();

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementului de pe pozitia din centru a matricei");
        int centerValue = sc.nextInt();

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementelor din „stanga“");
        int leftValue = sc.nextInt();

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementelor din „partea de sus“");
        int upValue = sc.nextInt();

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementelor din „dreapta“");
        int rightValue = sc.nextInt();

        System.out.println("Introduceti un numar intreg, ce reprezinta valoarea elementelor din „partea de jos“");
        int bottomValue = sc.nextInt();


        for (int i = 0; i < matriceA.length; i++) {

            for (int j = 0; j < matriceA[i].length; j++) {
                if (i == j) {
                    matriceA[i][j] = mainDiagValue;
                } else if (i + j == matriceA.length - 1) {
                    matriceA[i][j] = sndDiagValue;
                } else if (i > j && i + j < matriceA.length) {
                    matriceA[i][j] = leftValue;
                } else if (i < j && i + j >= matriceA.length) {
                    matriceA[i][j] = rightValue;
                } else if (i < j && i + j < matriceA.length) {
                    matriceA[i][j] = upValue;
                } else if (i > j && i + j >= matriceA.length) {
                    matriceA[i][j] = bottomValue;
                }
            }

        }
        if (matrixDimension % 2 != 0) {
            matriceA[matrixDimension / 2][matrixDimension / 2] = centerValue;
        }
        System.out.println("Matricea A");
        for (int i = 0; i < matriceA.length; i++) {
            for (int j = 0; j < matriceA[i].length; j++) {
                System.out.print(matriceA[i][j] + " ");
            }
            System.out.println();
        }
        int[][] matriceB = new int[matrixDimension][matrixDimension];
        for (int i = 0; i < matriceB.length; i++) {
            for (int j = 0; j < matriceB[i].length; j++) {
                matriceB[i][j] = 1;
            }
        }
        System.out.println("Matricea B");
        for (int i = 0; i < matriceB.length; i++) {
            for (int j = 0; j < matriceB[i].length; j++) {
                System.out.print(matriceB[i][j] + " ");
            }
            System.out.println();
        }

        //Adunarea a doua matrici

        int[][] matriceC = new int[matrixDimension][matrixDimension];
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                matriceC[i][j] = matriceA[i][j] + matriceB[i][j];
            }
            System.out.println();
        }
        System.out.println("A + B = C");
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                System.out.print(matriceC[i][j] + " ");
            }
            System.out.println();
        }
        //Scaderea a doua matrici

        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                matriceC[i][j] = matriceA[i][j] - matriceB[i][j];
            }
            System.out.println();
        }
        System.out.println("A - B = C");
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                System.out.print(matriceC[i][j] + " ");
            }
            System.out.println();
        }
        //Inmultirea a  doua matrici
        matriceA = new int[matrixDimension - 1][matrixDimension];

        int count = 1;
        for (int i = 0; i < matriceA.length; i++) {

            for (int j = 0; j < matriceA[i].length; j++) {

                matriceA[i][j] = count;
                count++;
            }
        }
        System.out.println("Matricea A");
        for (int i = 0; i < matriceA.length; i++) {
            for (int j = 0; j < matriceA[i].length; j++) {
                System.out.print(matriceA[i][j] + " ");
            }
            System.out.println();
        }
        matriceB = new int[matrixDimension][matrixDimension - 1];
        for (int i = 0; i < matriceB.length; i++) {
            for (int j = 0; j < matriceB[i].length; j++) {
                matriceB[i][j] = 2;
            }
        }
        System.out.println("Matricea B");
        for (int i = 0; i < matriceB.length; i++) {
            for (int j = 0; j < matriceB[i].length; j++) {
                System.out.print(matriceB[i][j] + " ");
            }
            System.out.println();
        }
        matriceC = new int[matrixDimension - 1][matrixDimension - 1];
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                matriceC[i][j] = inmultireMatrice(matriceA, matriceB, i, j);
            }
            System.out.println();
        }
        System.out.println("Matricea C");
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                System.out.print(matriceC[i][j] + " ");
            }
            System.out.println();
        }
        //Inmultirea cu un scalar
        matriceC = new int[matrixDimension - 1][matrixDimension];
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                matriceC[i][j] = matriceA[i][j] * 5;
            }
            System.out.println();
        }
        System.out.println("A * 5 = C");
        for (int i = 0; i < matriceC.length; i++) {
            for (int j = 0; j < matriceC[i].length; j++) {
                System.out.print(matriceC[i][j] + " ");
            }
            System.out.println();
        }


    }
}
