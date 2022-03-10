package ro.fasttrackit.curs21.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactions(Double minAmount, Double maxAmount) {
        if (minAmount != null || maxAmount != null) {
            minAmount = minAmount == null ? 0 : minAmount;
            maxAmount = maxAmount == null ? Double.MAX_VALUE : maxAmount;
            return repository.findByAmountBetween(minAmount, maxAmount);
        } else {
            return repository.findAll();
        }
    }

    public Optional<Transaction> replace(int id, Transaction transaction) {
     return   repository.findById(id)
                .map(existingTransaction->replaceTransaction(existingTransaction, transaction));
    }

    private Transaction replaceTransaction(Transaction existingTransaction, Transaction transaction) {
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setType(transaction.getType());
        return repository.save(existingTransaction);}

    public Optional<Transaction> patch(int id, Transaction transaction) {
        return repository.findById(id)
                .map(dbTransaction -> patchTransaction(dbTransaction, transaction));
    }
    private Transaction patchTransaction(Transaction dbTransaction, Transaction transaction) {
        if(transaction.getAmount() != 0) {
            dbTransaction.setAmount(transaction.getAmount());
        }
        if (transaction.getType() != null) {
            dbTransaction.setType(transaction.getType());
        }
        return repository.save(dbTransaction);
    }
}
