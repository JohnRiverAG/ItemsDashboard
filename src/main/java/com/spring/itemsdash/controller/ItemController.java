package com.spring.itemsdash.controller;

import com.spring.itemsdash.model.Item;
import com.spring.itemsdash.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/items") // Define el path base para todos los endpoints en este controlador
public class ItemController {

    @Autowired // Inyecta una instancia de ItemRepository
    private ItemRepository itemRepository;

    // GET /api/items - Obtener todos los items
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // GET /api/items/{id} - Obtener un item por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(ResponseEntity::ok) // Si el item existe, devuelve 200 OK con el item
                   .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // POST /api/items - Crear un nuevo item
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item); // Guarda el nuevo item en la base de datos
    }

    // PUT /api/items/{id} - Actualizar un item existente
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setItem_name(itemDetails.getItem_name());
            item.setItem_price(itemDetails.getItem_price());
            Item updatedItem = itemRepository.save(item); // Actualiza y guarda el item
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build(); // Si no se encuentra el item, devuelve 404
        }
    }

    // DELETE /api/items/{id} - Eliminar un item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id); // Elimina el item por su ID
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Si no se encuentra el item, devuelve 404
        }
    }
}

