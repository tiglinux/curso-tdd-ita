package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import classes.MockArmazenamento;
import classes.Placar;

public class PlacarTest {
	
	Placar placar;
	MockArmazenamento mock;
	

	@Before
	public void setUP() throws IOException{
		mock = new MockArmazenamento();
		placar = new Placar(mock);
		
	}
	
	@Test
	public void testRegistrar1TipoDePonto(){
		placar.registrarPonto("Felipe","estrela", 10);
		
		assertEquals("Felipe possui 10 pontos do tipo estrela", placar.retornarPonto("Felipe"));
	}
	
	@Test
	public void testRegistrar2TipoDePonto(){
		placar.registrarPonto("Felipe", "estrela", 50);
		placar.registrarPonto("Felipe", "moeda", 30);
		
		assertEquals("Felipe possui 30 pontos do tipo moeda e 50 pontos do tipo estrela"
					, placar.retornarPonto("Felipe"));
	}
	
	@Test
	public void testRegistrar1Ponto2Usuarios(){
		placar.registrarPonto("Felipe", "estrela", 67);
		placar.registrarPonto("Jonas", "estrela", 89);
		
		assertEquals("Felipe possui 67 pontos do tipo estrela", placar.retornarPonto("Felipe"));
		assertEquals("Jonas possui 89 pontos do tipo estrela", placar.retornarPonto("Jonas"));
	}
	
	@Test
	public void testRetornarPontos(){
		placar.registrarPonto("Felipe", "estrela", 44);
		placar.registrarPonto("Jonas", "moeda", 67);
		placar.registrarPonto("Jonas", "estrela", 55);
		
		assertEquals("Jonas possui 67 pontos do tipo moeda e 55 pontos do tipo estrela"
				, placar.retornarPonto("Jonas"));
		assertEquals("Felipe possui 44 pontos do tipo estrela", placar.retornarPonto("Felipe"));
	}
	
	@Test
	public void testRetornarRank(){
		placar.registrarPonto("Felipe", "estrela", 44);
		placar.registrarPonto("Jonas", "moeda", 67);
		placar.registrarPonto("Jonas", "estrela", 55);
		
		assertEquals("Jonas com 55, Felipe com 44", placar.retornarRankPonto("estrela"));
		
	}

}