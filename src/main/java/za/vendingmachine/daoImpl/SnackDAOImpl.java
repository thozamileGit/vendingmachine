package za.vendingmachine.daoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import za.vendingmachine.dao.SnackDAO;
import za.vendingmachine.model.Snack;

public class SnackDAOImpl implements SnackDAO {
	
	 HashMap<Integer, Snack> snacks;

	public SnackDAOImpl() {
		snacks = new HashMap<>();
		snacks.put(1, new Snack(1, "Simba", new BigDecimal("2.00"), 1));
		snacks.put(2, new Snack(2, "Coke", new BigDecimal("10.50"), 9));
		snacks.put(3, new Snack(3, "Lunch Bar", new BigDecimal("3.10"), 2));
		snacks.put(4, new Snack(4, "Sprite", new BigDecimal("10.85"), 5));
		snacks.put(5, new Snack(5, "Coke Light", new BigDecimal("10.85"), 4));
		snacks.put(6, new Snack(6, "Sprite Zero", new BigDecimal("11.00"), 0));
		snacks.put(7, new Snack(7, "Doritos", new BigDecimal("2.75"), 3));
		snacks.put(8, new Snack(8, "Still Water", new BigDecimal("6.85"), 11));
		snacks.put(9, new Snack(9, "Lemon Twist", new BigDecimal("10.95"), 1));
	}

	@Override
	public Snack getSnackById(int id) {
		return snacks.get(id);
	}

	@Override
	public List<Snack> getSnacks() {
		return new ArrayList<>(snacks.values());
	}

}
