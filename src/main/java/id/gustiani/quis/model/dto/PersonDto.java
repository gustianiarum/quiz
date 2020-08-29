package id.gustiani.quis.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class PersonDto {
	private String nik;
	private String name;
	private String address;
	private String hp;
	
	
	private Date tgl;
	private Integer idPerson;
	private Integer idBio;
	private String tempatLahir;
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	@JsonFormat(shape=Shape.STRING, pattern="dd-MMMM-yyyy")
	public Date getTgl() {
		return tgl;
	}
	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}
	public Integer getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
	public Integer getIdBio() {
		return idBio;
	}
	public void setIdBio(Integer idBio) {
		this.idBio = idBio;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	
}
