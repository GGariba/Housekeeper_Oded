package jave.api.odedApi.repository;

import jave.api.odedApi.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TaskRepositoryInterface extends MongoRepository<Task,String>{
    public List<Task> findByTaskCategory(String taskCategory);
    public List<Task> findByTaskAction(String taskAction);
    public List<Task> findByTaskStars(Integer taskStars);
    public Task findByTaskId(Integer taskID);
}
