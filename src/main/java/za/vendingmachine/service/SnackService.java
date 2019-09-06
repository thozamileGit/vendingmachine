package za.vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;

import za.vendingmachine.model.Snack;

public interface SnackService {

	public void addMoney(String amount);

	public void makePurchase();

	public void changeReturn();

	BigDecimal getBalance();

	BigDecimal getChange();

	String getMessage();

	int getSelection();

	Snack getSnackById(int id);

	List<Snack> getSnacks();

	void setBalance(BigDecimal balance);

	void setMessage(String message);

	void setSelection(int selection);

	void setChange(BigDecimal change);

}
