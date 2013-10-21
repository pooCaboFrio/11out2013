/**
 *
 * @author moraes
 */
public class Filmes {
	/*
	 * TODO usar OU genero OU categoria
	 * pode ter mais de um genero, basta separar por vírgula
	 * só pode ter uma categoria
	*/
	private String nome,genero;
	private int categoria; //0 = ação, 1 = comédia, 2 = terror, 3 = romance		

	//TODO escolher apenas um construtor posteriormente
	Filmes(String nome,String genero){
		this.nome = nome;
		this.genero = genero;
	}
	Filmes(String nome, int categoria){
		this.nome = nome;
		this.categoria = categoria;
	}
	public String getGenero(){
		return genero;
	}
	public void setGenero(String genero){
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
}
