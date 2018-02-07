
import java.util.Scanner;

//	BOJ - 12100
//	Algorithm - ?
//	Samsung SW

public class Main {
	private static int n;
	
	private static class Map{
		int [][] map;
		
		public Map(int [][] map) {
			this.map = map;
		}
		public Map() {
			this.map = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					this.map[i][j] = 0;
				}
			}
		}
		
		public Map(Scanner scn) {
			map = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = scn.nextInt();
				}
			}
		}
		
		public void print() {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(this.map[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		public int max_num() {
			int max_num=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(max_num<this.map[i][j]) {
						max_num = this.map[i][j];
					}
				}
			}
			return max_num;
		}
		
		public void slide(int dir) {
			int [][] map = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = 0;
				}
			}
			// dir = 0:east, 1:west, 2:south, 3:north 
			if(dir==0) {	// east
				int y_pivot;
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=n-2;j>=0;j--) {
						if(this.map[i][j]!=0 && j!=n-1) {
							y_pivot = j;
							while(true) {
								if(y_pivot==n-1) break;
								if(this.map[i][y_pivot+1]==0) {
									this.map[i][y_pivot+1] = this.map[i][y_pivot];
									this.map[i][y_pivot] = 0;
								}
								y_pivot++;
							}
						}
					}
				}
				for(int i=0;i<n;i++) {	//	merge
					for(int j=n-1;j>0;j--) {
						if(this.map[i][j]==this.map[i][j-1]) {	// dir same num merge
							this.map[i][j]*=2;
							this.map[i][j-1] = 0;
						}
					}
				}
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=n-2;j>=0;j--) {
						if(this.map[i][j]!=0 && j!=n-1) {
							y_pivot = j;
							while(true) {
								if(y_pivot==n-1) break;
								if(this.map[i][y_pivot+1]==0) {
									this.map[i][y_pivot+1] = this.map[i][y_pivot];
									this.map[i][y_pivot] = 0;
								}
								y_pivot++;
							}
						}
					}
				}
			}
			else if(dir==1) {	// west
				int y_pivot;
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=1;j<=n-1;j++) {
						if(this.map[i][j]!=0 && j!=0) {
							y_pivot = j;
							while(true) {
								if(y_pivot==0) break;
								if(this.map[i][y_pivot-1]==0) {
									this.map[i][y_pivot-1] = this.map[i][y_pivot];
									this.map[i][y_pivot] = 0;
								}
								y_pivot--;
							}
						}
					}
				}
				for(int i=0;i<n;i++) {	//	merge
					for(int j=0;j<n-1;j++) {
						if(this.map[i][j]==this.map[i][j+1]) {	// dir same num merge
							this.map[i][j]*=2;
							this.map[i][j+1] = 0;
						}
					}
				}
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=1;j<=n-1;j++) {
						if(this.map[i][j]!=0 && j!=0) {
							y_pivot = j;
							while(true) {
								if(y_pivot==0) break;
								if(this.map[i][y_pivot-1]==0) {
									this.map[i][y_pivot-1] = this.map[i][y_pivot];
									this.map[i][y_pivot] = 0;
								}
								y_pivot--;
							}
						}
					}
				}
			}
			else if(dir==2) {	// east
				int y_pivot;
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=n-2;j>=0;j--) {
						if(this.map[j][i]!=0 && j!=n-1) {
							y_pivot = j;
							while(true) {
								if(y_pivot==n-1) break;
								if(this.map[y_pivot+1][i]==0) {
									this.map[y_pivot+1][i] = this.map[y_pivot][i];
									this.map[y_pivot][i] = 0;
								}
								y_pivot++;
							}
						}
					}
				}
				for(int i=0;i<n;i++) {	//	merge
					for(int j=n-1;j>0;j--) {
						if(this.map[j][i]==this.map[j-1][i]) {	// dir same num merge
							this.map[j][i]*=2;
							this.map[j-1][i] = 0;
						}
					}
				}
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=n-2;j>=0;j--) {
						if(this.map[j][i]!=0 && j!=n-1) {
							y_pivot = j;
							while(true) {
								if(y_pivot==n-1) break;
								if(this.map[y_pivot+1][i]==0) {
									this.map[y_pivot+1][i] = this.map[y_pivot][i];
									this.map[y_pivot][i] = 0;
								}
								y_pivot++;
							}
						}
					}
				}
			}
			else if(dir==3) {	// north
				int y_pivot;
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=1;j<=n-1;j++) {
						if(this.map[j][i]!=0 && j!=0) {
							y_pivot = j;
							while(true) {
								if(y_pivot==0) break;
								if(this.map[y_pivot-1][i]==0) {
									this.map[y_pivot-1][i] = this.map[y_pivot][i];
									this.map[y_pivot][i] = 0;
								}
								y_pivot--;
							}
						}
					}
				}
				for(int i=0;i<n;i++) {	//	merge
					for(int j=0;j<n-1;j++) {
						if(this.map[j][i]==this.map[j+1][i]) {	// dir same num merge
							this.map[j][i]*=2;
							this.map[j+1][i] = 0;
						}
					}
				}
				for(int i=0;i<n;i++) {	//	push to dir
					for(int j=1;j<=n-1;j++) {
						if(this.map[j][i]!=0 && j!=0) {
							y_pivot = j;
							while(true) {
								if(y_pivot==0) break;
								if(this.map[y_pivot-1][i]==0) {
									this.map[y_pivot-1][i] = this.map[y_pivot][i];
									this.map[y_pivot][i] = 0;
								}
								y_pivot--;
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		Map n_map = new Map(scn);
		Map tmp_map = new Map();
		Map tmp_map2 = new Map();
		Map tmp_map3 = new Map();
		Map tmp_map4 = new Map();
		Map tmp_map5 = new Map();
		int max_num=0;
		for(int i=0;i<4;i++) {
			for(int b=0;b<n;b++) {
				System.arraycopy(n_map.map[b],0, tmp_map.map[b], 0, n);
			}
			tmp_map.slide(i);
			for(int j=0;j<4;j++) {
				for(int b=0;b<n;b++) {
					System.arraycopy(tmp_map.map[b],0, tmp_map2.map[b], 0, n);
				}
				tmp_map2.slide(j);
				for(int k=0;k<4;k++) {
					for(int b=0;b<n;b++) {
						System.arraycopy(tmp_map2.map[b],0, tmp_map3.map[b], 0, n);
					}
					tmp_map3.slide(k);
					for(int l=0;l<4;l++) {
						for(int b=0;b<n;b++) {
							System.arraycopy(tmp_map3.map[b],0, tmp_map4.map[b], 0, n);
						}
						tmp_map4.slide(l);
						for(int m=0;m<4;m++) {
							for(int b=0;b<n;b++) {
								System.arraycopy(tmp_map4.map[b],0, tmp_map5.map[b], 0, n);
							}
							tmp_map5.slide(m);
							//tmp_map5.print();
							//System.out.println(i + ", " + j + ", " + k + ", " + l + ", " + m );
							if(max_num<tmp_map5.max_num()) {
								max_num = tmp_map5.max_num();
								//System.out.println(i + ", " + j + ", " + k + ", " + l + ", " + m + ", max_num: " + max_num);
							}
						}
					}
				}
			}
		}
		System.out.println(max_num);
		scn.close();
	}
}