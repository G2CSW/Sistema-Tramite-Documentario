package com.example.demo.Area;

import com.example.demo.Datos.DatosMemoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    private final List<Area> areas = DatosMemoria.AREAS;

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
