package git.devausa.screenmatch.modelos;

import git.devausa.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

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
}