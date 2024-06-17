package git.devausa.screenmatch.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetDataApi {

    private String tituloABuscar;

    public void setTituloABuscar(String tituloABuscar) {
        this.tituloABuscar = tituloABuscar;
    }

    public String getTituloABuscar() throws IOException, InterruptedException {

        //averiguar el uso de la clase URLEncoder para corregir los espacios en blanco de la URL
        String direction = "https://swapi.dev/api/films/" + tituloABuscar;

        //instancias para hacer la peticion
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direction))
                .build();
        HttpResponse<String> response = client
                // agregando la excepciones para que Java maneje los errores
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
