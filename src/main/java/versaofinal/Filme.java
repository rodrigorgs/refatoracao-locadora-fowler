package versaofinal;

public class Filme {
	
	public static final int INFANTIL = 2;

	public static final int NORMAL = 0;

	public static final int LANCAMENTO = 1;

	private String titulo;

	private int codigoDePreco;

	public Filme(String titulo, int codigoDePreco) {
		this.titulo = titulo;
		this.codigoDePreco = codigoDePreco;
	}

	public int getCodigoDePreco() {
		return codigoDePreco;
	}

	public void setCodigoDePreco(int codigoDePreco) {
		this.codigoDePreco = codigoDePreco;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getValor(int diasLocados) {
		double valorLocacao = 0.0;
		switch (codigoDePreco) {
		case Filme.NORMAL:
			valorLocacao += 2;
			if (diasLocados > 2)
				valorLocacao += (diasLocados - 2) * 1.5;
			break;
		case Filme.LANCAMENTO:
			valorLocacao += diasLocados * 3;
			break;
		case Filme.INFANTIL:
			valorLocacao += 1.5;
			if (diasLocados > 3)
				valorLocacao += (diasLocados - 3) * 1.5;
			break;
		}
		return valorLocacao;
	}
	
}