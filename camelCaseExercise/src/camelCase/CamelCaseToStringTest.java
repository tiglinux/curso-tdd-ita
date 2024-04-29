package camelCase;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import camelCase.exceptions.CamelCaseException;
import org.junit.Assert;

/**
 * @author Tiago Santos
 */

public class CamelCaseToStringTest {
	
	private CamelCaseToString camelCase;
	private List<String> strList;
	
	@Before
	public void setup() {
		camelCase = new CamelCaseToString();
	}
	
	@Test(expected = CamelCaseException.class)
	public void testExpectedExceptions() {
		camelCase.converterCamelCase("");
		camelCase.converterCamelCase(" ");
		camelCase.converterCamelCase("10Primeiros");
		camelCase.converterCamelCase("nome#Composto");
	}
	
	@Test
	public void testCamelCase() {
		//verify if string list index has 1
		strList = camelCase.converterCamelCase("nome");
		Assert.assertEquals(strList.size(),1);
		Assert.assertEquals(strList.get(0),"nome");
		
		//verify if string exists camelCase
		strList = camelCase.converterCamelCase("nomeComposto");
		Assert.assertEquals(strList.size(), 2);
		Assert.assertEquals(strList.get(0), "nome");
		Assert.assertEquals(strList.get(1), "composto");
		
		//verify if string exists camelCase
		strList = camelCase.converterCamelCase("nomeComposto");
		Assert.assertEquals(strList.size(), 2);
		Assert.assertEquals(strList.get(0), "nome");
		Assert.assertEquals(strList.get(1), "composto");
		
		//verify string CPF
		strList = camelCase.converterCamelCase("CPF");
		Assert.assertEquals(strList.size(), 1);
		Assert.assertEquals(strList.get(0), "CPF");
		
		//verify string recupera10primeiros
		strList = camelCase.converterCamelCase("recupera10Primeiros");
		Assert.assertEquals(strList.size(), 3);
		Assert.assertEquals(strList.get(0), "recupera");
		Assert.assertEquals(strList.get(1), "10");
		Assert.assertEquals(strList.get(2), "primeiros");
	}
	
	@Test
	public void testIfStrNull() {
		Assert.assertFalse(camelCase.isValidString(null));
	}
	
	@Test
	public void testIfExistsNumberBetweenString() {
		Assert.assertTrue(camelCase.isNumberBetweenString("recupera10Primeiros"));
		Assert.assertTrue(camelCase.isNumberBetweenString("abdcdeseffd123asbc"));
	}
	
	//verify if string size is as expected
	@Test
	public void testStrSize() {
		Assert.assertEquals(9, "numeroCPF".length());
	}
	

}