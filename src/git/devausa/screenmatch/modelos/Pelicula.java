package git.devausa.screenmatch.modelos;

import git.devausa.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

    // constructor super que recibe 2 argumentos de la clase Peliculas
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        // obtener la media de la clasificacion
        // parseo de double a int
        return (int) (promedioEvaluaciones() / 2);
    }

    @Override
    public String toString() {
        return "Pelicula " + this.getNombre() + " (" + getFechaDeLanzamiento() + ") ";
    }
}