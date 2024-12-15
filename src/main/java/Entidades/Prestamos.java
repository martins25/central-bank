package Entidades;

import java.sql.Date;

public class Prestamos {
	
	//Creamos los atributos
	private int idPrestamo; 
	private int idUsuario; 
	private float cantidad; 
	private float interes; 
	private int plazoMeses; 
	private Date fechaInicio; 
	private float saldoPendiente;
	
	
	//Creamos los constructores
	public Prestamos() {
		
	}
	
	public Prestamos(int idPrestamo, int idUsuario, float cantidad, float interes, int plazoMeses, Date fechaInicio,
			float saldoPendiente) {
		super();
		this.idPrestamo = idPrestamo;
		this.idUsuario = idUsuario;
		this.cantidad = cantidad;
		this.interes = interes;
		this.plazoMeses = plazoMeses;
		this.fechaInicio = fechaInicio;
		this.saldoPendiente = saldoPendiente;
	}
	
	
	//Creamos los getters y setters
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	public int getPlazoMeses() {
		return plazoMeses;
	}
	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public float getSaldoPendiente() {
		return saldoPendiente;
	}
	public void setSaldoPendiente(float saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}
	public int getIdPrestamo() {
		return idPrestamo;
	}
	
	
	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "Prestamos [idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + ", cantidad=" + cantidad
				+ ", interes=" + interes + ", plazoMeses=" + plazoMeses + ", fechaInicio=" + fechaInicio
				+ ", saldoPendiente=" + saldoPendiente + "]";
	}
}
