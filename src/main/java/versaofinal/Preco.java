package versaofinal;

public abstract class Preco {
	public abstract int getCodigoDePreco();

	public abstract double getValor(int diasLocados); 
}


class PrecoInfantil extends Preco {
	@Override
	public int getCodigoDePreco() {
		return Filme.INFANTIL;
	}

	@Override
	public double getValor(int diasLocados) {
		double valorLocacao = 1.5;
		if (diasLocados > 3)
			valorLocacao += (diasLocados - 3) * 1.5;
		return valorLocacao;
	}
}

class PrecoLancamento extends Preco {
	@Override
	public int getCodigoDePreco() {
		return Filme.LANCAMENTO;
	}

	@Override
	public double getValor(int diasLocados) {
		return diasLocados * 3;
	}
}

class PrecoNormal extends Preco {
	@Override
	public int getCodigoDePreco() {
		return Filme.NORMAL;
	}

	@Override
	public double getValor(int diasLocados) {
		double valorLocacao = 2;
		if (diasLocados > 2)
			valorLocacao += (diasLocados - 2) * 1.5;
		return valorLocacao;
	}
	
}