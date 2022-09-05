package com.todo.springtodo.services.impl;

import com.todo.springtodo.dto.ItemsDTO;
import com.todo.springtodo.entities.Item;
import com.todo.springtodo.mappers.ItemsMapper;
import com.todo.springtodo.repositories.ItemRepository;
import com.todo.springtodo.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private ItemsMapper itemsMapper;

    @Override
    @Transactional
    public void addItem(Item items) {
        logger.debug("Start method to add item");
        itemRepository.save(items);
        logger.debug("Finished method to add item");
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateItem(ItemsDTO itemDTO) {
        Item dataUpdateItem = itemsMapper.toItem(itemDTO);
        Optional<Item> updateItem = itemRepository.findById(dataUpdateItem.getId());
        if(updateItem.isPresent()){
            Item item = updateItem.get();
            item.setItemPrice(dataUpdateItem.getItemPrice());
            item.setTitle(dataUpdateItem.getTitle());
            item.setDescription(dataUpdateItem.getDescription());
            item.setCategory(dataUpdateItem.getCategory());
        }
        itemRepository.save(itemsMapper.toItem(itemDTO));
    }

    @Override
    public ItemsDTO getById(Long id) {
        Optional<Item> getItem = itemRepository.findById(id);
        logger.debug((getItem.isPresent()) ? String.format("User with this id={} exist", id) : String.format("User with this id={} don't exist", id));
        return getItem.map(item -> itemsMapper.toItemsDTO(item)).orElse(null);
    }

    @Override
    public Set<ItemsDTO> getAllItems() {
        return itemsMapper.toItemsDTOs(new HashSet<>(itemRepository.findAll()));
    }

    @Override
    public Long getId(ItemsDTO itemsDTO) {
        return itemsDTO.getId();
    }
}
