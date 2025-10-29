package com.wallet.biochain.Record;

import java.time.LocalDateTime;
import java.util.Map;

record ErrorResponse(
        int status,
        String message,
        Map<String, String> errors,
        LocalDateTime timestamp
) {}