package com.example.mathsolver.service;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MathSolverService {

    public String solveProblem(String problem) {
        // Basic arithmetic operations
        if (problem.contains("+")) {
            return solveAddition(problem);
        } else if (problem.contains("-")) {
            return solveSubtraction(problem);
        } else if (problem.contains("*")) {
            return solveMultiplication(problem);
        } else if (problem.contains("/")) {
            return solveDivision(problem);
        }
        
        return "I couldn't understand the problem. Please try again with basic arithmetic operations (+, -, *, /).";
    }

    private String solveAddition(String problem) {
        String[] numbers = problem.split("\\+");
        double result = 0;
        for (String num : numbers) {
            result += Double.parseDouble(num.trim());
        }
        return String.format("%.2f", result);
    }

    private String solveSubtraction(String problem) {
        String[] numbers = problem.split("-");
        double result = Double.parseDouble(numbers[0].trim());
        for (int i = 1; i < numbers.length; i++) {
            result -= Double.parseDouble(numbers[i].trim());
        }
        return String.format("%.2f", result);
    }

    private String solveMultiplication(String problem) {
        String[] numbers = problem.split("\\*");
        double result = 1;
        for (String num : numbers) {
            result *= Double.parseDouble(num.trim());
        }
        return String.format("%.2f", result);
    }

    private String solveDivision(String problem) {
        String[] numbers = problem.split("/");
        double result = Double.parseDouble(numbers[0].trim());
        for (int i = 1; i < numbers.length; i++) {
            double divisor = Double.parseDouble(numbers[i].trim());
            if (divisor == 0) {
                return "Error: Division by zero is not allowed.";
            }
            result /= divisor;
        }
        return String.format("%.2f", result);
    }
} 