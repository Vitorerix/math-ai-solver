package com.example.mathsolver.service;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MathSolverService {

    public String solve(String problem) {
        // Remove spaces and convert to lowercase
        problem = problem.replaceAll("\\s+", "").toLowerCase();
        
        // Check for Bhaskara's formula (ax² + bx + c = 0)
        if (problem.contains("x²") || problem.contains("x^2")) {
            return solveBhaskara(problem);
        }
        
        // Check for percentage calculations
        if (problem.contains("%")) {
            return solvePercentage(problem);
        }
        
        // Basic arithmetic operations
        return solveBasicArithmetic(problem);
    }

    private String solveBhaskara(String problem) {
        try {
            // Extract coefficients using regex
            Pattern pattern = Pattern.compile("([+-]?\\d*)x²\\s*([+-]?\\d*)x\\s*([+-]?\\d*)");
            Matcher matcher = pattern.matcher(problem);
            
            if (!matcher.find()) {
                return "Invalid quadratic equation format. Use: ax² + bx + c";
            }
            
            // Parse coefficients
            double a = parseCoefficient(matcher.group(1));
            double b = parseCoefficient(matcher.group(2));
            double c = parseCoefficient(matcher.group(3));
            
            // Calculate discriminant
            double discriminant = b * b - 4 * a * c;
            
            if (discriminant < 0) {
                return "No real solutions (discriminant < 0)";
            }
            
            // Calculate roots
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            
            return String.format("x₁ = %.2f, x₂ = %.2f", x1, x2);
        } catch (Exception e) {
            return "Error solving quadratic equation. Please check the format.";
        }
    }

    private String solvePercentage(String problem) {
        try {
            // Remove spaces
            problem = problem.replaceAll("\\s+", "");
            
            // Check for different percentage operations
            if (problem.contains("of")) {
                // Calculate percentage of a number (e.g., 20% of 150)
                String[] parts = problem.split("of");
                double percentage = Double.parseDouble(parts[0].replace("%", ""));
                double number = Double.parseDouble(parts[1]);
                double result = (percentage / 100) * number;
                return String.format("%.2f%% of %.2f = %.2f", percentage, number, result);
            } else if (problem.contains("+") || problem.contains("-")) {
                // Add or subtract percentage (e.g., 150 + 20%)
                String[] parts = problem.split("(?=[+-])");
                double number = Double.parseDouble(parts[0]);
                double percentage = Double.parseDouble(parts[1].replace("%", ""));
                double result = number + (number * (percentage / 100));
                return String.format("%.2f %s %.2f%% = %.2f", number, parts[1].startsWith("+") ? "+" : "-", percentage, result);
            } else {
                // Convert decimal to percentage (e.g., 0.5%)
                double decimal = Double.parseDouble(problem.replace("%", ""));
                double percentage = decimal * 100;
                return String.format("%.2f%% = %.2f", decimal, percentage);
            }
        } catch (Exception e) {
            return "Error calculating percentage. Please check the format.";
        }
    }

    private String solveBasicArithmetic(String problem) {
        try {
            // Split the problem into numbers and operators
            String[] numbers = problem.split("[+\\-*/]");
            String[] operators = problem.split("\\d+");
            
            // Remove empty strings and convert numbers
            double result = Double.parseDouble(numbers[0]);
            for (int i = 1; i < numbers.length; i++) {
                double num = Double.parseDouble(numbers[i]);
                String operator = operators[i];
                
                switch (operator) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        if (num == 0) {
                            return "Error: Division by zero";
                        }
                        result /= num;
                        break;
                }
            }
            
            return String.format("%.2f", result);
        } catch (Exception e) {
            return "Error: Invalid expression";
        }
    }

    private double parseCoefficient(String coeff) {
        if (coeff == null || coeff.isEmpty()) {
            return 1;
        }
        if (coeff.equals("+")) {
            return 1;
        }
        if (coeff.equals("-")) {
            return -1;
        }
        return Double.parseDouble(coeff);
    }
} 