package com.wallet.biochain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record WalletDTO(
        Long walletId,
        Long userId,
        String currencyType,
        BigDecimal balance,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<TransactionDTO> sentTransactions,
        List<TransactionDTO> receivedTransactions
) {}