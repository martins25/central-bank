package Entidades;

import java.sql.Date;

public class Usuario {
	
	//Creamos los atributos de la clase
	private int id_usuario;
	private String nombre;
	private String correo;
	private String contraseña;
	private Date fecha_registro;
	
	
	//Creamos los constructores que va a usar esta clase
	
	public Usuario(){
		
	}
	
	public Usuario(int id_usuario, String nombre, String correo, String contraseña, Date fecha_registro) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.fecha_registro = fecha_registro;
	}
	
	
	
	//Creamos los getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public int getId_usuario() {
		return id_usuario;
	}

	
	//Sobreescribimos el metodo toString
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", correo=" + correo + ", contraseña="
				+ contraseña + ", fecha_registro=" + fecha_registro + "]";
	}
}
