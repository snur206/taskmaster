package com.snur206.taskmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snur206.taskmaster.R;
import com.snur206.taskmaster.activities.TaskDetails;
import com.snur206.taskmaster.model.TaskModel;

import java.util.List;

// TODO: Step 1-4: Make a class whose sole purpose is to manage RecyclerViews: a RecyclerView.Adapter
public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder> {
    public static final String TASK_TITLE_TAG = "task_title";
    public static final String TASK_BODY_TAG = "task_body";

    // TODO: Step 3-2: Context callingActivity called at the top
    Context callingActivity;

    // TODO: Step 2-3: Hand in some data items
    List<TaskModel> taskModelsList;
    // TODO: Step 3-3: Change the constructor to:
    public TaskRecyclerViewAdapter(List<TaskModel> taskModelsList, Context callingActivity) {
        this.taskModelsList = taskModelsList;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    // TODO: Step 1-7: Inflate fragment
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task_fragments, parent, false);
        // TODO: Step 1-9: Attach Fragment to ViewHolder
        return new TaskViewHolder(taskFragment);
    }

    @Override
    // TODO: Step 2-4: Bind data items to Fragments inside of ViewHolders
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TextView taskFragNameView = holder.itemView.findViewById(R.id.TaskFragmentTextViewName);
        // TODO: Step 6-2: Refactor the rendering
        TaskModel taskTitle = taskModelsList.get(position);
        taskFragNameView.setText((position + 1) + ". " + taskTitle.getTitle()
        + "/n" + taskTitle.getDescription() + "/n" + taskTitle.getDate()
        );
        View taskViewHolder = holder.itemView;
        taskViewHolder.setOnClickListener(v -> {
            Intent goToTaskDetailsIntent = new Intent(callingActivity, TaskDetails.class);
            goToTaskDetailsIntent.putExtra(TASK_TITLE_TAG, taskTitle.getTitle());
//            goToTaskDetailsIntent.putExtra(TASK_BODY_TAG, taskBodyList);
            callingActivity.startActivity(goToTaskDetailsIntent);
        });
    }

    @Override
    public int getItemCount() {
        // TODO: 2-5: Make the size of the list dynamic
        return taskModelsList.size();
    }

    // TODO: Step 1-8: Make a viewHolder class to hold a Fragment
    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
