public class NQueens {

	// Data
		int size;
		int [][] board;
		// = new int[size][size];

	public NQueens(int n)
	{
		size = n;
		board = new int[size][size];

	}

	public boolean placeNQueens() throws Exception
	{	if(size<=0)
			throw new Exception("Error");
		boolean x = true;
		if (placeQ(0))
			x=true;
			printToConsole();
		return x;
	}

	
	
	public boolean placeQ(int row) throws Exception
	{ 
		if(size==2| size ==3)
		{
			throw new Exception ("Invalid board size");
		}
		if (row == size)
			return true;
		
		for (int a = 0; a < size; a++){

		
			if(isSafe(row, a)){
				board[row][a]=1;
			
				if(placeQ(row+1))
					return true;

			}
			board[row][a]=0;		
		} 
		return false;			
	}
	

	public boolean isSafe(int row, int col)
	{	int i;
		int j;
		for(i=0; i<row;i++)
			if(board[i][col]==1)
				return false;
		for(i= row, j=col; i>=0 && j>=0; i--, j--)
			if(board[i][j]==1)
				return false;
		for(i=row, j=col; j<size && i>=0; i--, j++)
			if(board[i][j]==1)
				return false;
		
		return true;

	}


	public void printToConsole()
	{
		for (int i = 0; i<size; i++)
		{ for(int j= 0; j<size; j++ )
			{
				if (board[i][j]==1)
				{
					System.out.print("Q ");
				}
				else{
					System.out.print("_ ");
				}
			}
			System.out.println();
		} System.out.println("");
	}
}


