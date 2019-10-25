package Clases;

import Mapas.Mapa;

public class Tienda {
	protected Juego juego;
	protected GameObject aAgregar;

	public Tienda(Juego j) {
		juego=j;
		aAgregar=null;
	}
	
	public void aAgregar(GameObject nuevo) {
		aAgregar=null;
		if(juego.getMonedas()>= nuevo.getMonedas())
			aAgregar=nuevo;
	}

	public GameObject getCompra() {
		if(aAgregar==null)
			return null;
		return aAgregar;
	}
	
	public void reset() {
		aAgregar=null;
	}
	
	
}
