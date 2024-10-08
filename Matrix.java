import java.util.Random;

public class Matrix
{
    private static Random rand = new Random();
    
    private int[][] array;
    private int numRows;
    int numColumns;
    
    public Matrix(int numRows, int numColumns)
    {
        this.array = new int[numRows][numColumns];
        this.numRows = numRows;
        this.numColumns = numColumns;
    }
    
    public void randomize()
    {
        for (int i = 0; i < this.numRows; i++)
        {
            for (int j = 0; j < this.numColumns; j++)
            {
                array[i][j] = 1 + rand.nextInt(50);
            }
        }
    }
}
