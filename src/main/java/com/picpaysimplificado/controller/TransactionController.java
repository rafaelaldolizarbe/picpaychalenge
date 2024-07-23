package com.picpaysimplificado.controller;

import com.picpaysimplificado.domain.dto.TransactionDto;
import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.service.TransactionService;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    @Transactional
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transaction) throws Exception{
        Transaction newTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
