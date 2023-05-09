package ru.practicum.shareit.exception;

public class DataExistException extends RuntimeException {
            public DataExistException(String type, Long id) {
            super("Не найден " + type + " c ID = " + id);
        }

}