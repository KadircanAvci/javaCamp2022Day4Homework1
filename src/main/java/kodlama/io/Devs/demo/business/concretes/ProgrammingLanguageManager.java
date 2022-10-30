package kodlama.io.Devs.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.demo.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	
	@Autowired
	public ProgrammingLanguageManager (ProgrammingLanguageRepository programmingLanguageRepository) {
		
		this.programmingLanguageRepository = programmingLanguageRepository;
		
	}
	
	
	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		
		
		if(programmingLanguage.getName() == "") {
			throw new Exception ("Programlama ismi boş bırakılamaz.");
		}
		
		for (ProgrammingLanguage languages : programmingLanguageRepository.getAll()) {
			
			if(languages.getId() == (programmingLanguage.getId())) {
				throw new Exception ("Bu id daha önce kullanılmıştır.");
			}
			if(languages.getName().equals(programmingLanguage.getName())  ) {
				throw new Exception ("Bu programlamlama ismi daha önce kullanılmıştır.");
			}
			
		}
			
			this.programmingLanguageRepository.add(programmingLanguage);
			
			System.out.println("Programlama dili kaydedildi.");
		

		
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if(programmingLanguage.getName() == "") {
			throw new Exception ("Programlama ismi boş bırakılamaz.");
		}
		
		for (ProgrammingLanguage languages : programmingLanguageRepository.getAll()) {
			
			
			if(languages.getName().equals(programmingLanguage.getName())  ) {
				throw new Exception ("Bu programlamlama ismi daha önce kullanılmıştır.");
			}
			
		}
		this.programmingLanguageRepository.update(programmingLanguage);
		
	}


	@Override
	public void delete(int id) {
		this.programmingLanguageRepository.delete(id);
		
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return this.programmingLanguageRepository.getAll();
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		
		return this.programmingLanguageRepository.getById(id);
	}

}
