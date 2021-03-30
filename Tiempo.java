package Tiempo;

public class Tiempo {
	
	//Atributos
	
	int horas;
	int minutos;
	int segundos;
	
	//Metodos
	
	//Metodo constructor
	public Tiempo (int horas, int minutos, int segundos) {
		int s = horas * 3600 + minutos * 60 + segundos;
		
		this.horas = s / 3600;
		this.minutos = (s % 3600) / 60;
		this.segundos = (s % 3600) % 60;
		}
	
	//Metodo para sumar dos tiempos
	
	public Tiempo sumar(Tiempo tiempo2) {
		return new Tiempo(this.horas + tiempo2.horas, this.minutos + tiempo2.minutos, this.segundos + tiempo2.segundos);
	}
	
	//Metodo para restar dos tiempos

	public Tiempo restar(Tiempo tiempo2) {
		return new Tiempo(this.horas - tiempo2.horas, this.minutos - tiempo2.minutos, this.segundos - tiempo2.segundos);
	}
	
	//Metodo para modificar un objeto sumandole segundos

	
	public void sumarsegundos(int segundos) {
		Tiempo auxi = new Tiempo (this.horas, this.minutos, this.segundos + segundos);
		this.horas = auxi.horas;
		this.minutos = auxi.minutos;
		this.segundos = auxi.segundos;
	}
	
	//Metodo para modificar un objeto restandole segundos

	public void restarsegundos(int segundos) {
		this.sumarsegundos(-1 * segundos);
	}
	
	//Metodo para modificar un objeto sumandole minutos

	public void sumarminutos(int minutos) {
		this.sumarsegundos(60 * segundos  );
	}
	
	//Metodo para modificar un objeto restandole minutos

	
	public void restarminutos(int minutos) {
		this.sumarsegundos(-60 * segundos);
	}
	
	//Metodo para modificar un objeto sumandole horas
	
	public void sumarhoras (int horas) {
		this.sumarsegundos(3600 * segundos);
	}
	
	//Metodo para modificar un objeto restandole minutos

	public void restarhoras (int horas) {
		this.sumarsegundos(-3600 * segundos);
	}
	
	
	@Override
	public String toString() {
		return "Tiempo: " + horas + "h" + ", " + minutos + "m, " + segundos + "s.";
	}
	
}
