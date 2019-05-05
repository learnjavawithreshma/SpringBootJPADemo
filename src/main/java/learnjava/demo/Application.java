package learnjava.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	PersonRepository personRepo;
	
	public static void main(String args[]){
		 SpringApplication.run(Application.class, args);
	}

	public void run(String... arg0) throws Exception {
		System.out.println("Inserting person records:");
		
		Person person1 = new Person("Mickey Mouse",35);
		Person person2 = new Person("Donald Duck",30);
		personRepo.save(person1);
		personRepo.save(person2);
		
		List<Person> personList = personRepo.findAll();
		personList.forEach(person -> System.out.println(person.toString()));
		
		
	}

}
