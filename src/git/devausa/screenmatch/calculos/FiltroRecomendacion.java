package git.devausa.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtro(Clasificacion clasificacion){
        // obtengo la cantidad de estrellas
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Muy buen evaluado en el momento");
        }
        else if (clasificacion.getClasificacion() >= 2){
            System.out.println("Popular en el momento");
        }
        else {
            System.out.println("Agregalo en tu lista para mirarlo despues.");
        }

    }
}
