//
//import assignment2.IntGrid;
//import java.util.Arrays;
//
///*
//Important: you must enable assertion for your project as follows:
//1) Right click on the project in the Project Explorer
//2) Choose Properties (at the bottom of pop up menu)
//3) Choose Run (under Categories)
//4) In the VM Options field, enter -ea
//5) Click OK
// */
//public class IntGridTestDriver {
//
//    public static void main(String[] args) {
//        System.out.println("Testing constructor that takes a ragged array");
//        int[][] a_ragged_array
//                = {{17, 18, 25, 2, 15}, {16, 5, 7, 14},
//                {22, 6, 13, 20},
//                {3, 12, 19, 21, 10},
//                {11, 24}
//                };
//        // instantiate a new IntGrid object using a_ragged_array above
//        IntGrid it1 = new IntGrid(a_ragged_array);
//        System.out.println(it1);
//        it1.printGridFeatures();
//
//        assert (it1.numRows() == 5); // test numRows()
//        assert (it1.numColumns() == 5); // test numColumns()
//
//        // test getRow
//        assert (Arrays.equals(it1.getRow(0), new int[]{17, 18, 25, 2, 15}));
//        assert (Arrays.equals(it1.getRow(1), new int[]{16, 5, 7, 14, 0}));
//        assert (Arrays.equals(it1.getRow(2), new int[]{22, 6, 13, 20, 0}));
//        assert (Arrays.equals(it1.getRow(3), new int[]{3, 12, 19, 21, 10}));
//        assert (Arrays.equals(it1.getRow(4), new int[]{11, 24, 0, 0, 0}));
//        System.out.println("Constructor taking a ragged array: " + "OK");
//
//        System.out.println("\nTesting getElement+ setElement");
//        assert (it1.getElement(4, 1) - it1.getElement(4, 0) == 13);
//        assert (it1.getElement(1, 4) == it1.getElement(4, 4));
//        it1.setElement(1, 4, 23);
//        it1.setElement(4, 2, 1);
//        it1.setElement(4, 3, 8);
//        it1.setElement(4, 4, 9);
//        it1.setElement(2, 4, 4);
//
//        assert (Arrays.equals(it1.getRow(0), new int[]{17, 18, 25, 2, 15}));
//        assert (Arrays.equals(it1.getRow(1), new int[]{16, 5, 7, 14, 23}));
//        assert (Arrays.equals(it1.getRow(2), new int[]{22, 6, 13, 20, 4}));
//        assert (Arrays.equals(it1.getRow(3), new int[]{3, 12, 19, 21, 10}));
//        assert (Arrays.equals(it1.getRow(4), new int[]{11, 24, 1, 8, 9}));
//        System.out.println("\nTested  getElement+ setElement: OK");
//
//        System.out.println("\nTesting copy constructor");
//        IntGrid it2 = new IntGrid(it1);
//        assert (it1.equals(it2));
//        System.out.println("Tested  copy constructor: " + "OK");
//
//        System.out.println("\nTesting set and get element methods");
//        // swap the elements at the two ends of the main diagonal
//        int temp = it1.getElement(0, 0);
//        it1.setElement(0, 0, it1.getElement(4, 4));
//        it1.setElement(4, 4, temp);
//
//        // swap the elements at the two ends of the sub-diagonal
//        int temp2 = it1.getElement(0, 4);
//        it1.setElement(0, 4, it1.getElement(4, 0));
//        it1.setElement(4, 0, temp2);
//
//        assert (Arrays.equals(it1.getRow(0), new int[]{9, 18, 25, 2, 11}));
//        assert (Arrays.equals(it1.getRow(1), new int[]{16, 5, 7, 14, 23}));
//        assert (Arrays.equals(it1.getRow(2), new int[]{22, 6, 13, 20, 4}));
//        assert (Arrays.equals(it1.getRow(3), new int[]{3, 12, 19, 21, 10}));
//        assert (Arrays.equals(it1.getRow(4), new int[]{15, 24, 1, 8, 17}));
//        System.out.println("\nTested  set and get element methods: OK");
//
//        System.out.println("\nTesting swapRows");
//        // swap top and bottom rows
//        it2.swapRows(0, 4);
//        assert (Arrays.equals(it1.getRow(4), new int[]{15, 24, 1, 8, 17}));
//        assert (Arrays.equals(it1.getRow(1), new int[]{16, 5, 7, 14, 23}));
//        assert (Arrays.equals(it1.getRow(2), new int[]{22, 6, 13, 20, 4}));
//        assert (Arrays.equals(it1.getRow(3), new int[]{3, 12, 19, 21, 10}));
//        assert (Arrays.equals(it1.getRow(0), new int[]{9, 18, 25, 2, 11}));
//
//        System.out.println("\nTested  swapRows: OK");
//
//        System.out.println("\nTesting swapColumns");
//        // swap elements of first column and last column,
//        it1.swapColumns(0, it1.numColumns() - 1);
//        assert (Arrays.equals(it1.getRow(4), new int[]{17, 24, 1, 8, 15}));
//        assert (Arrays.equals(it1.getRow(1), new int[]{23, 5, 7, 14, 16}));
//        assert (Arrays.equals(it1.getRow(2), new int[]{4, 6, 13, 20, 22}));
//        assert (Arrays.equals(it1.getRow(3), new int[]{10, 12, 19, 21, 3}));
//        assert (Arrays.equals(it1.getRow(0), new int[]{11, 18, 25, 2, 9}));
//        System.out.println("\nTested  swapColumns: OK");
//        it1.printGridFeatures();
//
//        System.out.println("\nTesting setTable passing a 2D array");
//        int[][] array2d = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 1}, {3, 4, 5, 1, 2},
//        {4, 5, 1, 2, 3}, {5, 1, 2, 3, 4}};
//        it1.setGrid(array2d);
//        System.out.println(it1);
//        it1.printGridFeatures();
//        assert (Arrays.equals(it1.getRow(0), new int[]{1, 2, 3, 4, 5}));
//        assert (Arrays.equals(it1.getRow(1), new int[]{2, 3, 4, 5, 1}));
//        assert (Arrays.equals(it1.getRow(2), new int[]{3, 4, 5, 1, 2}));
//        assert (Arrays.equals(it1.getRow(3), new int[]{4, 5, 1, 2, 3}));
//        assert (Arrays.equals(it1.getRow(4), new int[]{5, 1, 2, 3, 4}));
//        System.out.println("Tested  setTable passing a 2D array: " + "OK");
//
//        System.out.println("\nTesting row, column, and diagonal sums, and min, max");
//        assert (Arrays.equals(it1.allRowSums(), new int[]{15, 15, 15, 15, 15}));
//        assert (Arrays.equals(it1.allColumnSums(), new int[]{15, 15, 15, 15, 15}));
//        assert (it1.majorDiagonalSums() == 15);
//        assert (it1.minorDiagonalSums() == 25);
//        assert (it1.min() == 1);
//        assert (it1.max() == 5);
//        assert (it1.isMagicSquare() == false);
//        System.out.println("Tested  row, column, and diagonal sums, and min, max: " + "OK");
//
//        System.out.println("\nTesting constructor taking two int arguments - wide grid");
//        IntGrid it3 = new IntGrid(3, 8);
//        System.out.println(it3);
//        it3.printGridFeatures();
//
//        assert (Arrays.equals(it3.getRow(0), new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
//        assert (Arrays.equals(it3.getRow(1), new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
//        assert (Arrays.equals(it3.getRow(2), new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
//        assert (Arrays.equals(it3.allRowSums(), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it3.allColumnSums(), new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
//        assert (it3.majorDiagonalSums() == 0);
//        assert (it3.minorDiagonalSums() == 0);
//        assert (it3.numRows() == 3);
//        assert (it3.numColumns() == 8);
//        System.out.println("Tested  constructor taking two int arguments - wide grid: " + "OK");
//
////        System.out.println("\nTesting setRow - wide case");
////        it3.setRow(0, new int[]{2, 11, 16, 19, 22, 15, 8, 5});
////        it3.setRow(1, new int[]{21, 23, 13, 7, 20, 18, 12, 1});
////        it3.setRow(2, new int[]{3, 4, 24, 10, 17, 14, 9, 6});
//        System.out.println(it3);
//        it3.printGridFeatures();
//
//        assert (Arrays.equals(it3.getRow(0), new int[]{2, 11, 16, 19, 22, 15, 8, 5}));
//        assert (Arrays.equals(it3.getRow(1), new int[]{21, 23, 13, 7, 20, 18, 12, 1}));
//        assert (Arrays.equals(it3.getRow(2), new int[]{3, 4, 24, 10, 17, 14, 9, 6}));
//        assert (Arrays.equals(it3.allRowSums(), new int[]{98, 115, 87}));
//        assert (Arrays.equals(it3.allColumnSums(), new int[]{26, 38, 53, 36, 59, 47, 29, 12}));
//        assert (it3.majorDiagonalSums() == 82);
//        assert (it3.minorDiagonalSums() == 73);
//        assert (it3.numRows() == 3);
//        assert (it3.numColumns() == 8);
//        System.out.println("Tested  setRow - wide case: " + "OK");
//
//        System.out.println("\nTesting constructor taking two int arguments - Tall grid");
//        IntGrid it4 = new IntGrid(8, 3);
//        System.out.println(it4);
//        it4.printGridFeatures();
//
//        assert (Arrays.equals(it4.getRow(0), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(1), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(2), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(3), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(4), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(5), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(6), new int[]{0, 0, 0}));
//        assert (Arrays.equals(it4.getRow(7), new int[]{0, 0, 0}));
//
//        assert (Arrays.equals(it4.allRowSums(), new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
//        assert (Arrays.equals(it4.allColumnSums(), new int[]{0, 0, 0}));
//        assert (it4.majorDiagonalSums() == 0);
//        assert (it4.minorDiagonalSums() == 0);
//        assert (it4.numRows() == 8);
//        assert (it4.numColumns() == 3);
//        System.out.println("Tested  constructor taking two int arguments - Tall grid: " + "OK");
//
////        System.out.println("\nTesting setRow - Tall case");
////        it4.setRow(0, new int[]{1, 24, 6});
////        it4.setRow(1, new int[]{19, 21, 12});
////        it4.setRow(2, new int[]{16, 2, 14});
////        it4.setRow(3, new int[]{13, 18, 10});
////        it4.setRow(4, new int[]{5, 7, 17});
////        it4.setRow(5, new int[]{15, 9, 23});
////        it4.setRow(6, new int[]{8, 3, 22});
////        it4.setRow(7, new int[]{4, 11, 20});
//        System.out.println(it4);
//        it4.printGridFeatures();
//
//        assert (Arrays.equals(it4.getRow(0), new int[]{1, 24, 6}));
//        assert (Arrays.equals(it4.getRow(1), new int[]{19, 21, 12}));
//        assert (Arrays.equals(it4.getRow(2), new int[]{16, 2, 14}));
//        assert (Arrays.equals(it4.getRow(3), new int[]{13, 18, 10}));
//        assert (Arrays.equals(it4.getRow(4), new int[]{5, 7, 17}));
//        assert (Arrays.equals(it4.getRow(5), new int[]{15, 9, 23}));
//        assert (Arrays.equals(it4.getRow(6), new int[]{8, 3, 22}));
//        assert (Arrays.equals(it4.getRow(7), new int[]{4, 11, 20}));
//
//        assert (Arrays.equals(it4.allRowSums(), new int[]{31, 52, 32, 41, 29, 47, 33, 35}));
//        assert (Arrays.equals(it4.allColumnSums(), new int[]{81, 95, 124}));
//        assert (it4.majorDiagonalSums() == 74);
//        assert (it4.minorDiagonalSums() == 73);
//        assert (it4.numRows() == 8);
//        assert (it4.numColumns() == 3);
//        System.out.println("Tested  setRow - Tall case: " + "OK");
//
////        System.out.println("\nTesting isMagicSquare");
////        it2.setRow(0, new int[]{1, 1, 1, 1, 1});
////        it2.setRow(1, new int[]{1, 1, 1, 1, 1});
////        it2.setRow(2, new int[]{1, 1, 1, 1, 1});
////        it2.setRow(3, new int[]{1, 1, 1, 1, 1});
////        it2.setRow(4, new int[]{1, 1, 1, 1, 1});
////        System.out.println(it2);
////        it2.printGridFeatures();
////        assert (it2.isMagicSquare() == false);
////        it2.setRow(0, new int[]{17, 24, 1, 8, 15});
////        it2.setRow(1, new int[]{23, 5, 7, 14, 16});
////        it2.setRow(2, new int[]{4, 6, 13, 20, 22});
////        it2.setRow(3, new int[]{10, 12, 19, 21, 3});
////        it2.setRow(4, new int[]{11, 18, 25, 2, 9});
////        System.out.println(it2);
////        it2.printGridFeatures();
////        assert (it2.isColumnMagic() == true);
////        System.out.println("Tested isMagicSquare: " + "OK");
//        System.out.println("\nCongratulations! your program seems to be working correctly!");
//    }
//}
