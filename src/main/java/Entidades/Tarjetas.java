package Entidades;

import java.sql.Date;

public class Tarjetas {
	
	//Creamos los atributos
	private int idTarjeta; 
	private int idCuenta; 
	private String numeroTarjeta; 
	private String tipoTarjeta; 
	private Date fechaExpiracion; 
	private String codigoSeguridad; 
	private float limiteCredito; 
	private boolean activada;
	
	
	//Creamos los constructores
	public Tarjetas() {
		
	}
	
	public Tarjetas(int idTarjeta, int idCuenta, String numeroTarjeta, String tipoTarjeta, Date fechaExpiracion,
			String codigoSeguridad, float limiteCredito, boolean activada) {
		super();
		this.idTarjeta = idTarjeta;
		this.idCuenta = idCuenta;
		this.numeroTarjeta = numeroTarjeta;
		this.tipoTarjeta = tipoTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.codigoSeguridad = codigoSeguridad;
		this.limiteCredito = limiteCredito;
		this.activada = activada;
	}

	
	//Creamos los getters y los setters
	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public boolean isActivada() {
		return activada;
	}

	public void setActivada(boolean activada) {
		this.activada = activada;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	
	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "Tarjetas [idTarjeta=" + idTarjeta + ", idCuenta=" + idCuenta + ", numeroTarjeta=" + numeroTarjeta
				+ ", tipoTarjeta=" + tipoTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", codigoSeguridad="
				+ codigoSeguridad + ", limiteCredito=" + limiteCredito + ", activada=" + activada + "]";
	}
	
}
