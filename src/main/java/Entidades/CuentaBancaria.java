package Entidades;

import java.sql.Date;

public class CuentaBancaria {
	
	//Creamos los atributos de la clase
	private int id_cuenta;
	private int id_usuario;
	private String numeroCuenta;
	private String tipo;
	private float saldo;
	private Date fecha_creacion;
	private Boolean activada;

	
	//Creamos los constructores
	public CuentaBancaria() {
		
	}
	
	public CuentaBancaria(int id_cuenta, int id_usuario, String numeroCuenta, String tipo, float saldo, Date fecha_creacion, Boolean activada) {
		super();
		this.id_cuenta = id_cuenta;
		this.id_usuario = id_usuario;
		this.numeroCuenta = numeroCuenta;
		this.tipo = tipo;
		this.saldo = saldo;
		this.fecha_creacion = fecha_creacion;
		this.activada = activada;
	}

	


	//Creamos los getters y setters
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getId_cuenta() {
		return id_cuenta;
	}
	
	public Boolean getActivada() {
		return activada;
	}

	public void setActivada(Boolean activada) {
		this.activada = activada;
	}

	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "CuentaBancaria [id_cuenta=" + id_cuenta + ", id_usuario=" + id_usuario + ", numeroCuenta="
				+ numeroCuenta + ", tipo=" + tipo + ", saldo=" + saldo + ", fecha_creacion=" + fecha_creacion + "]";
	}
	
}
