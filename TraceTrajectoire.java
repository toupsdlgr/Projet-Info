
public class TraceTrajectoire{
	public static void main(String[] args) {
		Test test = new Test();
		double[][][] trajectoire = test.defaultTest();
		Graphicfenetre fenetre = new Graphicfenetre();
		for (int t = 0 ; t < 50 ; t++) {
			fenetre.setContentPane(new Graphic(trajectoire[t][0][Ø],trajectoire[t][0][1]);
		
		}
	}

}
