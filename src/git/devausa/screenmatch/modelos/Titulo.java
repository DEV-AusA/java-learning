package git.devausa.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;
import git.devausa.screenmatch.excepcion.ErrorConversionDeDuracionException;

public class Titulo implements Comparable<Titulo> {
    // modificadores de acceso: Existen cuatro tipos de modificadores de acceso en Java:
    // public, protected, private y default (también conocido como package-private).

    //Anotaciones
//    @SerializedName("Title")
    private String nombre;
//    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private String director;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int cantidadDeEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    //creo el constructor que reciba un tituloOmdb
    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();

        //CUSTOM EXCEPTION
        //despues de declararlo hay que crearlo
        if (miTituloOmdb.release_date() == null){
            throw new ErrorConversionDeDuracionException("No se puede convertir la duracion porque es 'null'");
        }

        this.director = miTituloOmdb.director();

        //convierto el string a int con Integer.valueOf  + obtener solo los 3 primeros numeros del string
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.release_date()
                .substring(0, 4)
                .replace(" ", ""));
    }

    // encapsulamiento
    public int getCantidadDeEvaluaciones(){
        return cantidadDeEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDirector() {
        return director;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void muestraFichaTecnica(){
        System.out.println("Nombre de la pelicula: " + nombre);
        System.out.println("Director: " + getDirector());
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Duracion: " + getDuracionEnMinutos() + " minutos");
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        cantidadDeEvaluaciones++;
    }

    public double promedioEvaluaciones(){
        return sumaDeLasEvaluaciones/cantidadDeEvaluaciones;
    }

    // implemento y reescribo el method comparable
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(Nombre=" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", director=" + director + ")";
    }
}

