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
	
	public static Matrix addMatrices(Matrix a, Matrix b)
	{
	    if (a.numRows != b.numRows || a.numColumns != b.numColumns)
	        return null;
	    
	    Matrix result = new Matrix(a.numRows, b.numColumns);
	    
	    for (int i = 0; i < a.numRows; i++)
	    {
	        for (int j = 0; j < a.numColumns; j++)
	        {
	            result.array[i][j] = a.array[i][j] + b.array[i][j];
	        }
	    }
	    return result;
	}
	
	public static Matrix subMatrices(Matrix a, Matrix b)
	{
	    if (a.numRows != b.numRows || a.numColumns != b.numColumns)
	        return null;
	    
	    Matrix result = new Matrix(a.numRows, b.numColumns);
	    
	    for (int i = 0; i < a.numRows; i++)
	    {
	        for (int j = 0; j < a.numColumns; j++)
	        {
	            result.array[i][j] = a.array[i][j] - b.array[i][j];
	        }
	    }
	    return result;
	}
	
	public static Matrix multiplyMatrices(Matrix a, Matrix b)
	{
	    if (a.numColumns != b.numRows)
	    {
	        return null;
	    }
	    
	    Matrix result = new Matrix(a.numRows, b.numColumns);
	    
	    for (int i = 0; i < a.numRows; i++)
	    {
	        for (int j = 0; j < b.numColumns; j++)
	        {
	            for (int k = 0; k < b.numRows; k++)
	            {
	                result.array[i][j] += a.array[i][k] * b.array[k][j];
	            }
	        }
	    }
	    return result;
	}
	
	public void display()
	{
	    for (int i = 0; i < this.numRows; i++)
	    {
	        for (int j = 0; j < this.numColumns - 1; j++)
	        {
	            System.out.print("" + this.array[i][j] + "\t");
	        }
	        System.out.println("" + this.array[i][this.numColumns - 1]);
	    }
	}
	
	public static void main(String[] args)
	{
		Matrix a = new Matrix(4, 4);
		a.randomize();
		Matrix b = new Matrix(4, 4);
		b.randomize();
		Matrix c = new Matrix(3, 5);
		c.randomize();
		Matrix d = new Matrix(5, 3);
		d.randomize();
		
		System.out.println("Matrix A:");
		a.display();
		
		System.out.println("\nMatrix B:");
		b.display();
		
		Matrix sum = Matrix.addMatrices(a, b);
		System.out.println("\nResult of A + B:");
		sum.display();
		
		Matrix diff = Matrix.subMatrices(a, b);
		System.out.println("\nResult of A - B:");
		diff.display();
		
		System.out.println("Matrix C:");
		c.display();
		
		System.out.println("\nMatrix D:");
		d.display();
		
		Matrix product = Matrix.multiplyMatrices(c, d);
		System.out.println("\nResult of C x D:");
		product.display();
	}
}
