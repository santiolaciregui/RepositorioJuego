package Enemigos;

import javax.swing.ImageIcon;

import Clases.Enemigo;
import Clases.GameObject;

public class Apu extends Enemigo {

	public Apu(int x, int y) {
		super(x,y);
		dano=200;
		vida=1000;
		monedas=500;
		puntosDeMuerte=1000;
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ApuParado.png")));
		label.setBounds(x, y,117 , 110);
	}
	
	public void atacar(GameObject e) {
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
