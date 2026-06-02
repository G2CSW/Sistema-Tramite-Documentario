package com.example.demo.Metricas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/metricas")
public class MetricasController {

    private final MetricasService metricaService;

    public MetricasController(MetricasService metricaService) {
        this.metricaService = metricaService;
    }

    @GetMapping
    public String metricas(Model model) {
        model.addAttribute("aprobacionRows", metricaService.aprobarUltimos5Meses());
        model.addAttribute("rechazoRows", metricaService.rechazoUltimos5Meses());
        model.addAttribute("abandonoRows", metricaService.abandonoUltimos5Meses());
        model.addAttribute("intensidadRows", metricaService.intensidadUltimas4Semanas());
        model.addAttribute("tiempoRows", metricaService.tiempoResolucionUltimos5Meses());
        return "metricas";
    }
}