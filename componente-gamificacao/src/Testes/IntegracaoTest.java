package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import classes.Armazenamento;
import classes.Placar;

public class IntegracaoTest {

	Placar placar;
	Armazenamento arm;
	
	@Before
	public void setUp(){
		try {
			arm = new Armazenamento("Placar");
		} catch (IOException e) {
			System.out.println("Não foi possível criar o arquivo!");
		}
		placar = new Placar(arm);
	}

	@After
	public void tearDown() {
		File file = new File("Placar.txt");
		file.delete();
	}

	@Test
	public void testIntegracao() {
		placar.registrarPonto("Felipe", "estrela", 30);
		placar.registrarPonto("Felipe", "estrela", 55);
		placar.registrarPonto("Felipe", "moeda", 20);
		placar.registrarPonto("Jonas", "curtida", 17);
		placar.registrarPonto("Marina", "moeda", 75);
		placar.registrarPonto("Carlos", "urtida", 40);
		
		assertEquals("Felipe possui 20 pontos do tipo moeda e "
				+ "85 pontos do tipo estrela", placar.retornarPonto("Felipe"));
		assertEquals("Jonas possui 17 pontos do tipo curtida", placar.retornarPonto("Jonas"));
		assertEquals("Marina possui 75 pontos do tipo moeda", placar.retornarPonto("Marina"));
		assertEquals("Marina possui 75 pontos do tipo moeda", placar.retornarPonto("Marina"));
		assertEquals("Marina com 75, Felipe com 20", placar.retornarRankPonto("moeda"));
		assertEquals("Felipe possui 85 pontos do tipo estrela"
				, placar.retornarPontoPorTipo("Felipe", "estrela"));
		assertEquals("Jonas possui 17 pontos do tipo curtida"
				, placar.retornarPontoPorTipo("Jonas", "curtida"));
		assertEquals("Felipe, Jonas, Marina, Carlos", placar.retornarUsuarios());
		
		
	}

}