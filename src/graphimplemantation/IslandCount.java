package graphimplemantation;

public class IslandCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 1, 1, 0, 0, 0 }, 
                { 0, 1, 0, 0, 1 }, 
                { 1, 0, 0, 1, 1 }, 
                { 0, 0, 0, 0, 0 }, 
                { 1, 0, 1, 0, 1 } }; 
		System.out.println(countIsland(mat));

	}
	
	public static int countIsland(int[][] grid) {
		
		if(grid == null || grid.length == 0) {
			return 0;
		}
		int numIsland = 0;
		for(int i = 0 ; i < grid.length; i++) {
			for(int j = 0 ; j < grid.length; j++) {
				if(grid[i][j] == 1) {
					numIsland += dfs(grid,i,j);
				}
			}
		}
		return numIsland;
	}

	private static int dfs(int[][] grid, int i, int j) {

		if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0)
			return 0;
		
		grid[i][j] = 0;
		
		dfs(grid,i+1,j);
		dfs(grid,i-1,j);
		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
		return 1;
	}

}
