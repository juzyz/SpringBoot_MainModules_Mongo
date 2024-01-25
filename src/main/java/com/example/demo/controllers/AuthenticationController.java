package com.example.demo.controllers;

import com.example.demo.jwt.JwtUtils;
import com.example.demo.config.SecurityConfig;
import com.example.demo.repositories.UserDoa;
import com.example.demo.models.AuthenticationRequest;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Import(SecurityConfig.class)
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDoa userDoa;
    private final JwtUtils jwtUtils;
//http://localhost:8080/swagger-ui/index.html
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail() , request.getPassword())
        );
        final UserDetails user = userDoa.findUserByEmail(request.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some Error has occurred.");
    }

    @Hidden
    @Operation( summary="Endpoint to check a controller accessibility",
            description = "This endpoint is added to demonstrate a work of @Hidden for OpenAPI"
    )
    @GetMapping("/say-hello")
    public ResponseEntity <String> sayHello (){
        return ResponseEntity.ok("Hello from API");
    }

}
