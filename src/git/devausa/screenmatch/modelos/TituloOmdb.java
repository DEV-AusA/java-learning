package git.devausa.screenmatch.modelos;
// este record funciona como un DTO, toma los valores del Json, que vienen en string, y los parsea
public record TituloOmdb(String title, String director, String release_date) {
}
