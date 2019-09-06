package za.vendingmachine.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Snack {
	private int id;
	private String name;
	private BigDecimal price;
	private int quantity;

}
