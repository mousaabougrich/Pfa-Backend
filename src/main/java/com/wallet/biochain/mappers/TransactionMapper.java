package com.wallet.biochain.mappers;

import com.wallet.biochain.dto.TransactionDTO;
import com.wallet.biochain.entities.Transaction;

public class TransactionMapper {

    public static TransactionDTO toDTO(Transaction entity) {
        if (entity == null) {
            return null;
        }

        return new TransactionDTO(
                entity.getTransactionId(),
                entity.getSenderWallet() != null ? entity.getSenderWallet().getWalletId() : null,
                entity.getReceiverWallet() != null ? entity.getReceiverWallet().getWalletId() : null,
                entity.getExternalAddress(),
                entity.getAmount(),
                entity.getCurrencyType(),
                entity.getTransactionType(),
                entity.getStatus(),
                entity.getBlockchainTxHash(),
                entity.getCreatedAt(),
                entity.getFraudScore(),
                entity.getSmartContract() != null ? entity.getSmartContract().getContractId() : null
        );
    }

    public static Transaction toEntity(TransactionDTO dto) {
        if (dto == null) {
            return null;
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionId(dto.transactionId());
        transaction.setExternalAddress(dto.externalAddress());
        transaction.setAmount(dto.amount());
        transaction.setCurrencyType(dto.currencyType());
        transaction.setTransactionType(dto.transactionType());
        transaction.setStatus(dto.status());
        transaction.setBlockchainTxHash(dto.blockchainTxHash());
        transaction.setCreatedAt(dto.createdAt());
        transaction.setFraudScore(dto.fraudScore());

        return transaction;
    }
}