package Assigment1.Assigment3;

// Subsystem for account management
class AccountSystem {
    void manageAccount() {
        System.out.println("Managing account...");
    }
}

// Subsystem for loan processing
class LoanSystem {
    void processLoan() {
        System.out.println("Processing loan...");
    }
}

// Subsystem for transaction handling
class TransactionSystem {
    void makeTransaction() {
        System.out.println("Making transaction...");
    }
}

// Facade class
class BankFacade {
    private AccountSystem accountSystem;
    private LoanSystem loanSystem;
    private TransactionSystem transactionSystem;

    public BankFacade() {
        this.accountSystem = new AccountSystem();
        this.loanSystem = new LoanSystem();
        this.transactionSystem = new TransactionSystem();
    }

    public void performBankOperations() {
        accountSystem.manageAccount();
        loanSystem.processLoan();
        transactionSystem.makeTransaction();
    }
}

// Client code for Facade pattern
public class MainFacadeTask {
    public static void main(String[] args) {
        BankFacade bankFacade = new BankFacade();
        bankFacade.performBankOperations(); // Simplified access to banking operations
    }
}