package com.example.demo.Area;

import java.util.List;

public interface AreaService {

    List<Area> listarAreas();

    Area buscarArea(String idArea);
}