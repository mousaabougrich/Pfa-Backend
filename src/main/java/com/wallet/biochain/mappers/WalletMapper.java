package com.wallet.biochain.mappers;

import com.wallet.biochain.dto.WalletDTO;
import com.wallet.biochain.dto.TransactionDTO;
import com.wallet.biochain.entities.Wallet;
import com.wallet.biochain.entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WalletMapper {

    public static WalletDTO toDTO(Wallet entity) {
        if (entity == null) {
            return null;
        }

        List<TransactionDTO> sentTransactionDTOs = entity.getSentTransactions() != null
                ? entity.getSentTransactions().stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList())
                : new ArrayList<>();

        List<TransactionDTO> receivedTransactionDTOs = entity.getReceivedTransactions() != null
                ? entity.getReceivedTransactions().stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new WalletDTO(
                entity.getWalletId(),
                entity.getUser() != null ? entity.getUser().getUserId() : null,
                entity.getCurrencyType(),
                entity.getBalance(),
                entity.getAddress(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                sentTransactionDTOs,
                receivedTransactionDTOs
        );
    }

    public static Wallet toEntity(WalletDTO dto) {
        if (dto == null) {
            return null;
        }

        List<Transaction> sentTransactions = dto.sentTransactions() != null
                ? dto.sentTransactions().stream()
                .map(TransactionMapper::toEntity)
                .collect(Collectors.toList())
                : new ArrayList<>();

        List<Transaction> receivedTransactions = dto.receivedTransactions() != null
                ? dto.receivedTransactions().stream()
                .map(TransactionMapper::toEntity)
                .collect(Collectors.toList())
                : new ArrayList<>();

        Wallet wallet = new Wallet();
        wallet.setWalletId(dto.walletId());
        wallet.setCurrencyType(dto.currencyType());
        wallet.setBalance(dto.balance());
        wallet.setAddress(dto.address());
        wallet.setCreatedAt(dto.createdAt());
        wallet.setUpdatedAt(dto.updatedAt());
        wallet.setSentTransactions(sentTransactions);
        wallet.setReceivedTransactions(receivedTransactions);

        sentTransactions.forEach(transaction -> transaction.setSenderWallet(wallet));
        receivedTransactions.forEach(transaction -> transaction.setReceiverWallet(wallet));

        return wallet;
    }
}