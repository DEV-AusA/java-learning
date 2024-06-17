package git.devausa.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import git.devausa.screenmatch.api.GetDataApi;
import git.devausa.screenmatch.excepcion.ErrorConversionDeDuracionException;
import git.devausa.screenmatch.modelos.Titulo;
import git.devausa.screenmatch.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner nombre = new Scanner(System.in);

        List<Titulo> titulos = new ArrayList<>();

        //uso el GsonBuilder
        //entonces tiene que hacer el parse a minuscula
        Gson gson = new GsonBuilder()
                // con esto le digo a Java que que los datos del Json vienen con la primera letra en mayuscula
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                //con esto ESTRUCTURO MEJOR EL JSON CREADO
                .setPrettyPrinting()
                .create();

        while (true) {

            System.out.println("Ingrese el numero de la pelicula a buscar:");
            var busqueda = nombre.nextLine();

            //metodo equalsIgnoreCase ignora y convierte todo a minusculas
            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            GetDataApi direction = new GetDataApi();
            direction.setTituloABuscar(busqueda);
            String dataApi = direction.getTituloABuscar();

            try {

                System.out.println(dataApi);

                // methods fromJson or toJson
                TituloOmdb miTituloOmdb = gson.fromJson(dataApi, TituloOmdb.class);
                // como muestra null hay que serializar el nombre de las propiedades del Json a los nombre de los parametros de la clase Titulo
                System.out.println("Titulo convertido de Json: " + miTituloOmdb);

                // al enviarle miTituloOmdb solo, tira error xq la clase necesita 2 parametros, entonces creo un constructor en Titulo para eso
                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo " + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException exception) {
                System.out.println("Error en el formato Number to String : ");
                System.out.println(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                System.out.println("Error en la URI, verifique la direccion.");
                System.out.println(exception.getMessage());

            } catch (ErrorConversionDeDuracionException exception) {
                //uso mi CUSTOM EXCEPTION
                System.out.println(exception.getMessage());
            }
        }
        //sout del array creado con los titulos cargados
        System.out.println(titulos);

        //CREANDO UN ARCHIVO CON LOS DATOS DEL ARRAY
        //crea el Json con TODOS los atributos de la clase Titulo
        // open SIEMPRE RECORDAR cerrar
        FileWriter escritura = new FileWriter("titulos.json");
        // convertimos el array en JSON con Gson
        escritura.write(gson.toJson(titulos));
        //close
        escritura.close();

        System.out.println("Finalizo la ejecucion del programa!");
    }
}
