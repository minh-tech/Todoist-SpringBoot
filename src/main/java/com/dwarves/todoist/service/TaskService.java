package com.dwarves.todoist.service;

import com.dwarves.todoist.Utils.Constant;
import com.dwarves.todoist.dao.TaskDao;
import com.dwarves.todoist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public int assignUsers(List<Integer> assignee_Ids, int todoId) throws DuplicateKeyException {
        return taskDao.assignUsers(assignee_Ids, todoId);
    }

    public int updateAssignment(Task task) {
        return taskDao.updateAssignment(task);
    }

    public List<Map<String, Object>> getAllAssignments() {
        Deque<Task> tasks_deque = new ArrayDeque<>(taskDao.getAllAssignments());

        Map<Integer, List<Task>> hashMap = new HashMap<>();

        while (!tasks_deque.isEmpty()) {
            Task t = tasks_deque.pop();
            if (hashMap.containsKey(t.getTodoId())) {
                hashMap.get(t.getTodoId()).add(new Task(t.getAssigneeId(), t.getComment()));
            } else {
                List<Task> lst = new ArrayList<>();
                lst.add(new Task(t.getAssigneeId(), t.getComment()));
                hashMap.put(t.getTodoId(), lst);
            }
        }

        List<Map<String, Object>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Task>> mapElement : hashMap.entrySet()) {
            int key = mapElement.getKey();
            List<Task> value = mapElement.getValue();

            Map<String, Object> hm = new HashMap<>();
            hm.put(Constant.TODOID, key);
            hm.put(Constant.TASKS, value);
            res.add(hm);
        }

        return res;
    }
}
