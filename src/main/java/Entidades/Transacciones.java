package Entidades;

import java.sql.Date;

public class Transacciones {

	//Creamos los atributos de la clase
	private int id_transaccion;
	private int id_cuenta;
	private String tipo_transaccion;
	private Double cantidad;
	private Date fecha;
	private String Descripcion;
	
	
	//Creamos los constructores
	public Transacciones() {
		
	}
	
	public Transacciones(int id_transaccion, int id_cuenta, String tipo_transaccion, Double cantidad, Date fecha,
			String descripcion) {
		super();
		this.id_transaccion = id_transaccion;
		this.id_cuenta = id_cuenta;
		this.tipo_transaccion = tipo_transaccion;
		this.cantidad = cantidad;
		this.fecha = fecha;
		Descripcion = descripcion;
	}

	
	//Creamos los getters y los setters
	public int getId_transaccion() {
		return id_transaccion;
	}

	public int getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getTipo_transaccion() {
		return tipo_transaccion;
	}

	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "Transacciones [id_transaccion=" + id_transaccion + ", id_cuenta=" + id_cuenta + ", tipo_transaccion="
				+ tipo_transaccion + ", cantidad=" + cantidad + ", fecha=" + fecha + ", Descripcion=" + Descripcion
				+ "]";
	}	
}
