package Armas;

import java.awt.Point;

import javax.swing.ImageIcon;

import Disparos.*;

public class ArmaMoe extends Arma{

	@Override
	public Disparo crearDisparo(Point pos) {
		DisparoEnemigo disparo= new DisparoEnemigo(800, pos.x, pos.y+50);
		disparo.getLabel().setIcon(new ImageIcon(getClass().getResource("/Imagenes/FuegoInvertidoGif.gif")));
		disparo.getLabel().setBounds(disparo.getPos().x, disparo.getPos().y, 15, 15);
		return disparo;
	}

}