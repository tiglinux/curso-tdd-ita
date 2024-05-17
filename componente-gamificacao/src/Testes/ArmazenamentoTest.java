package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import classes.Armazenamento;
import classes.Placar;


public class ArmazenamentoTest {

	Placar placar;
	Armazenamento arm;

	@Before
	public void setUP() {

		try {
			arm = new Armazenamento("Placar");
		} catch (IOException e) {
			System.out.println("Não foi possível criar o arquivo!");
		}
		placar = new Placar(arm);
	}
	
	@After
	public void reset(){
		File file = new File("Placar.txt");
		file.delete();
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
		placar.registrarPonto("Felipe", "estrela", 30);
		placar.registrarPonto("Jonas", "moeda", 67);
		placar.registrarPonto("Jonas", "estrela", 55);
		
		assertEquals("Jonas possui 67 pontos do tipo moeda e 55 pontos do tipo estrela"
				, placar.retornarPonto("Jonas"));
		assertEquals("Felipe possui 74 pontos do tipo estrela", placar.retornarPonto("Felipe"));
	}
	
	@Test
	public void testRetornar1PontoPorTipo(){
		placar.registrarPonto("Felipe", "estrela", 44);
		
		assertEquals("Felipe possui 44 pontos do tipo estrela", 
					placar.retornarPontoPorTipo("Felipe", "estrela") );
		
	}
	
	public void testRetornar2PontoPorTipo(){
		placar.registrarPonto("Jonas", "moeda", 67);
		placar.registrarPonto("Jonas", "estrela", 55);
		placar.registrarPonto("Jonas", "moeda", 15);
		placar.registrarPonto("Jonas", "moeda", 44);
		
		assertEquals("Jonas possui 126 pontos do tipo moeda", 
					placar.retornarPontoPorTipo("Jonas", "moeda") );
		
	}
	
	@Test
	public void testRetornarUsuarios(){
		placar.registrarPonto("Felipe", "estrela", 44);
		placar.registrarPonto("Jonas", "moeda", 67);
		placar.registrarPonto("Jonas", "estrela", 55);
		placar.registrarPonto("Felipe", "estrela", 55);
		placar.registrarPonto("Carlos", "estrela", 55);
		placar.registrarPonto("Rejane", "estrela", 55);
		placar.registrarPonto("Jonas", "estrela", 55);
		
		assertEquals("Felipe, Jonas, Carlos, Rejane", placar.retornarUsuarios());
	}
	
	@Test
	public void testRetornarRank(){
		placar.registrarPonto("Felipe", "estrela", 44);
		placar.registrarPonto("Jonas", "moeda", 67);
		placar.registrarPonto("Jonas", "estrela", 55);
		placar.registrarPonto("Felipe", "estrela", 55);
		placar.registrarPonto("Carlos", "estrela", 55);
		placar.registrarPonto("Rejane", "estrela", 55);
		placar.registrarPonto("Jonas", "estrela", 55);
			
		
		assertEquals("Jonas com 110, Felipe com 99, Carlos com 55, Rejane com 55"
					, placar.retornarRankPonto("estrela"));
	}

}
