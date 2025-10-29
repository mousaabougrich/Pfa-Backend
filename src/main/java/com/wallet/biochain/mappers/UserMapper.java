package com.wallet.biochain.mappers;

import com.wallet.biochain.dto.UserDTO;
import com.wallet.biochain.dto.WalletDTO;
import com.wallet.biochain.entities.User;
import com.wallet.biochain.entities.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User entity) {
        if (entity == null) {
            return null;
        }

        List<WalletDTO> walletDTOs = entity.getWallets() != null
                ? entity.getWallets().stream()
                .map(WalletMapper::toDTO)
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new UserDTO(
                entity.getUserId(),
                entity.getEmail(),
                entity.getFullName(),
                entity.getPhoneNumber(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getIsActive(),
                walletDTOs
        );
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        List<Wallet> wallets = dto.wallets() != null
                ? dto.wallets().stream()
                .map(WalletMapper::toEntity)
                .collect(Collectors.toList())
                : new ArrayList<>();

        User user = new User();
        user.setUserId(dto.userId());
        user.setEmail(dto.email());
        user.setFullName(dto.fullName());
        user.setPhoneNumber(dto.phoneNumber());
        user.setCreatedAt(dto.createdAt());
        user.setUpdatedAt(dto.updatedAt());
        user.setIsActive(dto.isActive());
        user.setWallets(wallets);

        wallets.forEach(wallet -> wallet.setUser(user));

        return user;
    }
}