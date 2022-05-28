package versaofinal;

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
	
	public double getValor() {
		return filme.getValor(diasLocados);
	}

	int getPontosFidelidade() {
		int pontosFidelidade = 1;
		if ((getFilme().getCodigoDePreco() == Filme.LANCAMENTO)
				&& getDiasLocados() > 1)
			pontosFidelidade++;
		return pontosFidelidade;
	}
	
}