import java.awt.Dimension; 
import javax.swing.JFrame;
 
public class Graphicfenetre extends JFrame{
	int n = 3;
	
	double[] posX = {300,400,200};
	double[] posY = {400,400,400};
	private Graphic pan = new Graphic(posX,posY);
	
	public Graphicfenetre(){        
		this.setTitle("Animation");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		go();
  }

  private void go(){
	  Test test = new Test();
	  double[][][] trajectoire = test.defaultTest();
	  for(int t = 0; t < 20000; t++){
		  for (int i = 0; i<n; i++) {
			 pan.setPosX((int) trajectoire[t][i][0], i);
			 pan.setPosY((int) trajectoire[t][i][1], i);
			 pan.repaint();
			 try {
			     Thread.sleep(1);
			 } catch (InterruptedException e) {
			        e.printStackTrace();
			 }
			 
		  }
	  }
  }
  
  public static void main(String[] args) {
	  Graphicfenetre fenetre = new Graphicfenetre();
  }
  
}