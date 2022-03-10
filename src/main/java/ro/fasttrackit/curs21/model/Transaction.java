package ro.fasttrackit.curs21.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private TransactionType type;
    private double amount;

    @OneToOne
    private Approval approval;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Note> notes;

    @ManyToOne
    private Account account;

    @ManyToMany
    private List<Category> categories;

    public Transaction() {
    }

    public Transaction(String name, TransactionType type, double amount) {
        this(null,name, type, amount);
    }

    public Transaction(Account account, String name, TransactionType type, double amount) {
        this(account, name, type, amount, null);
    }

    public Transaction(Account account, String name, TransactionType type, double amount, Approval approval) {
        this(account, name, type, amount, approval, List.of());
    }

    public Transaction(Account account, String name, TransactionType type, double amount, Approval approval, List<Note> notes) {
        this(account, name, type, amount, approval, notes, List.of());
    }

    public Transaction(Account account, String name, TransactionType type, double amount, Approval approval, List<Note> notes, List<Category> categories) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.approval = approval;
        this.notes = notes;
        this.account = account;
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Account getAccount() {
        return account;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
