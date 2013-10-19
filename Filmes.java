
public class Filmes {
	private String nome;
	private int categoria; //0 = ação, 1 = comédia, 2 = terror, 3 = romance
	
	Filmes(String nome, int categoria){
		this.nome = nome;
		this.categoria = categoria;
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
