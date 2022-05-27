package versao0;

public class Locacao {
	
	private Filme filme;

	private int diasLocados;

	public Locacao(Filme filme, int diasLocados) {
		this.filme = filme;
		this.diasLocados = diasLocados;
	}

	public int getDiasLocados() {
		return diasLocados;
	}

	public Filme getFilme() {
		return filme;
	}
	
}