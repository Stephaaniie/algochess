package fiuba.algo3.Vista.Ventana;

import java.util.ArrayList;

public class Observable {
	
	private ArrayList<Observer> observers;
	
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}
	
	public void notificarObservers() {
		observers.stream().forEach(x -> x.change());
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
}
