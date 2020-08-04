package com.dwarves.todoist.Utils;

import org.springframework.http.HttpStatus;

public enum TodoStatus {
    OPEN(0, "open"),
    COMP(1, "complete"),
    LATE(2, "late"),
    CLOSE(3, "close");

    private final int value;
    private final String statusPhrase;


    TodoStatus(int value, String statusPhrase) {
        this.value = value;
        this.statusPhrase = statusPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public static TodoStatus resolve(String status_Str) {
        TodoStatus[] statuses = values();
        int length = statuses.length;

        for(int i = 0; i < length; ++i) {
            TodoStatus status = statuses[i];
            if (status.statusPhrase.equalsIgnoreCase(status_Str)) {
                return status;
            }
        }

        return null;
    }
}
