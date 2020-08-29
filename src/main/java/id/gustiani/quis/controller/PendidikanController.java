package id.gustiani.quis.controller;

//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import id.gustiani.quis.repository.DataRepo;
import id.gustiani.quis.repository.PendidikanRepo;
//import id.gustiani.quis.repository.PendidikanRepo;
import id.gustiani.quis.repository.PersonRepo;
//import id.gustiani.quis.service.BiodataService;
import id.gustiani.quis.service.PendidikanService;
import id.gustiani.quis.model.dto.DataDto;
//import id.gustiani.quis.model.dto.DataDto;
import id.gustiani.quis.model.dto.PendidikanDto;
import id.gustiani.quis.model.dto.Response;
//import id.gustiani.quis.model.dto.PersonDto;
import id.gustiani.quis.model.entity.Pendidikan;
import id.gustiani.quis.model.entity.Person;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {

	private final PersonRepo personRepo;
	private final PendidikanRepo pendidikanRepo;
//	private final DataRepo dataRepo;

	@Autowired
	public PendidikanController(PersonRepo personRepo, PendidikanRepo pendidikanRepo) {
		this.personRepo = personRepo;
		this.pendidikanRepo = pendidikanRepo;
//		this.dataRepo=dataRepo;
	}
	@Autowired
	 PendidikanService pendidikanService;

	@PostMapping("/insertpendidikan/{idPerson}")
//	public List<PendidikanDto> insert(@PathVariable Integer idPerson, @RequestBody List<PendidikanDto> dto) {
//		List<Pendidikan> pendidikanList = new ArrayList<Pendidikan>();
//		if (personRepo.findById(idPerson).isPresent()) {
//			for (PendidikanDto pendidikanDto : dto) {
//				Pendidikan pendidikan = convertToEntity(pendidikanDto);
//				pendidikanService.insertDataPendidikan(pendidikan);
//				pendidikanList.add(pendidikan);
//			}
//		}
//		List<PendidikanDto> pendidikanDtoList = pendidikanList.stream().map(this::convertToDto)
//				.collect(Collectors.toList());
//		return pendidikanDtoList;
//	}

	public Response insert(@PathVariable Integer idPerson, @RequestBody List<PendidikanDto> pdto){
		List<Pendidikan>pdtList=pdto.stream().map(a->convertToEntity(a,idPerson)).collect(Collectors.toList());
		pdtList.stream().forEach(b->pendidikanRepo.save(b));
//		return pdtList;
		if(pdtList.size()==0) {
			return status(false,"data gagal masuk");
		}
		return status(true,"data berhasil masuk");
	}
//	private PendidikanDto convertToDto(Pendidikan pdt) {
//		PendidikanDto pdto = new PendidikanDto();
//		pdto.setInstitusi(pdt.getInstitusi());
//		pdto.setJenjang(pdt.getJenjang());
//		pdto.setLulus(pdt.getTahunlulus());
//		pdto.setMasuk(pdt.getTahunmasuk());
//		pdto.setIdPendidikan(pdt.getIdPendidikan());
//		pdto.setIdPerson(pdt.getPerson().getIdPerson());
//		return pdto;
//	}

	public Pendidikan convertToEntity(PendidikanDto pdto, Integer idPerson) {
		Pendidikan pdkt = new Pendidikan();
		pdkt.setInstitusi(pdto.getInstitusi());
		pdkt.setJenjang(pdto.getJenjang());
		pdkt.setTahunlulus(pdto.getLulus());
		pdkt.setTahunmasuk(pdto.getMasuk());
		if (personRepo.findById(idPerson).isPresent()) {
			Person person = personRepo.findById(idPerson).get();
			pdkt.setPersonId(person);
		}
		return pdkt;
	}
	private Response status(Boolean stat, String message) {
		Response respon = new Response();
		if (stat == false) {
			respon.setStatus("false");
			respon.setMessage(message);
		} else {
			respon.setStatus("true");
			respon.setMessage(message);
		}
		return respon;

	}
//	 @GetMapping("/{nikk}")
//	    public DataDto get(@PathVariable String nik) {
//	        DataDto dataDto=new DataDto();
//	        dataDto.setAdress(personRepo.saveadress(nik));
//	        
//	        }
//	        return null;
//	    }

}
