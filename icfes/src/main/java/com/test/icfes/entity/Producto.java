package com.test.icfes.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producto")
public class Producto {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;

	private String nombreProducto;
	
	private long precio;
	
	private String tipoMaterial;
	
	private String tipoProducto;		

	private Integer cantidadDisponible;	

	private String peso;	

	private String medidas;
	
	private String color;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;			

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEdito;		
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int idProducto, String nombreProducto, long precio, String tipoMaterial, String tipoProducto,
			Integer cantidadDisponible, String peso, String medidas, String color, Date fechaRegistro,
			Date fechaEdito) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.tipoMaterial = tipoMaterial;
		this.tipoProducto = tipoProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.peso = peso;
		this.medidas = medidas;
		this.color = color;
		this.fechaRegistro = fechaRegistro;
		this.fechaEdito = fechaEdito;
	}

	@PrePersist
	public void prePersist() {
		fechaRegistro = new Date();
		fechaEdito = new Date();
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaEdito() {
		return fechaEdito;
	}

	public void setFechaEdito(Date fechaEdito) {
		this.fechaEdito = fechaEdito;
	}


}
