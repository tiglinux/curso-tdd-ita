package classes;
/**
 * @author Tiago Ribeiro Santos
 */

public class ContaCorrente {
	private String numConta;
	private double saldo;
	
	public ContaCorrente(String numConta, double saldo) {
		this.numConta = numConta;
		this.saldo = saldo;
	}
	
	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
