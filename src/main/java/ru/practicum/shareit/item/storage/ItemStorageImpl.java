package ru.practicum.shareit.item.storage;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.model.Item;

import java.util.*;

@Component
public class ItemStorageImpl implements ItemStorage {
    private Long itemId = 0L;
    private final Map<Long, Item> items = new HashMap<>();

    @Override
    public Item createItem(Item item) {
        item.setId(++itemId);
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public Item updateItem(Item item) {
        items.put(item.getId(), item);
        return items.get(item.getId());
    }

    @Override
    public Item getItem(Long id) {
        return items.get(id);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    @Override
    public void removeItem(Long id) {
        items.remove(id);
    }
}