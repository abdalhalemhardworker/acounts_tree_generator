package app.acounts_tree;

import java.util.ArrayList;
import java.util.List;

enum AccountType {
    Root,
    Branch,
    Leaf
}

public class Account {

    private String name;
    private String code;
    private int level;
    private AccountType type;
    private Account parent;
    private List<Account> children = new ArrayList<>();
    private int parentIndex;

    public void init(String name, String code, int level, AccountType type, Account parent, int parentIndex) {
        setName(name);
        setLevel(level);
        setType(type);
        setParent(parent);
        this.parentIndex = parentIndex;
        this.code = "";
        genCode();
    }

    public Account(String name, int level, int parentIndex, AccountType type, Account parent) {
        init(name, "", level, type, parent, parentIndex);
    }

    public Account(String name, int level, int parentIndex, AccountType type) {
        init(name, "", level, type, null, parentIndex);
    }

    public Account(String name, int level, AccountType type, Account parent) {
        init(name, "", level, type, parent, 0);
    }

    public Account(String name, int level, AccountType type) {
        init(name, "", level, type, null, 0);
    }

    public Account(String name, AccountType type) {
        init(name, "", 0, type, null, 0);
    }

    public Account(String name, String code, int level, int parentIndex, AccountType type, Account parent) {
        init(name, code, level, type, parent, parentIndex);
    }

    public Account(String name, String code, int level, int parentIndex, AccountType type) {
        init(name, code, level, type, null, parentIndex);
    }

    public boolean addChild(Account newAccount) {
        newAccount.setParent(this);
        newAccount.setParentIndex(children.size() + 1);
        newAccount.setLevel(this.getLevel() + 1);
        newAccount.genCode();
        return children.add(newAccount);
    }

    public List<Account> getChildren() {
        return children;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    public void setChildren(List<Account> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void genCode() {
        String code = this.parentIndex + "";
        Account currentAccount = this;
        while (currentAccount.parent != null) {
            currentAccount = currentAccount.parent;
            code += currentAccount.parentIndex;
        }

        this.code = "";
        for (int i = code.length() - 1; i >= 0; i--) {
            this.code += code.charAt(i);
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Account getParent() {
        return parent;
    }

    public void setParent(Account parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {

        String account = "name : " + getName() + " code : " + getCode() + " level : " + getLevel() + " type : " + getType();

//        if (parent == null) {
//
//        } else {
//
//        }
        return account;
    }
}
