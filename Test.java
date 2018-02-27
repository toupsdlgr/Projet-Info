import javax.swing.JWindow;

public class Test {
	public double[][][] defaultTest(){
		int n = 3;
		double[] masse = {0.1,10,0.4};
		double[] positionun = {300,400};
		double[] positiondeux = {400,400};
		double[] positiontrois = {200,400};
		double[][] position = {positionun,positiondeux,positiontrois};
		double[] vitesseun = {0,29};
		double[] vitessedeux = {0,-1};
		double[] vitessetrois = {0,38};
		double[][] vitesse = {vitesseun,vitessedeux,vitessetrois};
		double[][] position2 = new double[n][2];
		double[][] vitesse2 = new double[n][2];
		double[][] acceleration = new double[n][2];
		double[][]acceleration2 = new double[n][2];
		double g = 10;
		double delta = 0.01;
		int tempstotal = 20000;
		Thread[][] tableau = new Thread[n][n];
		double[][][] trajectoire = new double[tempstotal][n][2];
		
		for (int t = 0; t < tempstotal; t++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i!=j) {
						Cinematic c = new Cinematic(n,masse,position,position2,vitesse,vitesse2, acceleration, acceleration2,i,j,delta,g);
						tableau[i][j] = new Thread(new Calcul(j,i,c));
						tableau[i][j].start();
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i!=j) {
						try {
							tableau[i][j].join();
						
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
				}
			}
			for (int i = 0; i<n;i++) {
				for (int j = 0; j<2;j++) {
					position[i][j] = position2[i][j];
				}
			}
			for (int i = 0; i<n;i++) {
				for (int j = 0; j<2;j++) {
					vitesse[i][j] = vitesse2[i][j];
				}
			}
			for (int i = 0; i<n;i++) {
				for (int j = 0; j<2;j++) {
					acceleration[i][j] = acceleration2[i][j];
				}
			}
			for (int i = 0; i<n;i++) {
				for (int j = 0; j<2;j++) {
					acceleration2[i][j] = 0;
				}
			}
			
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<2; j++) {
					trajectoire[t][i][j] = position[i][j];
				}
			}
			
		}
		return trajectoire;
	}
	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		test.defaultTest();
	}
}
