package jave.api.odedApi;

import jave.api.odedApi.model.Task;
import jave.api.odedApi.repository.TaskRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class OdedApiApplication implements CommandLineRunner {

	@Autowired
	private TaskRepositoryInterface repo;

	public static void main(String[] args) {
		SpringApplication.run(OdedApiApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception
	{
		repo.deleteAll();

		// save a couple of customers
		repo.save(new Task(1,"Dishes", "Smith",));
		repo.save(new Task("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}
