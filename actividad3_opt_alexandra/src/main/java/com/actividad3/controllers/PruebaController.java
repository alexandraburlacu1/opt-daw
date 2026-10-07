package com.actividad3.actividad3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PruebaController {
        @GetMapping("/elegir")
        public String elegir(@RequestParam(name = "idioma", required = false) String idioma) {

            return switch (idioma) {
                case "spanish" -> "redirect:/spanish.html";
                case "french" -> "redirect:/french.html";
                case "german" -> "redirect:/german.html";
                case "english" -> "redirect:/english.html";
                default -> "redirect:/english.html";
            };

        }
    }
