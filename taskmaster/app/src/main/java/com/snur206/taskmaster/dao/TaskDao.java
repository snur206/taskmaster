package com.snur206.taskmaster.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.snur206.taskmaster.model.TaskModel;

import java.util.List;

// TODO Step 4-4: Create a DAO interface for your model
@Dao // Kind of like Spring JPA repository, but implement more stuff
public interface TaskDao {
    @Insert
    public void insertTask(TaskModel taskModel);

    // find all
    @Query("SELECT * FROM TaskModel")
    public List<TaskModel> findAll();
    // findById
    @Query("SELECT * FROM TaskModel WHERE id = :id")
    public TaskModel findById(Long id);
    // findAllByState
    @Query("SELECT * FROM TaskModel WHERE state = :state")
    public  List<TaskModel> findAllByState(TaskModel.TaskStateEnum state);

    @Delete
    public void delete(TaskModel taskModel);
    @Update
    public void update(TaskModel taskModel);


}
