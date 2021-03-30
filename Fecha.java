package Fecha;

public class Fecha implements Comparable <Fecha>, Cloneable{
	
	//Atributos
	
	int dia;
	int mes;
	int anyo;
	
	//Metodos
	
	//Metodo constructor
	
	public Fecha (int dia, int mes, int anyo) {
		
		this.anyo = anyo;
		this.mes = mes;
		this.dia = dia;
		
		if (! this.esCorrecta()) {
			System.err.println("Construcción de fecha incorrecta");
			}
	}
	
	  public boolean esCorrecta() {
		    // año correcto
		    if (this.anyo == 0) {
		      return false;
		    }
		    // mes correcto
		    if (this.mes < 1 || this.mes > 12) {
		      return false;
		    }
		    // día correcto
		    return this.dia > 0 && this.dia <= diasMes(this.mes, this.anyo);
		  }
	  
	  public int getDia() {
		  return dia;
	  }
	  
	  public void setDia(int dia) {
		  this.dia = dia;
		  
		  if (! this.esCorrecta()) {
			  System.err.println("Construcción incorrecta");
		  }
	  }
	public Fecha sumardias (Fecha fecha1, int dias) {
		return new Fecha (this.dia  + dias, this.mes, this.anyo);
		}
	
	public Fecha restardias (Fecha fecha1, int dias) {
		return new Fecha (this.dia + (-1 * dias), this.mes, this.anyo);
		}
	
	  public int getMes() {
		    return mes;
		  }

		  public void setMes(int mes) {
		    this.mes = mes;

		    // ¿fecha correcta?
		    if (! this.esCorrecta()) {
		      System.err.println("Construcción de fecha incorrecta");
		    } 
		  }

		  public int getAnyo() {
		    return anyo;
		  }

		  public void setAnyo(int anyo) {
		    this.anyo = anyo;

		    // ¿fecha correcta?
		    if (! this.esCorrecta()) {
		      System.err.println("Construcción de fecha incorrecta");
		    }
		  }
		  
		  public String getNombreMes() {
			    String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
			        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
			    
			    
			    if (this.mes > 0 && this.mes <= 12) {    // ¿mes correcto?
			      return meses[this.mes-1];
			    } else {
			      return "MES_INCORRECTO";
			    }
			  }
		  
		  public static boolean esBisiesto(int anyo) {
			    return anyo%400==0 || (anyo%4==0 && anyo%100!=0);
			  }

			  public static int diasMes(int mes, int anyo) {
			    int[] diasMes_ = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			    if (esBisiesto(anyo)) {
			      diasMes_[1] = 29;
			    }
			    return diasMes_[mes - 1];
			  }
	
	public int comparar (int dia, int mes, int anyo) {
		int a = this.anyo * 365 + this.mes * 30 + this.dia;
		int b = anyo * 365 + mes * 30 + dia;
		return a - b;
		
	}
	
	  /**
	   * Sumar un día a la fecha almacenada.
	   */
	
	  private void sumar1Dia() {
		    
		    if (! this.esCorrecta()) {    // solo operamos si la fecha es correcta
		      System.err.println("No se puede operar con una fecha incorrecta");
		      return;
		    }

		    // aumentamos el día
		    this.dia++;
		    if (this.dia > diasMes(this.mes, this.anyo)) {
		      // mes siguiente
		      this.dia = 1;
		      this.mes++;
		      if (this.mes>12) { // nos pasamos de diciembre, año siguiente
		        this.mes = 1;
		        this.anyo++;
		      }
		    }
		  }

		  /**
		   * Suma una serie de días a la fecha almacenada.
		   * @param dias
		   */
	  
		  public void sumarDias(int dias) {
		    
		    if (! this.esCorrecta()) {      // solo operamos si la fecha es correcta
		      System.err.println("No se puede operar con una fecha incorrecta");
		      return;
		    }
		    
		    if (dias>=0) {                  // si los días son + sumo, sino resto
		      for (int i=1; i<=dias; i++) {
		        this.sumar1Dia();
		      }
		    } else {
		      for (int i=1; i<=Math.abs(dias); i++) {
		        this.restar1Dia();
		      }
		    }
		  }

		  /**
		   * Resta un día a la fecha almacenada.
		   */
		  
		  public void restar1Dia() {
		    
		    if (! this.esCorrecta()) {    // solo operamos si la fecha es correcta
		      System.err.println("No se puede operar con una fecha incorrecta");
		      return;
		    }
		    
		    // disminuimos el día
		    dia--;
		    if (dia == 0) { // mes anterior y último día de mes
		      mes--;
		      if (mes == 0) { // 31 de diciembre del año anterior
		        mes = 12;
		        anyo--;
		        if (anyo == 0) { // no puede haber año 0
		          anyo = -1;
		        }
		      } 
		      dia = diasMes(mes, anyo); // último día del mes anterior
		    }
		  }

		  /**
		   * Resta una serie de días a la fecha almacenada.
		   */
		  public void restarDias(int dias) {
		    
		    if (! this.esCorrecta()) {          // solo operamos si la fecha es correcta
		      System.err.println("No se puede operar con una fecha incorrecta");
		      return;
		    }
		    
		    if (dias>=0) {
		      for (int i=1; i<=dias; i++) {     // si los días son + resto, sino sumo
		        this.restar1Dia();
		      }
		    } else {
		      for (int i=1; i<=Math.abs(dias); i++) {
		        this.sumar1Dia();
		      }
		    }
		  }
		  
		  public static int restar(Fecha fecha1, Fecha fecha2) {
			    int dias = 0;
			    Fecha f1 = fecha1.clone(); // primera fecha ¡no se puede igualar!
			    
			    // sumamos o restamos días hasta que f1 llegue a fecha2
			    if (fecha1.compareTo(fecha2) < 0) {     // los días serán negativos ya que fecha1 < fecha2
			      for (; f1.equals(fecha2); dias--) {   
			        f1.sumar1Dia();
			      }
			    } else {                                // los días serán positivos ya que fecha1 >= fecha2
			      for (; f1.equals(fecha2); dias++) {   // los días serán negativos ya que fecha1 < fecha2
			        f1.restar1Dia();
			      }
			    }
			    
			    return dias;
			  }
	
	@Override
	public Fecha clone() {
	    return new Fecha(this.dia, this.mes, this.anyo);
	  }
	
	@Override
	public int compareTo(Fecha fecha2) {
	    // solo operamos si la fecha es correcta
	    if (! this.esCorrecta()) {    
	      System.err.println("No se puede operar con una fecha incorrecta");
	      return 0;
	    }
	    
	    int f1 = this.anyo*10000 + this.mes*100 + this.dia;
	    int f2 = fecha2.anyo*10000 + fecha2.mes*100 + fecha2.dia;
	    return f1-f2;
	  }
	
	 @Override
	  public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + anyo;
	    result = prime * result + dia;
	    result = prime * result + mes;
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
	    Fecha other = (Fecha) obj;
	    if (anyo != other.anyo)
	      return false;
	    if (dia != other.dia)
	      return false;
	    if (mes != other.mes)
	      return false;
	    return true;
	  }
	  
	@Override
	public String toString() {
		return "Fecha: " + dia + " de " + this.getNombreMes() + " de " + this.anyo;
	}
	
	

}
