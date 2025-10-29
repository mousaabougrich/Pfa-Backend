package com.wallet.biochain.repositories;

import com.wallet.biochain.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}