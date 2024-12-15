package Entidades;

import java.sql.Date;

public class Transacciones {

	//Creamos los atributos de la clase
	private int id_transaccion;
	private int id_cuentaOrigen;
	private int id_cuentaDestino;
	private String tipo_transaccion;
	private float cantidad;
	private Date fecha;
	private String descripcion;
	
	
	//Creamos los constructores
	public Transacciones() {
		
	}
	
	public Transacciones(int id_transaccion, int id_cuentaOrigen,int id_cuentaDestino, String tipo_transaccion, float cantidad, Date fecha,
			String descripcion) {
		super();
		this.id_transaccion = id_transaccion;
		this.id_cuentaOrigen = id_cuentaOrigen;
		this.id_cuentaDestino = id_cuentaDestino;
		this.tipo_transaccion = tipo_transaccion;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	
	//Creamos los getters y los setters
	public int getId_transaccion() {
		return id_transaccion;
	}

	public int getId_cuentaOrigen() {
		return id_cuentaOrigen;
	}

	public void setId_cuentaOrgien(int id_cuentaOrigen) {
		this.id_cuentaOrigen = id_cuentaOrigen;
	}

	public int getId_cuentaDestino() {
		return id_cuentaDestino;
	}
	
	public void setId_cuentaDestino(int id_cuentaDestino) {
		this.id_cuentaDestino = id_cuentaDestino;
	}

	public String getTipo_transaccion() {
		return tipo_transaccion;
	}

	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "Transacciones [id_transaccion=" + id_transaccion + ", id_cuentaOrigen=" + id_cuentaOrigen
				+ ", id_cuentaDestino=" + id_cuentaDestino + ", tipo_transaccion=" + tipo_transaccion + ", cantidad="
				+ cantidad + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}

	
}
