package fiuba.algo3.AlgoChess.juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import fiuba.algo3.AlgoChess.teclado.Teclado;

public class Juego extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private static final int ANCHO = 800;
	
	private static final int ALTO  = 800;
	
	private static volatile boolean jugando = false;
	
	private static final String NOMBRE = "ALGOCHESS";
	
	private static JFrame ventana = new JFrame(NOMBRE);
	
	private static Teclado teclado = new Teclado();
	
	private static Thread subProceso;
	
	private Juego() {
		
		setPreferredSize(new Dimension(ANCHO, ALTO));
		
		addKeyListener(teclado);
				
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		ventana.setResizable(false);
		
		ventana.setLayout(new BorderLayout());
		
		ventana.add(this,BorderLayout.CENTER);
		
		ventana.pack();
		
		ventana.setLocationRelativeTo(null);
		
		ventana.setVisible(true);
	}
	
	public static void main(String[]args) {
		
		Juego juego = new Juego();
		
		juego.iniciar();
	}
	
	private synchronized void iniciar() {
		
		jugando = true;
		
		subProceso = new Thread(this, "Graficos");
		
		subProceso.start();
	}
	
	private synchronized void detener() {
		
		jugando = false;
		
		try {
			
			subProceso.join();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	private void actualizar() {
		
		teclado.actualizar();
	}
	
	@Override
	public void run() {
		
		requestFocus();
		
		while(jugando) {
			
		}
	}
	
}
