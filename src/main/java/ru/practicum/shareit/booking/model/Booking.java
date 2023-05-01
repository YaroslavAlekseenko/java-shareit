package ru.practicum.shareit.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Класс booking:
 * id — уникальный идентификатор бронирования;
 * start — дата и время начала бронирования;
 * end — дата и время конца бронирования;
 * item — вещь, которую пользователь бронирует;
 * booker — пользователь, который осуществляет бронирование;
 * status — статус бронирования. Может принимать одно из следующих
 * значений: WAITING — новое бронирование, ожидает одобрения,
 * APPROVED — бронирование подтверждено владельцем,
 * REJECTED — бронирование отклонено владельцем,
 * CANCELED — бронирование отменено создателем.
 */
@Entity
@Table(name = "bookings")
@Getter
@Setter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booker_id")
    private User booker;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "start_booking")
    private LocalDateTime start;

    @Column(name = "end_booking")
    private LocalDateTime end;
}