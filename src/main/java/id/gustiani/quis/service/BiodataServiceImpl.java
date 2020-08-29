package id.gustiani.quis.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import id.gustiani.quis.model.entity.Biodata;
import id.gustiani.quis.repository.BiodataRepo;
import id.gustiani.quis.repository.PersonRepo;

@Transactional
@Service
public class BiodataServiceImpl implements BiodataService {
	@Autowired
	private PersonRepo personRepo;
	@Autowired
	private BiodataRepo biodataRepo;
	

	@Override
	public Biodata insertBiodata(Biodata biodata) {
		personRepo.save(biodata.getPerson());
		biodataRepo.save(biodata);
		return biodata;
	}
}
