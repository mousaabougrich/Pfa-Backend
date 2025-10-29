package com.wallet.biochain.controllers;

import com.wallet.biochain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
//// hadi ri l test ok
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Test endpoint to verify JWT is working
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentUser(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "✅ JWT Authentication is working!");
        response.put("authenticatedUser", authentication.getName());
        response.put("authorities", authentication.getAuthorities());
        response.put("timestamp", System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }

    // Alternative using @AuthenticationPrincipal
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile(
            @AuthenticationPrincipal UserDetails userDetails) {

        Map<String, Object> response = new HashMap<>();
        response.put("username", userDetails.getUsername());
        response.put("authorities", userDetails.getAuthorities());
        response.put("accountNonExpired", userDetails.isAccountNonExpired());
        response.put("accountNonLocked", userDetails.isAccountNonLocked());
        response.put("credentialsNonExpired", userDetails.isCredentialsNonExpired());
        response.put("enabled", userDetails.isEnabled());

        return ResponseEntity.ok(response);
    }

    // Simple test endpoint
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("🎉 Protected endpoint accessed successfully!");
    }

    // Get all users (basic implementation)
    @GetMapping
    public ResponseEntity<Map<String, String>> getAllUsers() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User list endpoint");
        response.put("info", "Implement UserService.getAllUsers() to return actual users");
        return ResponseEntity.ok(response);
    }
}