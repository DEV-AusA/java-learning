package git.devausa.screenmatch.modelos;

public class Titulo implements Comparable<Titulo> {
    // modificadores de acceso: Existen cuatro tipos de modificadores de acceso en Java:
    // public, protected, private y default (también conocido como package-private).
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int cantidadDeEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    // encapsulamiento
    public int getCantidadDeEvaluaciones(){
        return cantidadDeEvaluaciones;
    }

    public String getNombre() {
        return nombre;
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
}

