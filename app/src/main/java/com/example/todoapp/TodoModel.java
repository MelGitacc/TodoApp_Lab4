/**
 * Created by Mel on 21/11/2017.
 */
package com.example.todoapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class TodoModel {

    private static TodoModel sTodoModel;

    private ArrayList<com.example.todoapp.Todo> mTodoList;

    public static TodoModel get(Context context) {
        if (sTodoModel == null) {
            sTodoModel = new TodoModel(context);
        }
        return sTodoModel;
    }

    private TodoModel(Context context){
        mTodoList = new ArrayList<>();

        // refactor to pattern for data plugins
        // simulate some data for testing

        for (int i=0; i < 3; i++){
            com.example.todoapp.Todo todo = new com.example.todoapp.Todo();
            todo.setTitle("Todo title " + i);
            todo.setDetail("Detail for task " + todo.getId().toString());
            todo.setComplete(false);

            mTodoList.add(todo);
        }

    }

    public com.example.todoapp.Todo getTodo(UUID todoId) {

        for (com.example.todoapp.Todo todo : mTodoList) {
            if (todo.getId().equals(todoId)){
                return todo;
            }
        }

        return null;
    }

    public ArrayList<com.example.todoapp.Todo> getTodos() {

        return mTodoList;

    }

    public void addTodo(com.example.todoapp.Todo todo){

        mTodoList.add(todo);

    }

}