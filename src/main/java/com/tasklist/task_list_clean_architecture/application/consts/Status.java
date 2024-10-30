package com.tasklist.task_list_clean_architecture.application.consts;

public enum Status {

    TODO("Todo"),

    IN_PROGRESS("InProgress"),

    DONE("Done");

    private final String statusType;

    Status(String statusType) {
        this.statusType = statusType;
    }

    public String getStatus() {
        return statusType;
    }

    public static Status fromString(String statusType) {
        for (Status status : Status.values()) {
            if (status.statusType.equalsIgnoreCase(statusType)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status type: " + statusType);
    }

}
