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
		String resultado = "Registro de locação para " + getNome() + "\n";
		for (Locacao locacao : locacoes) {
			resultado += "\t" + locacao.getFilme().getTitulo() + "\t"
					+ String.valueOf(locacao.getValor()) + "\n";
		}
		// adiciona linhas de rodapé
		resultado += "Valor devido: " + String.valueOf(getValorTotal()) + "\n";
		resultado += "Você ganhou " + String.valueOf(getPontosFidelidade())
				+ " pontos de fidelidade";
		return resultado;
	}

	private double getValorTotal() {
		double valorTotal = 0.0;
		for (Locacao locacao : locacoes) {
			valorTotal += locacao.getValor();
		}
		return valorTotal;
	}
	
	private int getPontosFidelidade() {
		int pontosFidelidade = 0;
		for (Locacao locacao : locacoes) {
			pontosFidelidade += locacao.getPontosFidelidade();
		}
		return pontosFidelidade;
	}
	
	
	
}