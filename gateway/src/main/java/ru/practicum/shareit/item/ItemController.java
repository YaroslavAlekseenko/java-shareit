package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.practicum.shareit.common.Header;
import ru.practicum.shareit.item.dto.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/items")
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController {
    private final ItemClient itemClient;

    @PostMapping
    public Mono<ResponseEntity<Object>> createItem(@RequestHeader(Header.userIdHeader) @Min(1) Long userId,
                                                   @Valid @RequestBody ItemDto itemDto) {
        return itemClient.createItem(userId, itemDto);
    }

    @PatchMapping("{itemId}")
    public Mono<ResponseEntity<Object>> updateItem(@RequestHeader(Header.userIdHeader) @Min(1) Long userId,
                                                   @RequestBody ItemDtoUpdate itemDtoUpdate,
                                                   @PathVariable @Min(1) Long itemId) {
        return itemClient.updateItem(userId, itemDtoUpdate, itemId);
    }

    @GetMapping("{itemId}")
    public Mono<ResponseEntity<Object>> getItemByItemId(@RequestHeader(Header.userIdHeader) @Min(1) Long userId,
                                                        @PathVariable @Min(1) Long itemId) {
        return itemClient.getItemByItemId(userId, itemId);
    }

    @GetMapping
    public Mono<ResponseEntity<Object>> getPersonalItems(
            @RequestHeader(Header.userIdHeader) @Min(1) Long userId,
            @RequestParam(value = "from", defaultValue = "0") @Min(0) Integer from,
            @RequestParam(value = "size", defaultValue = "10") @Min(1) @Max(20) Integer size) {
        return itemClient.getPersonalItems(userId, from, size);
    }

    @GetMapping("search")
    public Mono<ResponseEntity<Object>> getFoundItems(
            @RequestHeader(Header.userIdHeader) @Min(1) Long userId,
            @RequestParam String text,
            @RequestParam(value = "from", defaultValue = "0") @Min(0) Integer from,
            @RequestParam(value = "size", defaultValue = "10") @Min(1) @Max(20) Integer size) {
        return itemClient.getFoundItems(userId, text, from, size);
    }

    @PostMapping("{itemId}/comment")
    public Mono<ResponseEntity<Object>> addComment(@PathVariable @Min(1) Long itemId,
                                                   @RequestHeader(Header.userIdHeader) @Min(1) Long userId,
                                                   @Valid @RequestBody CommentDto commentDto) {
        return itemClient.addComment(itemId, userId, commentDto);
    }

}