

public class TwentyGrid {
	private int[][] grid;
	private final int BASIS;
	private final int DIMENS;
	
	public TwentyGrid() {
		DIMENS = 4;
		grid = new int[DIMENS][DIMENS];
		BASIS = 2;
		for (int i = 0; i <= 1; i++) {
			int slotX;
			int slotY;
			do {
				slotX = (int)(DIMENS*Math.random());
				slotY = (int)(DIMENS*Math.random());
			}
			while (grid[slotY][slotX] != 0);
			grid[slotY][slotX] = BASIS;
			
		}
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	public int getBASIS() {
		return BASIS;
	}
	
	public int getDIMENS() {
		return DIMENS;
	}
	
	private void swap(int[][] arr, int a, int b, int c, int d) {
		int temp = arr[a][b];
		arr[a][b] = arr[c][d];
		arr[c][d] = temp;
	}
	
	private void genNewBlock() {
		int slotX;
		int slotY;
		do {
			slotX = (int)(DIMENS*Math.random());
			slotY = (int)(DIMENS*Math.random());
		}
		while (grid[slotY][slotX] != 0);
		grid[slotY][slotX] = BASIS + ((int)(10*Math.random() + 1)/10)*BASIS;
	}
	
	public void moveDown() {
		// smoosh
		for (int i = 0; i < grid.length; i++) {
			int place = DIMENS-1;
			for (int j = grid[0].length-1; j >= 0; j--) {
				if (grid[place][i] != 0) {
					place--;
					continue;
				}
				if (grid[j][i] != 0) {
					swap(grid, place, i, j, i);
					place--;
				}
			}
		}
		// combine
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[0].length-1; j >= 1; j--) {
				if (grid[j][i] == grid[j-1][i]) {
					grid[j-1][i] = 0;
					grid[j][i] *= 2;
					break;
				}
			}
		}
		// smoosh 2
		for (int i = 0; i < grid.length; i++) {
			int place = DIMENS-1;
			for (int j = grid[0].length-1; j >= 0; j--) {
				if (grid[place][i] != 0) {
					place--;
					continue;
				}
				if (grid[j][i] != 0) {
					swap(grid, place, i, j, i);
					place--;
				}
			}
		}
		genNewBlock();
	}
	
	public void moveUp() {
		// smoosh
		for (int i = 0; i < grid.length; i++) {
			int place = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[place][i] != 0) {
					place++;
					continue;
				}
				if (grid[j][i] != 0) {
					swap(grid, place, i, j, i);
					place++;
				}
			}
		}
		// combine
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length-1; j++) {
				if (grid[j][i] == grid[j+1][i]) {
					grid[j+1][i] = 0;
					grid[j][i] *= 2;
					break;
				}
			}
		}
		// smoosh 2
		for (int i = 0; i < grid.length; i++) {
			int place = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[place][i] != 0) {
					place++;
					continue;
				}
				if (grid[j][i] != 0) {
					swap(grid, place, i, j, i);
					place++;
				}
			}
		}
		genNewBlock();
	}
	
	public void moveLeft() {
		// smoosh
		for (int i = 0; i < grid.length; i++) {
			int place = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][place] != 0) {
					place++;
					continue;
				}
				if (grid[i][j] != 0) {
					swap(grid, i, place, i, j);
					place++;
				}
			}
		}
		// combine
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length-1; j++) {
				if (grid[i][j] == grid[i][j+1]) {
					grid[i][j+1] = 0;
					grid[i][j] *= 2;
					break;
				}
			}
		}
		// smoosh 2
		for (int i = 0; i < grid.length; i++) {
			int place = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][place] != 0) {
					place++;
					continue;
				}
				if (grid[i][j] != 0) {
					swap(grid, i, place, i, j);
					place++;
				}
			}
		}
		genNewBlock();
	}
	
	public void moveRight() {
		// smoosh
		for (int i = 0; i < grid.length; i++) {
			int place = DIMENS-1;
			for (int j = grid[0].length-1; j >= 0; j--) {
				if (grid[i][place] != 0) {
					place--;
					continue;
				}
				if (grid[i][j] != 0) {
					swap(grid, i, place, i, j);
					place--;
				}
			}
		}
		// combine
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[0].length-1; j >= 1; j--) {
				if (grid[i][j] == grid[i][j-1]) {
					grid[i][j-1] = 0;
					grid[i][j] *= 2;
					break;
				}
			}
		}
		// smoosh 2
		for (int i = 0; i < grid.length; i++) {
			int place = DIMENS-1;
			for (int j = grid[0].length-1; j >= 0; j--) {
				if (grid[i][place] != 0) {
					place--;
					continue;
				}
				if (grid[i][j] != 0) {
					swap(grid, i, place, i, j);
					place--;
				}
			}
		}
		genNewBlock();
	}
}
