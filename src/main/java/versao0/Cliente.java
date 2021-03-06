package versao0;

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
			double valorLocacao = 0.0;
			// determina valor para cada locação
			switch (locacao.getFilme().getCodigoDePreco()) {
			case Filme.NORMAL:
				valorLocacao += 2;
				if (locacao.getDiasLocados() > 2)
					valorLocacao += (locacao.getDiasLocados() - 2) * 1.5;
				break;
			case Filme.LANCAMENTO:
				valorLocacao += locacao.getDiasLocados() * 3;
				break;
			case Filme.INFANTIL:
				valorLocacao += 1.5;
				if (locacao.getDiasLocados() > 3)
					valorLocacao += (locacao.getDiasLocados() - 3) * 1.5;
				break;
			}
			// adiciona pontos de fidelidade
			pontosFidelidade++;
			// adiciona bônus para locações de lançamentos dois dias
			if ((locacao.getFilme().getCodigoDePreco() == Filme.LANCAMENTO)
					&& locacao.getDiasLocados() > 1)
				pontosFidelidade++;
			// exibe valor para esta locação
			resultado += "\t" + locacao.getFilme().getTitulo() + "\t"
					+ String.valueOf(valorLocacao) + "\n";
			valorTotal += valorLocacao;
		}
		// adiciona linhas de rodapé
		resultado += "Valor devido: " + String.valueOf(valorTotal) + "\n";
		resultado += "Você ganhou " + String.valueOf(pontosFidelidade)
				+ " pontos de fidelidade";
		return resultado;
	}
	
}