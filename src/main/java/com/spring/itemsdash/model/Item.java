package com.spring.itemsdash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Para @Data de Lombok
import lombok.NoArgsConstructor; // Para @NoArgsConstructor de Lombok
import lombok.AllArgsConstructor; // Para @AllArgsConstructor de Lombok

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "items") // Mapea esta entidad a la tabla "items" en la base de datos
@Data // Genera getters, setters, toString, equals y hashCode automáticamente (Lombok)
@NoArgsConstructor // Genera un constructor sin argumentos (Lombok)
@AllArgsConstructor // Genera un constructor con todos los argumentos (Lombok)
public class Item {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la generación automática de ID
    private Long item_id;

    private String item_name;
    private double item_price;

    // Con Lombok, los getters y setters se generan automáticamente.
    // Si no usas Lombok, tendrías que añadirlos manualmente:
    /*
    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }
    */
}