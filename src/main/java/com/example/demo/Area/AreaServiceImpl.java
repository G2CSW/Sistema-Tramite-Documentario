package com.example.demo.Area;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    private final List<Area> areas = new ArrayList<>();

    public AreaServiceImpl() {
        areas.add(new Area("A001", "Mesa de Partes"));
        areas.add(new Area("A002", "Área de Evaluación"));
    }

    @Override
    public List<Area> listarAreas() {
        return areas;
    }

    @Override
    public Area buscarArea(String idArea) {
        for (Area a : areas) {
            if (a.getIdArea().equals(idArea)) {
                return a;
            }
        }
        return null;
    }
}