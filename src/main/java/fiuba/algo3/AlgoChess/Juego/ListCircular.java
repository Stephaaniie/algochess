package fiuba.algo3.AlgoChess.Juego;
import java.util.ArrayList;

public class ListCircular<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;
	public E getElementos(int index) {
	  return super.get(index % size());
	}
	
}
