package id.gustiani.quis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.gustiani.quis.model.dto.DataDto;
import id.gustiani.quis.model.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
//	DataDto findByNik(String nik);
//	@Query(value="SELECT nik FROM t_person i WHERE ?1", nativeQuery=true)
//	 public void savenik (String nik) {
//		DataDt
//	}
//	@Query(value="SELECT nama FROM t_person i WHERE ?1", nativeQuery=true)
//	 DataDto savenama (String nik);
//	@Query(value="SELECT alamat FROM t_person i WHERE ?1", nativeQuery=true)
//	 DataDto saveadress (String nik);
	
}
