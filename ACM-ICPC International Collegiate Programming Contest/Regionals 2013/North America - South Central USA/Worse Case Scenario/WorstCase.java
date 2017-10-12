import java.util.*;
public class WorstCase {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		for(int i=0;i<test;i++)
		{
			int w = input.nextInt();
			int h = input.nextInt();
			char [][] grid = new char[h][w];
			for(int j=0;j<h;j++)
			{
				String line = input.next();
				for(int k=0;k<line.length();k++)
				{
					grid[j][k] = line.charAt(k);
				}
			}
			int infect = input.nextInt();
			int [] x = new int[infect]; // column
			int [] y = new int[infect]; // row
			for(int j=0;j<infect;j++)
			{
				x[j]=input.nextInt();
				y[j]=input.nextInt();
			}
			boolean [][] isVisted= new boolean[h][w];
			char [] [] print =infectzone(grid,isVisted,x,y);
			int count = 0;
			/*for(char [] a:print){
				for(char b: a)
					System.out.print(b);
			}*/
			for(int k=0;k<print.length;k++)
			{
				for(int l=0;l<print[0].length;l++)
				{
					System.out.print(""+print[k][l]);
				}
				System.out.println("");
			}
		}
	}
	public static char [][] infectzone(char [][] g, boolean [][] v, int [] col, int [] row)
	{
		for(int i=0;i<col.length;i++)
		{
			if(g[row[i]][col[i]]=='D')
			{
				v[row[i]][col[i]] = true;
				if(row[i]-1 >=0 && v[row[i]-1][col[i]]==false){
					infectD(col[i],row[i]-1,g,v);
				}
				if(row[i]+1 < g.length && v[row[i]+1][col[i]]==false){
					infectD(col[i],row[i]+1,g,v);
				}
				if(col[i]-1>=0 && v[row[i]][col[i]-1]==false){
					infectD(col[i]-1,row[i],g,v);
				}
				if(col[i]+1<g[0].length && v[row[i]][col[i]+1]==false){
					infectD(col[i]+1,row[i],g,v);
				}
				clear(v);
			}
			else if(g[row[i]][col[i]] !='X')
				g[row[i]][col[i]]= (char)(g[row[i]][col[i]]+1);  
		}
		return g;
	}
	public static char [][] infectD(int col, int row, char[][] grid, boolean[][] visit)
	{
		if(grid[row][col] !='D')
		{
			if(grid[row][col]!='X' && visit[row][col]==false){
				grid[row][col] = (char)(grid[row][col]+1);
				//visit[row][col]=true;
				}
			return grid;
		}
		else if(grid[row][col] =='D')
		{
			visit[row][col] = true;
			if(row-1>=0 && visit[row-1][col]==false )
				infectD(col,row-1,grid,visit);
			//clear(visit);
			if(row+1<grid.length && visit[row+1][col]==false)
				infectD(col,row+1,grid,visit);
			//clear(visit);
			if(col-1>=0 && visit[row][col-1]==false)
				infectD(col-1,row,grid,visit);
			//clear(visit);
			if(col+1<grid[0].length && visit[row][col+1]==false)
				infectD(col+1,row,grid,visit);
			//clear(visit);
		}
		return grid;
	}
	public static boolean[][] clear(boolean [][] visit)
	{
		for(int i=0;i<visit.length;i++)
			for(int j=0;j<visit[0].length;j++)
				visit[i][j]=false;
		return visit;
	}
}
