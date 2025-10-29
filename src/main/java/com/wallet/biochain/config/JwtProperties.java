package com.wallet.biochain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private RsaKeyProperties rsa = new RsaKeyProperties();
    private Long accessTokenExpiration;
    private Long refreshTokenExpiration;

    @Data
    public static class RsaKeyProperties {
        private Resource privateKey;
        private Resource publicKey;
    }
}