package fiuba.algo3.algochess.models.entidades;

import java.util.ArrayList;

public class Observable {

    private ArrayList<Observer> observers;

    public Observable() { 
        observers = new ArrayList<Observer>(); 
    }

    public void addObserver(Observer observer) { 
        observers.add(observer); 
    }

    public void notifyObservers() { 
        observers.stream().forEach(observer -> observer.change()); 
    }
}