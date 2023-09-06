package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
