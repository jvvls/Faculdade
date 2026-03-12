package imc;
import java.math.*;

public class Pessoa {
	char nome;
	char sobrenome;
	int idade;
	double altura;
	double peso;
	double imc;
	
	public Pessoa(char nome2, char sobrenome2, int idade2, double altura2, int peso2, int imc2) {
		this.nome = nome2;
		this.sobrenome = sobrenome2;
		this.idade = idade2;
		this.altura = altura2;
		this.peso = peso2;
		this.imc = calcularIMC();	}

	public double calcularIMC() {
		return peso/Math.pow(altura, 2);
	}
	
	public String informaObesidade() {

	    if (imc < 18.5) {
	        return "Abaixo do peso";
	    }
	    else if (imc < 25) {
	        return "Peso normal";
	    }
	    else if (imc < 30) {
	        return "Sobrepeso";
	    }
	    else if (imc < 35) {
	        return "Obesidade grau 1";
	    }
	    else if (imc < 40) {
	        return "Obesidade grau 2";
	    }
	    else {
	        return "Obesidade grau 3";
	    }

	}
	
	public char getNome() {
		return nome;
	}
	public void setNome(char nome) {
		this.nome = nome;
	}
	public char getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(char sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
}
