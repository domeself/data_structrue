package graph;

public class TestMain {
    public static void main(String[] args) {
        /**
         *       -3-->B--3-
         *   A--|-------5--|--->D
         *       -2-->C--4-
         */
        Matrix matrix = new Matrix();
        String[] topoint = new String[]{"A","B","C","D","E","F"};
        matrix.addGraph(topoint);
        matrix.addElment("A","B",3);
        matrix.addElment("A","C",2);
        matrix.addElment("A","D",5);
        matrix.addElment("B","D",3);
        matrix.addElment("B","F",4);
        matrix.addElment("D","E",5);
        matrix.addElment("D","F",3);
        matrix.addElment("C","E",3);
        matrix.addElment("C","D",2);
        matrix.addElment("E","F",1);
        matrix.print();
        System.out.println(matrix.getMin("A", "F"));



    }
}
