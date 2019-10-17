package Enemigos;

import javax.swing.ImageIcon;

import Clases.Enemigo;

public class Burns extends Enemigo {

	public Burns(int x, int y) {
		super(x, y);
		dano=800;
		vida=2000;
		monedas=1000;
		puntosDeMuerte=2000;
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BurnsParado.png")));
		label.setBounds(x, y,117 , 110);
	}
	
	public void atacarGrafico() {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BurnsAtacaGif.gif")));
	}
	
	public void pararGrafico() {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BurnsParado.png")));
	
}

	@Override
	public Enemigo clonar() {
		// TODO Auto-generated method stub
		return null;
	}
}
