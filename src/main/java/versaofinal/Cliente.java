package versaofinal;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	private ArrayList<Locacao> locacoes = new ArrayList<>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public void addLocacao(Locacao locacao) {
		locacoes.add(locacao);
	}

	public String getNome() {
		return nome;
	}

	public String extrato() {
		double valorTotal = 0.0;
		int pontosFidelidade = 0;
		String resultado = "Registro de locação para " + getNome() + "\n";
		for (Locacao locacao : locacoes) {
			pontosFidelidade += calculaPontosFidelidade(locacao);
			
			// exibe valor para esta locação
			resultado += "\t" + locacao.getFilme().getTitulo() + "\t"
					+ String.valueOf(locacao.getValor()) + "\n";
			valorTotal += locacao.getValor();
		}
		// adiciona linhas de rodapé
		resultado += "Valor devido: " + String.valueOf(valorTotal) + "\n";
		resultado += "Você ganhou " + String.valueOf(pontosFidelidade)
				+ " pontos de fidelidade";
		return resultado;
	}

	private int calculaPontosFidelidade(Locacao locacao) {
		int pontosFidelidade = 1;
		if ((locacao.getFilme().getCodigoDePreco() == Filme.LANCAMENTO)
				&& locacao.getDiasLocados() > 1)
			pontosFidelidade++;
		return pontosFidelidade;
	}

	
	
}