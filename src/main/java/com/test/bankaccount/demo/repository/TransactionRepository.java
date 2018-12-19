package com.test.bankaccount.demo.repository;

import com.test.bankaccount.demo.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransaction, Long> {

    List<AccountTransaction> findByAccountId(Long accountId);

}
