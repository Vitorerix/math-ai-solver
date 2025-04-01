package com.example.mathsolver.controller;

import com.example.mathsolver.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/translations")
    public ResponseEntity<Map<String, String>> getTranslations(@RequestParam String language) {
        Map<String, String> translations = new HashMap<>();
        String[] keys = {
            "title", "enterProblem", "example", "supportedOps", "solve",
            "solution", "yourProblem", "answer", "solveAnother"
        };
        
        for (String key : keys) {
            translations.put(key, languageService.getTranslation(key, language));
        }
        
        return ResponseEntity.ok(translations);
    }
} 