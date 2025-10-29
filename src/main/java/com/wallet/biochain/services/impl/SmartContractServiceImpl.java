package com.wallet.biochain.services.impl;

import com.wallet.biochain.repositories.SmartContractRepository;
import com.wallet.biochain.services.SmartContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmartContractServiceImpl implements SmartContractService {

    private final SmartContractRepository smartContractRepository;
}