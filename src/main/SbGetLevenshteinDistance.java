package main;

public class SbGetLevenshteinDistance {
	
	public static int getLevDist(String first, String second)
	{
		int i, j, m, n, cost;
	    int matrix[][];

		   m = first.length();
		   n = second.length();
		   
		   matrix = new int[m+1][n+1];

		   for (i=0; i<=m; i++)
		   {
			   matrix[i][0] = i;
		   }
		   
		   for (j=1; j<=n; j++)
		   {
			   matrix[0][j] = j;
		   }		      

		   for (i=1; i<=m; i++)
		   {
		      for (j=1; j<=n; j++)
		      {
		           if (first.charAt(i-1) == second.charAt(j-1))
		              cost = 0;
		           else
		              cost = 1;

		           matrix[i][j] = Math.min(matrix[i-1][j] + 1,          /* remove */
		                          Math.min(matrix[i][j-1] + 1,      		/* insert */
                        		  matrix[i-1][j-1] + cost));   	/* change */
		      }
		   }

		   return matrix[m][n];
	}
}
