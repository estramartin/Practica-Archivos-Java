package archivos;

public class Elemento {
	
	
	private Integer nro;
	private String nombre;
	private String dni;
	
	public Elemento(Integer nro, String nombre, String dni) {
		
		this.nro = nro;
		this.nombre = nombre;
		this.dni = dni;
		
		
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	

}
