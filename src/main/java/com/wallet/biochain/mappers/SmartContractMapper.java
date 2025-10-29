package com.wallet.biochain.mappers;

import com.wallet.biochain.dto.SmartContractDTO;
import com.wallet.biochain.dto.TransactionDTO;
import com.wallet.biochain.entities.SmartContract;
import com.wallet.biochain.entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmartContractMapper {

    public static SmartContractDTO toDTO(SmartContract entity) {
        if (entity == null) {
            return null;
        }

        List<TransactionDTO> transactionDTOs = entity.getTransactions() != null
                ? entity.getTransactions().stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new SmartContractDTO(
                entity.getContractId(),
                entity.getContractAddress(),
                entity.getCurrencyType(),
                entity.getDeployedAt(),
                entity.getStatus(),
                transactionDTOs
        );
    }

    public static SmartContract toEntity(SmartContractDTO dto) {
        if (dto == null) {
            return null;
        }

        List<Transaction> transactions = dto.transactions() != null
                ? dto.transactions().stream()
                .map(TransactionMapper::toEntity)
                .collect(Collectors.toList())
                : new ArrayList<>();

        SmartContract smartContract = new SmartContract();
        smartContract.setContractId(dto.contractId());
        smartContract.setContractAddress(dto.contractAddress());
        smartContract.setCurrencyType(dto.currencyType());
        smartContract.setDeployedAt(dto.deployedAt());
        smartContract.setStatus(dto.status());
        smartContract.setTransactions(transactions);

        transactions.forEach(transaction -> transaction.setSmartContract(smartContract));

        return smartContract;
    }
}