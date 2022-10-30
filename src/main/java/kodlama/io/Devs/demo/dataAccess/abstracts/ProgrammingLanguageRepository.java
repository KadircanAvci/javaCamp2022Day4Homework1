package kodlama.io.Devs.demo.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
		void add(ProgrammingLanguage programmingLanguage);
		void update(ProgrammingLanguage programmingLanguage);
		void delete(int id);
		List<ProgrammingLanguage> getAll();
		ProgrammingLanguage getById(int id);
		
}
