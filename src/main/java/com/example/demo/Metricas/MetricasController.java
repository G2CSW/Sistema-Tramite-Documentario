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

        MetricasEstadoDTO estados = metricaService.estadosUltimos5Meses();

        model.addAttribute("aprobadosRows", estados.getAprobados());
        model.addAttribute("rechazadosRows", estados.getRechazados());
        model.addAttribute("canceladosRows", estados.getCancelados());
        model.addAttribute("evaluacionRows", estados.getEvaluacion());
        model.addAttribute("intensidadRows", metricaService.cantidadTramitesRegistradosUltimas4Semanas());

        return "metricas";
    }
}
