package id.gustiani.quis.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="t_biodata")
public class Biodata {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bio")
	private Integer idBio;
	
	@Column(name="nohp",length=16)
	private String hp;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tanggal_lahir")
	private Date tgl;
	
	@Column(name="tempat_lahir",length=50)
	private String tempatLahir;
	
	@OneToOne
	@JoinColumn(name="id_person", nullable=false)
	private Person person;

	public Integer getIdBio() {
		return idBio;
	}

	public void setIdBio(Integer idBio) {
		this.idBio = idBio;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
