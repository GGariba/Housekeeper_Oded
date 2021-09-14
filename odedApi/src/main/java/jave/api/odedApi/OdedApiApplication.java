package jave.api.odedApi;

import jave.api.odedApi.model.Task;
import jave.api.odedApi.repository.TaskRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
		repo.save(new Task(1,"Dishes", "Wash","Wash dishes and clean the sink to gain 3 stars",3));
		repo.save(new Task(2,"Dishes", "sort","Sort and order the dishes to gain 2 stars",2));

		// fetch all customers
		System.out.println("Tasks found with findAll():");
		System.out.println("-------------------------------");
		for (Task task : repo.findAll()) {
			System.out.println(task);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Task found with findByTaskId(2):");
		System.out.println("--------------------------------");
		System.out.println(repo.findByTaskId(2));

		System.out.println("Tasks found with findByTaskCategory(\"Dishes\"):");
		System.out.println("--------------------------------");
		for (Task task : repo.findByTaskCategory("Dishes")) {
			System.out.println(task);
		}
	}
}
