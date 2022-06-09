package com.carros;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Carros {
	
	@Id @GeneratedValue
	private Long Id;
	private String modelo;
	private String nome;
	private String placa;
	private String km;
	
	public Carros(Long id, String modelo, String nome, String placa, String km) {
		super();
		Id = id;
		this.modelo = modelo;
		this.nome = nome;
		this.placa = placa;
		this.km = km;
	}
	
	Carros() {}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, km, modelo, nome, placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carros other = (Carros) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(km, other.km)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(nome, other.nome)
				&& Objects.equals(placa, other.placa);
	}
	@Override
	public String toString() {
		return "CarrosModel [Id=" + Id + ", modelo=" + modelo + ", nome=" + nome + ", placa=" + placa + ", km=" + km + "]";
	}

}
