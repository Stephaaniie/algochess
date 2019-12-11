package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Direccion.Arriba;
import fiuba.algo3.AlgoChess.Entidades.ObjetoNull;
import fiuba.algo3.AlgoChess.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class ObjetoNullTest {
	
	@Test
	public void objetoNuloNoPuedeReponerVida() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.reponerVida(20);
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	@Test
	public void objetoNuloNoPuedeDevolverElBando() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
			
		assertEquals(objetoNulo.getBando(),null);
	}
	
	@Test
	public void objetoNuloNoPuedeDevolverLaVida() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.getVida();
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	
	@Test
	public void objetoNuloNoPuedeDevolverCosto() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.getCosto();
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	@Test
	public void objetoNuloNoPuedeDevolverPosicion() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.getPosicion();
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	
	@Test
	public void objetoNuloNoPuedeAtacar() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.atacarEnemigo();
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	
	@Test
	public void objetoNuloNoPuedeRecibirDanio() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.recibirDanio(35);
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	
	@Test
	public void objetoNuloNoPuedeMoverse() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		Arriba arriba = new Arriba();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.mover(arriba);
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
	
	@Test
	public void objetoNuloNoPuedeRecibirPosicionNiBando() {
		
		ObjetoNull objetoNulo = new ObjetoNull();
		
		Posicion posicion = new Posicion(10,2);
		
		Aliado aliado = new Aliado();
		
		boolean respuesta = false;
		
		try {
			objetoNulo.recibirPosicionYBando(posicion, aliado);
		}catch(ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		assertTrue(respuesta);
	}
}
