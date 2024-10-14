package Assigment1.Assigment3;

// Interface for bank accounts
interface BankAccount {
    void accessAccount();
}

// Real bank account object
class RealBankAccount implements BankAccount {
    private String accountHolder;

    public RealBankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void accessAccount() {
        System.out.println("Accessing bank account of: " + accountHolder);
    }
}

// Proxy class
class BankAccountProxy implements BankAccount {
    private RealBankAccount realAccount;
    private String accountHolder;

    public BankAccountProxy(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void accessAccount() {
        if (authenticate()) {
            if (realAccount == null) {
                realAccount = new RealBankAccount(accountHolder);
            }
            realAccount.accessAccount();
        } else {
            System.out.println("Access denied for: " + accountHolder);
        }
    }

    private boolean authenticate() {
        // Simple authentication logic for demo purposes
        return "authorizedUser".equals(accountHolder);
    }
}

// Client code for Proxy Pattern
public class MainProxyTask {
    public static void main(String[] args) {
        // Creating an authorized user proxy
        BankAccount authorizedAccount = new BankAccountProxy("authorizedUser");
        authorizedAccount.accessAccount(); // Access granted

        // Creating an unauthorized user proxy
        BankAccount unauthorizedAccount = new BankAccountProxy("unauthorizedUser");
        unauthorizedAccount.accessAccount(); // Access denied
    }
}