package com.wallet.biochain.dto;

import com.wallet.biochain.enums.TransactionStatus;
import com.wallet.biochain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        Long transactionId,
        Long senderWalletId,
        Long receiverWalletId,
        String externalAddress,
        BigDecimal amount,
        String currencyType,
        TransactionType transactionType,
        TransactionStatus status,
        String blockchainTxHash,
        LocalDateTime createdAt,
        Double fraudScore,
        Long smartContractId
) {}
