package ru.practicum.shareit.request.model;

import lombok.Data;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

/**
 * Класс ItemRequest:
 * id — уникальный идентификатор запроса;
 * description — текст запроса, содержащий описание требуемой вещи;
 * requester — пользователь, создавший запрос;
 * created — дата и время создания запроса.
 */
@Data
public class ItemRequest {
    private int id;
    private String description;
    private User requester;
    private LocalDateTime created;
}
