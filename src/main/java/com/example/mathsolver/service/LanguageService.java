package com.example.mathsolver.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;

@Service
public class LanguageService {
    private final Map<String, Map<String, String>> translations;

    public LanguageService() {
        translations = new HashMap<>();
        
        // English translations
        Map<String, String> enTranslations = new HashMap<>();
        enTranslations.put("title", "Math AI Solver");
        enTranslations.put("enterProblem", "Enter your math problem:");
        enTranslations.put("example", "Example: 5 + 3 * 2");
        enTranslations.put("supportedOps", "Supported operations: +, -, *, /");
        enTranslations.put("solve", "Solve");
        enTranslations.put("solution", "Solution");
        enTranslations.put("yourProblem", "Your Problem:");
        enTranslations.put("answer", "Answer:");
        enTranslations.put("solveAnother", "Solve Another Problem");
        translations.put("en", enTranslations);

        // Portuguese translations
        Map<String, String> ptTranslations = new HashMap<>();
        ptTranslations.put("title", "Resolvedor de Matemática IA");
        ptTranslations.put("enterProblem", "Digite seu problema matemático:");
        ptTranslations.put("example", "Exemplo: 5 + 3 * 2");
        ptTranslations.put("supportedOps", "Operações suportadas: +, -, *, /");
        ptTranslations.put("solve", "Resolver");
        ptTranslations.put("solution", "Solução");
        ptTranslations.put("yourProblem", "Seu Problema:");
        ptTranslations.put("answer", "Resposta:");
        ptTranslations.put("solveAnother", "Resolver Outro Problema");
        translations.put("pt", ptTranslations);

        // Spanish translations
        Map<String, String> esTranslations = new HashMap<>();
        esTranslations.put("title", "Resolvedor de Matemáticas IA");
        esTranslations.put("enterProblem", "Ingrese su problema matemático:");
        esTranslations.put("example", "Ejemplo: 5 + 3 * 2");
        esTranslations.put("supportedOps", "Operaciones soportadas: +, -, *, /");
        esTranslations.put("solve", "Resolver");
        esTranslations.put("solution", "Solución");
        esTranslations.put("yourProblem", "Su Problema:");
        esTranslations.put("answer", "Respuesta:");
        esTranslations.put("solveAnother", "Resolver Otro Problema");
        translations.put("es", esTranslations);

        // French translations
        Map<String, String> frTranslations = new HashMap<>();
        frTranslations.put("title", "Résolveur de Mathématiques IA");
        frTranslations.put("enterProblem", "Entrez votre problème mathématique:");
        frTranslations.put("example", "Exemple: 5 + 3 * 2");
        frTranslations.put("supportedOps", "Opérations supportées: +, -, *, /");
        frTranslations.put("solve", "Résoudre");
        frTranslations.put("solution", "Solution");
        frTranslations.put("yourProblem", "Votre Problème:");
        frTranslations.put("answer", "Réponse:");
        frTranslations.put("solveAnother", "Résoudre un Autre Problème");
        translations.put("fr", frTranslations);
    }

    public String getTranslation(String key, String language) {
        Map<String, String> languageTranslations = translations.getOrDefault(language, translations.get("en"));
        return languageTranslations.getOrDefault(key, key);
    }
} 