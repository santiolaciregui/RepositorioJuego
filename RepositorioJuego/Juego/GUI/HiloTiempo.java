package GUI;

import Clases.Juego;

public class HiloTiempo extends Thread{
	private Juego juego;
	private volatile boolean hayJuego;
	
	public HiloTiempo(Juego j) {
		juego=j;
		hayJuego=true;
	}
	
	public void run() {
		while(hayJuego){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.agregarEntidades();
			
			juego.accionar();
			juego.colisionar();
			juego.verificarMapa();
			juego.eliminarEntidades();
		}
	}
	public void finalizar() {
		hayJuego=false;
	}
}