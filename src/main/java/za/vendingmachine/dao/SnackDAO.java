package za.vendingmachine.dao;

import java.util.List;

import za.vendingmachine.model.Snack;

public interface SnackDAO {
	public Snack getSnackById(int id);
    public List<Snack> getSnacks();
}
