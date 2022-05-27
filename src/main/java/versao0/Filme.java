package versao0;

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
	
}