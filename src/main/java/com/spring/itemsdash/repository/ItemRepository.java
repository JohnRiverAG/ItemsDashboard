package com.spring.itemsdash.repository;

import com.spring.itemsdash.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository no es estrictamente necesario aquí ya que JpaRepository ya es un componente de Spring,
// pero es una buena práctica para indicar su propósito.
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // JpaRepository proporciona automáticamente métodos CRUD (Crear, Leer, Actualizar, Borrar)
    // como save(), findById(), findAll(), deleteById(), etc.
    // Puedes añadir métodos personalizados si necesitas consultas específicas, por ejemplo:
    // List<Item> findByItemNameContaining(String name);
}

