package com.example.employeemanagement.service;

import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UtilityService {

    private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^A-Z0-9]+");

    public String formatName(String name) {
        if (name == null || name.isBlank()) {
            return "";
        }
        String normalized = name.trim().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
        String[] words = normalized.split(" ");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            if (!formatted.isEmpty()) {
                formatted.append(' ');
            }
            formatted.append(word.substring(0, 1).toUpperCase(Locale.ROOT))
                    .append(word.substring(1));
        }
        return formatted.toString();
    }

    public String generateEmployeeCode(String fullName) {
        String normalized = Normalizer.normalize(fullName == null ? "EMP" : fullName,
                Normalizer.Form.NFD).replaceAll("\\p{M}", "").toUpperCase(Locale.ROOT);
        String initials = NON_ALPHANUMERIC.matcher(normalized).replaceAll("");
        if (initials.isBlank()) {
            initials = "EMP";
        }
        String prefix = initials.substring(0, Math.min(3, initials.length()));
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(Locale.ROOT);
    }
}
