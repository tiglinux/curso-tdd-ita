package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import classes.CaixaEletronico;
import classes.ContaCorrente;
import mocks.MockServicoRemoto;

public class TesteCaixaEletronico {
	CaixaEletronico caixaEletro;
	ContaCorrente cc1, cc2;
	MockServicoRemoto mockService;

	@Before
	public void inicializa() {
		mockService = new MockServicoRemoto();
		caixaEletro = new CaixaEletronico();
		cc1 = new ContaCorrente("100.000", 500);
		mockService.setConta(cc1);
		cc2 = new ContaCorrente("500.000", 150);
		mockService.setConta(cc2);

	}

	@Test
	public void testRecuperarUmaConta() {
		ContaCorrente rec;
		rec = mockService.recuperarConta("100.000");
		assertEquals(cc1, rec);
	}

	@Test
	public void testRecuperarDuasContas() {
		ContaCorrente rec;
		rec = mockService.recuperarConta("500.000");
		assertEquals(cc2, rec);

	}

	@Test
	public void testSaldoSucesso() {
		assertEquals(caixaEletro.saldo("100.000", mockService), "O saldo é R$500.0");
	}

	@Test
	public void testSaldoFalha() {
		assertEquals(caixaEletro.saldo("300.000", mockService), "Conta não encontrada");
	}

	@Test
	public void testSacarSucesso() {
		assertEquals(caixaEletro.sacar("100.000", mockService, 100), "Retire seu dinheiro");
	}

	@Test
	public void testSacarFalha() {
		assertEquals(caixaEletro.sacar("100.000", mockService, 800), "Saldo insuficiente");
	}

	@Test
	public void testDepositarSucesso() {
		assertEquals(caixaEletro.depositar("100.000", mockService, 100), "Depósito recebido com sucesso");
	}

	@Test
	public void testLoginSucesso() {
		assertEquals(caixaEletro.logar("100.000", mockService), "Usuário autenticado");
	}

	@Test
	public void testLoginFalha() {
		assertEquals(caixaEletro.logar("200.000", mockService), "Não foi possível autenticar o usuário");
	}
}