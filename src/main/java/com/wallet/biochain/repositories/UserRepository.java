package com.wallet.biochain.repositories;

import com.wallet.biochain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}