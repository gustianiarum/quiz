package id.gustiani.quis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.gustiani.quis.model.dto.DataDto;
import id.gustiani.quis.model.entity.Biodata;

public interface BiodataRepo extends JpaRepository<Biodata, Integer> {

	@Query(value="SELECT nohp FROM t_biodata i INNER JOIN t_person p "
			+ "ON i.id_person=p.id_person WHERE ?1", nativeQuery=true)
	 DataDto savenohp (String nik);
	@Query(value="SELECT tanggal_lahir FROM t_biodata i INNER JOIN t_person p "
			+ "ON i.id_person=p.id_person WHERE ?1", nativeQuery=true)
	 DataDto savetgl (String nik);
	@Query(value="SELECT tempat_lahir FROM t_biodata i INNER JOIN t_person p "
			+ "ON i.id_person=p.id_person WHERE ?1", nativeQuery=true)
	 DataDto savetempatlahir (String nik);
	
}
