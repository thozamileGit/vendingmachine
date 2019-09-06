package za.vendingmachine.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

import za.vendingmachine.dao.SnackDAO;
import za.vendingmachine.daoImpl.SnackDAOImpl;
import za.vendingmachine.model.Snack;
import za.vendingmachine.service.SnackService;

@Service
public class SnackServiceImpl implements SnackService {
	
	SnackDAO snackDAO = new SnackDAOImpl();

	private BigDecimal balance = new BigDecimal("0.00") ;
	private int selection;
	private BigDecimal change = new BigDecimal("0.00");
	private String message;
	

	
	@Override
	public void addMoney(String amount) {
		
		switch (amount) {
		case "oneRand":
			balance = balance.add(new BigDecimal("1.00"));
			break;
		case "twoRand":
			balance = balance.add(new BigDecimal("2.00"));
			break;
		case "fiveRand":
			balance = balance.add(new BigDecimal("5.00"));
			break;
		case "tenRand":
			balance = balance.add(new BigDecimal("10.00"));
			break;
		default:

		}

	}

	@Override
	public void makePurchase() {
		if (selection != 0) {
			// BigDecimal balance = snackService.getBalance();
			Snack snack = snackDAO.getSnackById(selection);
			BigDecimal selectionPrice = snack.getPrice();
			if (snack.getQuantity() <= 0) {
				message = "SOLD OUT!!!";
			} else if (balance.compareTo(selectionPrice) < 0) {
				BigDecimal difference = selectionPrice.subtract(balance);
				message = "Please Deposit: R" + difference;
			} else {
				BigDecimal newBalance = balance.subtract(selectionPrice);
				change = newBalance;
				balance = new BigDecimal("0.00");
				int newSnackQuantity = snack.getQuantity() - 1;
				snack.setQuantity(newSnackQuantity);
				message = "Thank You!!!";
			}
		}

	}

	@Override
	public void changeReturn() {
		balance = new BigDecimal("0.00");
		selection = 0;
		message = null;

	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public int getSelection() {
		return selection;
	}

	@Override
	public Snack getSnackById(int id) {
		return snackDAO.getSnackById(id);
	}

	@Override
	public List<Snack> getSnacks() {
		return snackDAO.getSnacks();
	}

	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setSelection(int selection) {
		this.selection = selection;

	}

	@Override
	public BigDecimal getChange() {
		return change;
	}

	@Override
	public void setChange(BigDecimal change) {
		this.change = change;

	}
	
}
