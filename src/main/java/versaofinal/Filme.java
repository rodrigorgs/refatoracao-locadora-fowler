package versaofinal;

public class Filme {
	
	public static final int INFANTIL = 2;

	public static final int NORMAL = 0;

	public static final int LANCAMENTO = 1;

	private String titulo;
	
	private Preco preco;

	public Filme(String titulo, int codigoDePreco) {
		this.titulo = titulo;
		setCodigoDePreco(codigoDePreco);
	}

	public int getCodigoDePreco() {
		return preco.getCodigoDePreco();
	}

	public void setCodigoDePreco(int codigoDePreco) {
		switch (codigoDePreco) {
		case Filme.NORMAL:
			preco = new PrecoNormal();
			break;
		case Filme.LANCAMENTO:
			preco = new PrecoLancamento();
			break;
		case Filme.INFANTIL:
			preco = new PrecoInfantil();
			break;
		default:
			throw new IllegalArgumentException("Código de preço incorreto");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public double getValor(int diasLocados) {
		return preco.getValor(diasLocados);
	}
	
}