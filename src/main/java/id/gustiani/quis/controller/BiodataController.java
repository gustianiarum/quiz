package id.gustiani.quis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.gustiani.quis.model.dto.PersonDto;
import id.gustiani.quis.model.dto.Response;
//import id.gustiani.quis.model.dto.Response;
import id.gustiani.quis.model.entity.Biodata;
import id.gustiani.quis.model.entity.Person;
//import id.gustiani.quis.repository.BiodataRepo;
//import id.gustiani.quis.repository.PersonRepo;
import id.gustiani.quis.service.BiodataService;

import java.time.Year;
import java.util.Calendar;

//import java.time.Year;
//import java.util.Calendar;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/biodata")
public class BiodataController {
//	private final PersonRepo personRepo;
//	private final BiodataRepo biodataRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BiodataService biodataService;

//	@Autowired
//	public BiodataController(PersonRepo personRepo, BiodataRepo biodataRepo)
//	{
//		this.personRepo=personRepo;
//		this.biodataRepo=biodataRepo;
//	}

	@PostMapping("/insertbiodata")
	public Response insertData(@RequestBody PersonDto data) {
		Calendar kalendar = Calendar.getInstance();
		kalendar.setTime(data.getTgl());
		if (data.getNik().length() != 16) {

			return status(false, "data gagal masuk, jumlah digit tidak sama dengan 16");
		}
		if((Year.now().getValue()-kalendar.get(Calendar.YEAR))<30) {
			return status(false, "umur kurang dari 30 tahun");
		}
		else {
		Person person = modelMapper.map(data, Person.class);
		Biodata biodata = modelMapper.map(data, Biodata.class);
		biodata.setPerson(person);
		biodataService.insertBiodata(biodata);
//		PersonDto personDtoDB = mapBiodataToPersonDto(biodata);
//		return personDtoDB;
//		respon.setStatus("true");
//		respon.setMessage("data berhasil masuk");
//		return respon;
		return status(true,"data berhasil masuk");
	}}

//	private PersonDto mapBiodataToPersonDto(Biodata biodata) {
//		PersonDto personDto = modelMapper.map(biodata, PersonDto.class);
//		modelMapper.map(biodata.getPerson(), personDto);
//		personDto.setIdBio(biodata.getIdBio());
//		personDto.setIdPerson(biodata.getPerson().getIdPerson());
//		return personDto;
//	}

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
}
