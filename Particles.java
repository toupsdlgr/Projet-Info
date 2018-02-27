
public class Particles {
	int n;
	double[] masse;
	double[][] vitesse;
	double[][] vitesse2;
	double[][] position;
	double[][] position2;
	double[][] acceleration;
	double[][] acceleration2;
	
	public Particles (int n, double[] masse, double[][] position, double[][] position2, double[][] vitesse, double[][] vitesse2, double[][] acceleration, double[][] acceleration2){
		this.n = n; 
		this.masse = masse;
		this.vitesse = vitesse;
		this.position = position;
		this.acceleration = acceleration;
		this.position2 = position2;
		this.vitesse2 = vitesse2;
		this.acceleration2 = acceleration2;
	}
}
