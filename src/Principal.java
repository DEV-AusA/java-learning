import git.devausa.screenmatch.calculos.CalculadoraDeTiempo;
import git.devausa.screenmatch.modelos.Pelicula;
import git.devausa.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        // instancio nueva clase de git.devausa.screenmatch.modelos.Pelicula
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Avengers");
        miPelicula.setFechaDeLanzamiento(2019);
        miPelicula.setDuracionEnMinutos(150);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();

        miPelicula.evalua(7.8);
        miPelicula.evalua(10);
        System.out.println(miPelicula.getCantidadDeEvaluaciones());
        System.out.println(miPelicula.promedioEvaluaciones());

        Serie casaDragon = new Serie();

        casaDragon.setNombre("La casa del dragon");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);

        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Spiderman");
        otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionEnMinutos(180);
        otraPelicula.setIncluidoEnElPlan(true);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver los titulos elegidos: " + calculadora.getTiempoTotal() + " minutos");

    }
}
