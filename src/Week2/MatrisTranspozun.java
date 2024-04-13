package Week2;

public class MatrisTranspozun {
    public static void main(String[] args) {
        // Define the given matrix
        int[][] matris = {
                {1,2,3},
                {4,5,6}
        };
        // Get the dimensions of the matrix
        int rowNum = matris.length;
        int colNum = matris[0].length;
        // Create a transpose matrix
        int[][] transpozMatris = new int[colNum][rowNum];

        // Calculate the transpose of the matrix
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                transpozMatris[j][i] = matris[i][j]  ;
            }
        }

        // Print the original matrix
        System.out.println("Matris : ");
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++) {
                System.out.print(matris[i][j] + "\t");
            }
            System.out.println();
        }

        // Print the transpose matrix
        System.out.println("Transpozon : ");
        for (int i = 0; i < colNum; i++){
            for (int j = 0; j < rowNum; j++) {
                System.out.print(transpozMatris[i][j] + "\t");
            }
            System.out.println();


        }
    }
}
