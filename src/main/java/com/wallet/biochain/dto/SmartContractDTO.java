package com.wallet.biochain.dto;

import com.wallet.biochain.enums.ContractStatus;

import java.time.LocalDateTime;
import java.util.List;

public record SmartContractDTO(
        Long contractId,
        String contractAddress,
        String currencyType,
        LocalDateTime deployedAt,
        ContractStatus status,
        List<TransactionDTO> transactions
) {}