package com.tasklist.task_list_clean_architecture.domain.vo;

import com.tasklist.task_list_clean_architecture.domain.exception.InvalidDateException;

import java.time.LocalDate;

public class DateRange {

    private final LocalDate dateStart;

    private final LocalDate dateEnd;

    public DateRange(LocalDate dateStart, LocalDate dateEnd) {
        validateDate(dateStart, dateEnd);
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    private void validateDate(LocalDate dateStart, LocalDate dateEnd) {
        if (dateStart.isAfter(dateEnd)) {
            throw new InvalidDateException();
        }
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

}
