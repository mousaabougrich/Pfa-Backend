package com.wallet.biochain.repositories;

import com.wallet.biochain.entities.SmartContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartContractRepository extends JpaRepository<SmartContract, Long> {
}