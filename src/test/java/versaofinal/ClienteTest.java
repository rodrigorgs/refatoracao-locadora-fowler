package versaofinal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	private Cliente cliente;

	@Before
	public void setUp() {
		cliente = new Cliente("Pedro");
	}

	@Test
	public void testCriacaoDeNome() {
		String resultado = cliente.extrato();
		assertContain(resultado, "Registro de locação para Pedro");
	}

	@Test
	public void testFilmeNormalUmDia() {
		locaFilme("Indiana Jones", Filme.NORMAL, 1);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 2.0");
		assertContain(resultado, "Você ganhou 1 pontos de fidelidade");
	}

	@Test
	public void testFilmeNormalTresDias() {
		locaFilme("Indiana Jones", Filme.NORMAL, 3);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 3.5");
		assertContain(resultado, "Você ganhou 1 pontos de fidelidade");
	}

	@Test
	public void testFilmeInfantilUmDia() {
		locaFilme("Procurando Nemo", Filme.INFANTIL, 1);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 1.5");
		assertContain(resultado, "Você ganhou 1 pontos de fidelidade");
	}

	@Test
	public void testFilmeInfantilCincoDias() {
		locaFilme("Procurando Nemo", Filme.INFANTIL, 5);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 4.5");
		assertContain(resultado, "Você ganhou 1 pontos de fidelidade");
	}

	@Test
	public void testLancamentoUmDia() {
		locaFilme("Homem Aranha 2", Filme.LANCAMENTO, 1);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 3.0");
		assertContain(resultado, "Você ganhou 1 pontos de fidelidade");
	}

	@Test
	public void testLancamentoTresDias() {
		locaFilme("Homem Aranha 2", Filme.LANCAMENTO, 3);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 9.0");
		assertContain(resultado, "Você ganhou 2 pontos de fidelidade");
	}

	@Test
	public void testMuitasLocacoes() {
		locaFilme("Homem Aranha 2", Filme.LANCAMENTO, 2);
		locaFilme("Troia", Filme.LANCAMENTO, 3);
		locaFilme("Procurando Nemo", Filme.INFANTIL, 3);
		locaFilme("Indiana Jones", Filme.NORMAL, 2);
		locaFilme("Rei Leão", Filme.INFANTIL, 4);
		locaFilme("E o vento levou...", Filme.NORMAL, 3);
		String resultado = cliente.extrato();
		assertContain(resultado, "Valor devido: 25.0");
		assertContain(resultado, "Você ganhou 8 pontos de fidelidade");
	}

	private void locaFilme(String titulo, int tipo, int dias) {
		Filme filme = new Filme(titulo, tipo);
		Locacao locacao = new Locacao(filme, dias);
		cliente.addLocacao(locacao);
	}

	private void assertContain(String resultado, String conteudo) {
		assertTrue(resultado.indexOf(conteudo) >= 0);
	}

}