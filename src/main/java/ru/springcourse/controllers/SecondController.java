package ru.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondController {
    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action,
                            Model model) {
        double answer = 0;
        switch (action) {
            case "multiplication":
                answer = a * b;
                break;
            case "addition":
                answer = a + b;
                break;
            case "subtraction":
                answer = a - b;
                break;
            case "division":
                answer = 1.0 * a / b;
                break;
        }

        model.addAttribute("answer", answer);

        return "second/calculator";
    }
}
