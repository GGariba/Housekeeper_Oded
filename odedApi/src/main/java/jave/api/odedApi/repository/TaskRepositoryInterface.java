package jave.api.odedApi.repository;

import jave.api.odedApi.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepositoryInterface extends MongoRepository<Task,String>{
    public Task findByTaskName(String taskName);
}
