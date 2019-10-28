package GUI;
import javax.swing.*;
import Clases.GameObject;
import Clases.Juego;
import Enemigos.Flanders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Botones.ColeccionBotones;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	public static String titulo = "Los Simpsons";
	public static Dimension size = new Dimension(1250, 860);
	private JPanel panelAbajo, panelGrilla, panelArriba, contentPane;
	private Juego juego;
	protected GameObject proximoAagregar, proximoAeliminar;
	@SuppressWarnings("unused")
	private ColeccionBotones botones;
	private JLabel etiquetaPuntaje, etiquetaVida, etiquetaMonedas;
	private boolean lock = false;
	private HiloTiempo tiempo;
	private int direction = -1;
	
	public GUI() {
		iniciarContentPane();
		iniciarPanelArriba();
		iniciarPanelGrilla();
		iniciarPanelAbajo();
		
		//ETIQUETA VIDA
		etiquetaVida= new JLabel("VIDA: ");
		etiquetaVida.setForeground(Color.BLACK);
		etiquetaVida.setFont(new Font("Font.PLAIN", 3, 24));
		panelArriba.add(etiquetaVida);
		//ETIQUETA MONEDAS
		etiquetaMonedas = new JLabel("MONEDAS: ");
		etiquetaMonedas.setForeground(Color.BLACK);
		etiquetaMonedas.setFont(new Font("Font.PLAIN", 3, 18));
		panelArriba.add(etiquetaMonedas);
		//ETIQUETA PUNTAJE
		etiquetaPuntaje = new JLabel("PUNTAJE:");
		etiquetaPuntaje.setForeground(Color.WHITE);
		etiquetaPuntaje.setFont(new Font("Font.PLAIN", 3, 18));
		panelAbajo.add(etiquetaPuntaje);
		
		
		juego=new Juego(this);
		
		iniciarBotones();
		
		tiempo = new HiloTiempo(juego);
		tiempo.start();
		setVisible(true);
		setTitle(titulo);
		setSize(size);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void iniciarContentPane() {
		contentPane = new JPanel();
		contentPane.setSize(size);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		this.setContentPane(contentPane);
	}
	
	private void iniciarPanelArriba() {
		panelArriba = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/PanelArribaoriginal.png")).getImage());
		panelArriba.setLayout(new FlowLayout());
		contentPane.add(panelArriba);
	}
	
	private void iniciarPanelAbajo() {
		panelAbajo = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/PanelAbajo.png")).getImage());
		panelAbajo.setLayout(new FlowLayout());
		contentPane.add(panelAbajo);
	}
	
	private void iniciarPanelGrilla() {
		panelGrilla = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/FondoConGrillaoriginal.png")).getImage());
		panelGrilla.setLayout(null);
		contentPane.add(panelGrilla);
		panelGrilla.addMouseListener(new oyenteAgregarEntidad());
	}
		
	public void iniciarBotones() {
		botones= new ColeccionBotones(panelAbajo, juego.getTienda());		
		repaint();
	}
	
	public JPanel panel() {
		return panelGrilla;
	}
		
	public void agregarObject(JLabel nuevo) {
		panelGrilla.add(nuevo);
		nuevo.setLocation(nuevo.getBounds().getLocation());
		repaint();
	}
	public void eliminarEnemigo(GameObject aEliminar) {
		panelGrilla.remove(aEliminar.getLabel());
		repaint();
	}
	
	public void cartelMonedasInsuficientes() {
		JOptionPane.showMessageDialog(null,"Monedas insuficientes","aver tontito rescatate",JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean getLock(){
		return this.lock;
	}
	
	public void toggleLock(){
		this.lock = !this.lock;
	}
	
	public int getDirection(){
		return this.direction;
	}
	
	
	private class oyenteAgregarEntidad implements MouseListener{
		public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				juego.agregarEntidad(x,y);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	
	
	public static void main (String [] args) {
		new GUI();
	}

	public void actualizarPuntajes() {
		etiquetaPuntaje.setText("PUNTAJE: "+juego.getPuntaje()+" ");		
	}
	
	public void actualizarVidas() {
		etiquetaVida.setText(""+juego.getVida());
		etiquetaVida.setLocation(410, 13);
	}
	public void actualizarMonedas() {
		etiquetaMonedas.setText("MONEDAS: "+juego.getMonedas()+" ");
		etiquetaMonedas.setLocation(740, 17);
	}
	

}
