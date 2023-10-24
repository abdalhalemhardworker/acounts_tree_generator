package app.acounts_tree;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Account> mainAccounts = new ArrayList<>();

        mainAccounts.add(new Account("assets", 1, 1, AccountType.Root));
        mainAccounts.get(0).addChild(new Account("assets1", AccountType.Branch));
        mainAccounts.get(0).addChild(new Account("assets2", AccountType.Branch));
        mainAccounts.get(0).addChild(new Account("assets3", AccountType.Branch));
        mainAccounts.get(0).addChild(new Account("assets4", AccountType.Branch));

        mainAccounts.add(new Account("rights", 1, 2, AccountType.Root));
        mainAccounts.get(1).addChild(new Account("rights1", AccountType.Branch));
        mainAccounts.get(1).addChild(new Account("rights2", AccountType.Branch));
        mainAccounts.get(1).addChild(new Account("rights3", AccountType.Branch));
        mainAccounts.get(1).addChild(new Account("rights4", AccountType.Branch));

        mainAccounts.add(new Account("expenses", 1, 3, AccountType.Root));
        
        mainAccounts.add(new Account("resevables", 1, 4, AccountType.Root));
        
        for (Account account : mainAccounts) {
            System.out.println(account);
            for (Account childAccount : account.getChildren()) {
                System.out.println("\t" + childAccount);
            }
        }
    }

}
