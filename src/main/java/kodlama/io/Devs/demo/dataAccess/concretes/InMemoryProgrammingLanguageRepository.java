package kodlama.io.Devs.demo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;

 @Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{
	
			List<ProgrammingLanguage> programmingLanguages;
			
			public InMemoryProgrammingLanguageRepository () {
				programmingLanguages = new ArrayList<ProgrammingLanguage>();
				programmingLanguages.add(new ProgrammingLanguage(1,"JAVA"));
				programmingLanguages.add(new ProgrammingLanguage(2,"Phyton"));
				programmingLanguages.add(new ProgrammingLanguage(3,"C++"));
				programmingLanguages.add(new ProgrammingLanguage(4,"C#"));
				
			}
			

			@Override
			public void add(ProgrammingLanguage programmingLanguage) {
				
				programmingLanguages.add(programmingLanguage);
				
			
				
			}

			@Override
			public void update(ProgrammingLanguage programmingLanguage) {
				
				for (ProgrammingLanguage language : programmingLanguages) {
					if(language.getId() == programmingLanguage.getId()) {
						programmingLanguages.set(language.getId() -1, programmingLanguage);
					}
				}
				
			}

			@Override
			public void delete(int id) {
				programmingLanguages.remove(id-1); //dizinin 0. elemanı bizim id'mizde 1'e karşılık geldiği için id-1 olarak tanımlandı. remove metodu bizden index numarası istemektedir.
				
			}

			@Override
			public List<ProgrammingLanguage> getAll() {
				
				return programmingLanguages;
			}


			@Override
			public ProgrammingLanguage getById(int id) {
				
				return programmingLanguages.get(id-1);
			}
			
			
	
}
