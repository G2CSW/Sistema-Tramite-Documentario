package com.example.demo.Datos;

import com.example.demo.TipoTramite.TipoTramite;
import com.example.demo.Tramite.EstadoTramite;
import com.example.demo.Tramite.Solicitante;
import com.example.demo.Tramite.Tramite;
import com.example.demo.Usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosMemoria {

//    public static final List<Area> AREAS = new ArrayList<>();
    public static final List<Usuario> USUARIOS = new ArrayList<>();
    public static final List<TipoTramite> TIPOS_TRAMITE = new ArrayList<>();
    public static final List<Solicitante> SOLICITANTES = new ArrayList<>();
    public static final List<Tramite> TRAMITES = new ArrayList<>();
//    public static final List<Trazabilidad> TRAZABILIDADES = new ArrayList<>();
//    public static final List<EvaluacionTramite> EVALUACIONES = new ArrayList<>();

    static {
//        // AREAS
//        AREAS.add(new Area("A001", "Mesa de Partes"));
//        AREAS.add(new Area("A002", "Área Académica"));

        // USUARIOS
        USUARIOS.add(new Usuario("12345678", "Luis Pérez", "luis.perez@gmail.com", "123", "A1", true));
        USUARIOS.add(new Usuario("87654321", "María Torres", "maria.torres@gmail.com", "123", "A2", true));

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

        // SOLICITANTES
        SOLICITANTES.add(new Solicitante("12345678", "Juan Carlos Díaz Rojas", "juan.diaz@gmail.com", "987654321"));
        SOLICITANTES.add(new Solicitante("87654321", "Ana Lucía Salazar Paredes", "ana.salazar@gmail.com", "912345678"));
        SOLICITANTES.add(new Solicitante("45678912", "Empresa ABC S.A.C.", "contacto@empresaabc.com", "944112233"));

        // TRÁMITES
        TRAMITES.add(new Tramite(
                "TR1",
                TIPOS_TRAMITE.get(0),
                USUARIOS.get(0),
                SOLICITANTES.get(0),
                LocalDate.now(),
                EstadoTramite.REGISTRADO
        ));

        TRAMITES.add(new Tramite(
                "TR2",
                TIPOS_TRAMITE.get(2),
                USUARIOS.get(1),
                SOLICITANTES.get(1),
                LocalDate.now(),
                EstadoTramite.EN_EVALUACION
        ));

        TRAMITES.add(new Tramite(
                "TR3",
                TIPOS_TRAMITE.get(1),
                USUARIOS.get(0),
                SOLICITANTES.get(2),
                LocalDate.now(),
                EstadoTramite.APROBADO
        ));

//        // EVALUACIONES
//        EVALUACIONES.add(new EvaluacionTramite(
//                "TR0001",
//                true,
//                true,
//                false,
//                false
//        ));
//
//        EVALUACIONES.add(new EvaluacionTramite(
//                "TR0002",
//                true,
//                true,
//                true,
//                false
//        ));
//
//        // TRAZABILIDAD
//        TRAZABILIDADES.add(new Trazabilidad(
//                "TZ0001",
//                "TR0001",
//                "12345678",
//                EstadoTramite.REGISTRADO,
//                "Trámite registrado en mesa de partes.",
//                LocalDateTime.now()
//        ));
//
//        TRAZABILIDADES.add(new Trazabilidad(
//                "TZ0002",
//                "TR0002",
//                "87654321",
//                EstadoTramite.EN_EVALUACION,
//                "Trámite derivado al área académica.",
//                LocalDateTime.now()
//        ));
    }

    private DatosMemoria() {
    }
}
