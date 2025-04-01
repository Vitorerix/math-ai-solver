package com.example.mathsolver.controller;

import com.example.mathsolver.service.MathSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathSolverController {

    @Autowired
    private MathSolverService mathSolverService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/solve")
    public String solve(@RequestParam String problem, Model model) {
        String solution = mathSolverService.solve(problem);
        model.addAttribute("problem", problem);
        model.addAttribute("solution", solution);
        return "result";
    }
} 