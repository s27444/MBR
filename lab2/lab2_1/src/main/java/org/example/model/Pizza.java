package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Pizza {
    private String name;
    private double price;
    private boolean isAvailable;

}
