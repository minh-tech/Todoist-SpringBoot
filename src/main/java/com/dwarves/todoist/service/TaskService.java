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

    public List<Object> getAllAssignments() {

        Map<Integer, List<Object>> hashMap = new HashMap<>();
        TaskService.convertListToMap(
                taskDao.getAllAssignments(),
                hashMap,
                Constant.ASSIGNEE_ID, Constant.COMMENT);

        List<Object> res = new ArrayList<>();
        TaskService.convertMapToList(hashMap, res);

        return res;
    }

    private static void convertListToMap(
            List<Task> list,
            Map<Integer, List<Object>> hashMap,
            String... strings) {

        Deque<Task> tasks_deque = new ArrayDeque<>(list);
        while (!tasks_deque.isEmpty()) {
            Task t = tasks_deque.pop();

            if (!hashMap.containsKey(t.getTodoId())) {
                List<Object> lst = new ArrayList<>();
                hashMap.put(t.getTodoId(), lst);
            }

            Map<String, Object> map = new HashMap<>();
            // TODO: Get Task properties by string so map can be put dynamically
            map.put(strings[0], t.getAssigneeId());
            map.put(strings[1], t.getComment());
            hashMap.get(t.getTodoId()).add(map);
        }
    }

    private static void convertMapToList(
            Map<Integer, List<Object>> map,
            List<Object> res) {
        for (Map.Entry<Integer, List<Object>> mapElement : map.entrySet()) {
            int key = mapElement.getKey();
            List<Object> value = mapElement.getValue();

            Map<String, Object> hm = new HashMap<>();
            hm.put(Constant.TODOID, key);
            hm.put(Constant.TASKS, value);
            res.add(hm);
        }
    }
}
