package Fraccion;

public class Fraccion implements Cloneable, Comparable<Fraccion> {
	
	//Atributos

	private int denominador;
	private int numerador;
	
	//Metodos
	
	//Metodo contrucctor
	public Fraccion(int numerador, int denominador){
		this.denominador = denominador;
		this.numerador = numerador;
	}
	
	//Metodo para crear otro objeto resultante de multiplicar un numero por una fraccion
	
	public Fraccion multiplicarNumero(int numero) {
		return new Fraccion (this.numerador * numero, denominador);
	}
	
	//Metodo para crear otro objeto resultante de multiplicar una fraccion por una fraccion
	
	public Fraccion multiplicarFraccion(int multnumerador, int multdenominador) {
		return new Fraccion (this.numerador * multnumerador, this.denominador * multdenominador);
	}
	
	//Metodo para crear otro objeto resultante de sumar dos fracciones

	public Fraccion sumarFraccion(int sumanumerador, int sumadenominador) {
		return new Fraccion ((this.numerador * sumadenominador) + (this.denominador * sumanumerador), this.denominador * sumadenominador);
	}
	
	//Metodo para crear otro objeto resultante de restar dos fracciones
	
	public Fraccion restarFraccion(int restanumerador, int restadenominador) {
		return new Fraccion ((this.numerador * restadenominador) - (this.denominador * restanumerador), this.denominador * restadenominador);
	}
	
	//Metodo para para simplificar una fraccion

	public void simplificar() {
		int a = Math.abs(this.numerador);
		int b = Math.abs(this.denominador);
		
		while (b >  0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		int mcd = a;
		
		this.numerador /= mcd;
		this.denominador /= mcd;
		
	}
	
	@Override
	public int compareTo(Fraccion fraccion2) {
		return this.numerador * fraccion2.denominador - fraccion2.numerador * this.denominador;
	}
	
	@Override
	public Fraccion clone() {
		return new Fraccion (this.numerador, this.denominador);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominador;
		result = prime * result + numerador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraccion other = (Fraccion) obj;
		other.simplificar();
		Fraccion copia = this.clone();
		if (copia.denominador != other.denominador)
			return false;
		if (copia.numerador != other.numerador)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fraccion: numerador=" + numerador + ", denominador=" + denominador;
	}
}
