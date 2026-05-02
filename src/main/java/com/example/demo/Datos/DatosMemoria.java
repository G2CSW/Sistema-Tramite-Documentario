package com.example.demo.Datos;

import com.example.demo.Area.Area;
import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.Tramite.*;
import com.example.demo.Usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatosMemoria {

    public static final List<Area> AREAS = new ArrayList<>();
    public static final List<Usuario> USUARIOS = new ArrayList<>();
    public static final List<TipoTramite> TIPOS_TRAMITE = new ArrayList<>();
    public static final List<Solicitante> SOLICITANTES = new ArrayList<>();
    public static final List<Tramite> TRAMITES = new ArrayList<>();
    public static final List<Trazabilidad> TRAZABILIDADES = new ArrayList<>();
    public static final List<EvaluacionTramite> EVALUACIONES = new ArrayList<>();

    static {
        // AREAS
        AREAS.add(new Area("A001", "Mesa de Partes"));
        AREAS.add(new Area("A002", "Área Académica"));

        // USUARIOS
        USUARIOS.add(new Usuario("12345678", "Luis Pérez", "luis.perez@gmail.com", "123", AREAS.get(0), true));
        USUARIOS.add(new Usuario("87654321", "María Torres", "maria.torres@gmail.com", "123", AREAS.get(1), true));

        // TIPOS DE TRÁMITE
        TIPOS_TRAMITE.add(new TipoTramite(
                "TT1",
                "Certificado de Estudios",
                "1. Solicitud simple, 2. Copia DNI, 3. Recibo de pago",
                LocalDate.now()
        ));

        TIPOS_TRAMITE.add(new TipoTramite(
                "TT2",
                "Constancia de Matrícula",
                "1. Solicitud simple, 2. Copia DNI, 3. Recibo de pago",
                LocalDate.now()
        ));

        TIPOS_TRAMITE.add(new TipoTramite(
                "TT3",
                "Convalidación",
                "1. Solicitud simple, 2. DNI, 3. Certificado de notas, 4. Sílabos",
                LocalDate.now()
        ));


    }

    private DatosMemoria() {
    }

}
