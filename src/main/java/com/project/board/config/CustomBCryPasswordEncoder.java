package com.project.board.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomBCryPasswordEncoder extends BCryptPasswordEncoder {
}
