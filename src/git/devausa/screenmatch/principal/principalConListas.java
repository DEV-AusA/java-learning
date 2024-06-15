package git.devausa.screenmatch.principal;

import git.devausa.screenmatch.modelos.Pelicula;
import git.devausa.screenmatch.modelos.Serie;
import git.devausa.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class principalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Avengers", 2019);
        //colocando su clasificacion
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Spiderman", 1998);
        otraPelicula.evalua(10);
        Serie casaDragon = new Serie("La casa del dragon", 2022);
        casaDragon.evalua(6);
        var peliculaDeCesar = new Pelicula("Interstellar", 2014);
        peliculaDeCesar.evalua(9);

        //creo un array de tipo Titulo ya que es la Clase padre de Pelicula y Serie
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeCesar);
        lista.add(casaDragon);

        // for each (tipoClase NOMBRE: Array)
        for (Titulo item: lista){
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Robert Downey Jr");
        listaDeArtistas.add("Nicolas Cage");
        listaDeArtistas.add("Alex Sintec");
        listaDeArtistas.add("Penelope Cruz");

        System.out.println("Lista de artistas desordenada: " + listaDeArtistas);

        Collections.sort(listaDeArtistas);

        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        //ordenando la lista de peliculas
        //tengo que implementar en la clase Titulo la clase Comparable "implements Comparable<Titulo>"
        // luego implementar su method en esa misma clase
        Collections.sort(lista);

        System.out.println("Lista de titulos ordenados: " + lista);

        // ordenando por año de lanzamiento
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));

        System.out.println("Lista de titulos ordenados por fecha de lanzamiento: " + lista);

    }



}
