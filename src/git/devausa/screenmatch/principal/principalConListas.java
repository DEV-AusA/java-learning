package git.devausa.screenmatch.principal;

import git.devausa.screenmatch.modelos.Pelicula;
import git.devausa.screenmatch.modelos.Serie;
import git.devausa.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class principalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Avengers", 2019);
        Serie casaDragon = new Serie("La casa del dragon", 2022);
        Pelicula otraPelicula = new Pelicula("Spiderman", 1998);
        var peliculaDeCesar = new Pelicula("Interstellar", 2014);

        //creo un array de tipo Titulo ya que es la Clase padre de Pelicula y Serie
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeCesar);
        lista.add(casaDragon);

        // (tipo clase NOMBRE: Array)
        for (Titulo item: lista){
            System.out.println(item);
        }

    }



}
