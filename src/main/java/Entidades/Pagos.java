package Entidades;

import java.sql.Date;

public class Pagos {
	//Creamos los atributos de la clase
	private int id_pago;
	private int prestamo;
	private float cantidad;
	private Date fecha_pago;
	
	
	//Creamos los constructores
	public Pagos() {
		
	}
	
	
	public Pagos(int id_pago, int prestamo, float cantidad, Date fecha_pago) {
		super();
		this.id_pago = id_pago;
		this.prestamo = prestamo;
		this.cantidad = cantidad;
		this.fecha_pago = fecha_pago;
	}
	
	
	//Creamos los getters y los setters
	public int getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(int prestamo) {
		this.prestamo = prestamo;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public int getId_pago() {
		return id_pago;
	}

	
	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "Pagos [id_pago=" + id_pago + ", prestamo=" + prestamo + ", cantidad=" + cantidad + ", fecha_pago="
				+ fecha_pago + "]";
	}	
}
