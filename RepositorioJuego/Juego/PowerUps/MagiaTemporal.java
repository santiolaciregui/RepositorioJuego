package PowerUps;

import javax.swing.ImageIcon;
import Clases.GameObject;

public class MagiaTemporal extends PowerUp {	
	protected int duracion;
	
	public MagiaTemporal(int x, int y) {
		super(x,y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/PremioKrusty.gif")));
		label.setBounds(x, y+40, 75, 60);
	}

	@Override
	public void atacar(GameObject e) {	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
	}


	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void realizarAccion(GameObject aliado) {
		// TODO Auto-generated method stub
		
	}

}