

class Calcul implements Runnable{
	int j;
	int i;
	Cinematic c;
	
	public Calcul(int j,int i, Cinematic c) {
		this.j=j;
		this.i=i;
		this.c=c;
	}
	public void Test() throws InterruptedException{
		c.calculaccel();
		if (j==0 || i==0 && j==1) {
			c.calculposition();
			c.calculvitesse();
		}
		
	}
	
	@Override
	public void run() {
		try {
			Test();
		} catch (InterruptedException e) {};
		// TODO Auto-generated method stub
		
	}
}
