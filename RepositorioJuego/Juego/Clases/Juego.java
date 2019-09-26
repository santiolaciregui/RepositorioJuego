package Clases;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import GUI.*;
import Mapas.Mapa;
import Mapas.Mapa1;

public class Juego {
	private LinkedList<GameObject> entidades, entidadesAeliminar;
	private GUI gui;
	private int puntaje = 0;
	private int kills = 0;
	private Mapa mapa;
	
	public Juego(GUI gui) {
		this.mapa=new Mapa1(this);
		this.gui=gui;
		entidades= new LinkedList<GameObject>();
		entidadesAeliminar = new LinkedList<GameObject>();
		iniciarEntidades();
	}
	
	
	public void iniciarEntidades() {
		entidades= this.mapa.crearEntidades();
		entidadesAeliminar= new LinkedList<GameObject>();
		for(GameObject e: entidades) {
			e.setJuego(this);
			agregarEntidad(e);
		}
	}
	public void agregarEntidad(GameObject nuevo) {
		if(!hayColisiones(nuevo) && !fueraDeGrilla(nuevo)) {
			ubicacionDefinitiva(nuevo);
			gui.agregarObject(nuevo);
			entidades.addLast(nuevo);
			entidadesAeliminar.addLast(nuevo);
//			System.out.println(nuevo.getBounds().getX()+50 +"       " + nuevo.getBounds().getY());
		}
	}
	
	private void ubicacionDefinitiva(GameObject nuevo) {
		int pos= (int) nuevo.getBounds().getY();
		Rectangle aux= nuevo.getBounds();
		if(pos>=85 && pos<115) {
			nuevo.setBounds(aux.x, 105, aux.width, aux.height);
			System.out.println("jahahha");
		}
		else
			if(pos>=117 && pos<=146)
				nuevo.setBounds(aux.x, 136, aux.width, aux.height);
			else
				if(pos>150 && pos<182)
					nuevo.setBounds(aux.x, 172, aux.width, aux.height);
				else
					if(pos>=182 && pos<=215)
						nuevo.setBounds(aux.x, 205, aux.width, aux.height);
					else
						if(pos>218 && pos<245)
							nuevo.setBounds(aux.x, 235, aux.width, aux.height);
						else
							if(pos>=248 && pos<=278)
								nuevo.setBounds(aux.x, 271, aux.width, aux.height);
							else
								if(pos>281 && pos<306)
									nuevo.setBounds(aux.x, 300, aux.width, aux.height);
	}
	
	public void eliminarEntidad() {
		GameObject aEliminar = entidadesAeliminar.isEmpty()? null: entidadesAeliminar.getFirst();
		if(aEliminar != null) {
			puntaje += aEliminar.puntosDeMuerte;
			entidadesAeliminar.remove();
			gui.eliminarEnemigo(aEliminar);
		}
	}
	
	private boolean fueraDeGrilla(GameObject elem) {
		return elem.getBounds().y< 85;
	}
	
	private int buscarEntidad(GameObject elem) {
		int index=0;
		Iterator<GameObject> it = entidades.iterator();
		GameObject aux= it.hasNext()? it.next() : null;
		while(aux!=null && aux!=elem) {
			index++;
			aux= it.next();
		}
		return index;
	}
	
	
	public boolean hayColisiones(GameObject nuevo) {
		boolean hayColision=false;
		Iterator<GameObject> it=entidades.iterator();
		while(it.hasNext() && !hayColision) {
			GameObject aux=it.next();
			if(verificarColision(aux,nuevo))
				hayColision=true;
		}
		return hayColision;
	}
	
	private boolean verificarColision(GameObject aux,GameObject nuevo) {
		Rectangle r1= aux.getBounds();r1.height=40;r1.width=70;
		Rectangle r2= nuevo.getBounds(); r2.height=40; r2.width=70;
		return r1.intersects(r2);
			
	}
	
	public void aumentarPuntaje(int p) {
		puntaje=p;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void verificarMapa() {
		if(entidades.size()==0) {
			mapa.mapaSiguiente();
		}
	}
	
}