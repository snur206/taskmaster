package com.snur206.taskmaster.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.snur206.taskmaster.dao.TaskDao;
import com.snur206.taskmaster.model.TaskModel;

// TODO Step 4-6: Enable converters
@TypeConverters({TaskMasterDatabaseConverters.class})
// TODO Step 4-5: Setup the database and make it abstract
@Database(entities = {TaskModel.class}, version = 1) // if we update the version, it will delete the db!
public abstract class TaskMasterDatabase extends RoomDatabase {
    // TODO Step 4-6: add the DAO's
    public abstract TaskDao taskDao();
}

