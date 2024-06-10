package git.devausa.screenmatch.calculos;

import git.devausa.screenmatch.modelos.Pelicula;
import git.devausa.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    // Polimorfismo 1 Pelicula es un titulo, 1 Serie tambien es un titulo, osea referirse a la misma cosa pero de diferente manera
    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }
}
