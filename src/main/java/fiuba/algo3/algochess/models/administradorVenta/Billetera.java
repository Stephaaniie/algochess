package fiuba.algo3.algochess.models.administradorVenta;

import fiuba.algo3.algochess.models.excepciones.PuntosInsuficientesException;

public class Billetera {
    private int puntos;

    public Billetera(int montoInicial) {
        puntos = Math.max(montoInicial, 0);
    }

    public int getPuntos() {
        return puntos;
    }

    private boolean noPuedePagar(int monto) {
        return puntos < monto;
    }

    public void pagar(int monto) {
        if (noPuedePagar(monto))
            throw new PuntosInsuficientesException();
        this.puntos -= monto;
    }
}
