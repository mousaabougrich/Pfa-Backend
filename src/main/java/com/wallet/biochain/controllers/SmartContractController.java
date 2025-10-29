package com.wallet.biochain.controllers;

import com.wallet.biochain.services.SmartContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/smart-contracts")
@RequiredArgsConstructor
public class SmartContractController {

    private final SmartContractService smartContractService;
}