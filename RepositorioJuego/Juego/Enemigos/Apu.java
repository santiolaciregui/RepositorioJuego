package Enemigos;

import javax.swing.ImageIcon;

import Clases.Enemigo;

public class Apu extends Enemigo {

	public Apu(int x, int y) {
		super(x,y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ApuParado.png")));
		label.setBounds(x, y,117 , 110);
	}
	
	public void atacar() {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ApuAtacaGif.gif")));
	}
	
	public void parar() {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ApuParado.png")));
	}

	@Override
	public Enemigo clonar() {
		// TODO Auto-generated method stub
		return null;
	}

}
