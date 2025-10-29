package com.wallet.biochain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record UserDTO(
        Long userId,
        String email,
        String fullName,
        String phoneNumber,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean isActive,
        List<WalletDTO> wallets
) {}