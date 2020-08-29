package id.gustiani.quis.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_pendidikan")
public class Pendidikan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pendidikan")
	private Integer idPendidikan;

	@Column(name = "jenjang", length = 10)
	private String jenjang;

	@Column(name = "institusi", length = 50)
	private String institusi;

	@Column(name = "tahunmasuk", length = 10)
	private String tahunmasuk;
	
	@Column(name = "tahunlulus", length = 10)
	private String tahunlulus;
	
	@ManyToOne
	@JoinColumn(name = "idPerson", nullable=false)
	private Person person;
	
	public Integer getIdPendidikan() {
		return idPendidikan;
	}

	public void setIdPendidikan(Integer idPendidikan) {
		this.idPendidikan = idPendidikan;
	}

	public Person getPerson() {
		return person;
	}

	public void setPersonId(Person person) {
		this.person = person;
	}

	public String getJenjang() {
		return jenjang;
	}

	public void setJenjang(String jenjang) {
		this.jenjang = jenjang;
	}

	public String getInstitusi() {
		return institusi;
	}

	public void setInstitusi(String institusi) {
		this.institusi = institusi;
	}

	public String getTahunmasuk() {
		return tahunmasuk;
	}

	public void setTahunmasuk(String tahunmasuk) {
		this.tahunmasuk = tahunmasuk;
	}

	public String getTahunlulus() {
		return tahunlulus;
	}

	public void setTahunlulus(String tahunlulus) {
		this.tahunlulus = tahunlulus;
	}

}
