package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseTrackerModel {

  //encapsulation - data integrity
  private List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    // Perform input validation to guarantee that all transactions added are non-null.
    if (t == null) {
      throw new IllegalArgumentException("The new transaction must be non-null.");
    }
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  // since we'll be removing the transaction clicked based on row index
  public void removeTransaction(int index) {
    if (index >= 0 && index < transactions.size()) {
        transactions.remove(index);
    }
  }


  public List<Transaction> getTransactions() {
    //encapsulation - data integrity
    return Collections.unmodifiableList(new ArrayList<>(transactions));
  }

  // calculate total cost after removing
  public double calculateTotalCost() {
    double total = 0.0;
    for (Transaction t : transactions) {
        total += t.getAmount();
    }
    return total;
}


}
