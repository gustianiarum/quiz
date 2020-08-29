package id.gustiani.quis.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.gustiani.quis.model.entity.Pendidikan;
import id.gustiani.quis.repository.PendidikanRepo;

@Service
@Transactional
public class PendidikanServiceImpl implements PendidikanService {
	@Autowired
	private PendidikanRepo pendidikanRepo;
	
	@Override
	public Pendidikan insertDataPendidikan(Pendidikan pendidikan) {
	    Pendidikan entity = pendidikanRepo.save(pendidikan);
	    return pendidikanRepo.save(entity);
	  }

}
