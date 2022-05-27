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
		double valorLocacao = 0.0;
		switch (getFilme().getCodigoDePreco()) {
		case Filme.NORMAL:
			valorLocacao += 2;
			if (getDiasLocados() > 2)
				valorLocacao += (getDiasLocados() - 2) * 1.5;
			break;
		case Filme.LANCAMENTO:
			valorLocacao += getDiasLocados() * 3;
			break;
		case Filme.INFANTIL:
			valorLocacao += 1.5;
			if (getDiasLocados() > 3)
				valorLocacao += (getDiasLocados() - 3) * 1.5;
			break;
		}
		return valorLocacao;
	}
	
}