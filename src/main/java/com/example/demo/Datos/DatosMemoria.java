package com.example.demo.Datos;

import com.example.demo.Area.Area;
import com.example.demo.Documento.Documento;
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
    public static final List<Documento> DOCUMENTOS = new ArrayList<>();

    static {

        // AREAS
        AREAS.add(new Area("A001", "Mesa de Partes"));
        AREAS.add(new Area("A002", "Área Académica"));

        // USUARIOS
        Usuario usuario1 = new Usuario(
                "12345678",
                "Luis Pérez",
                "luis.perez@gmail.com",
                "123",
                AREAS.get(0),
                true
        );

        Usuario usuario2 = new Usuario(
                "87654321",
                "María Torres",
                "maria.torres@gmail.com",
                "123",
                AREAS.get(1),
                true
        );

        USUARIOS.add(usuario1);
        USUARIOS.add(usuario2);

        // DOCUMENTOS
        Documento doc1 = new Documento(1L, "Solicitud simple");
        Documento doc2 = new Documento(2L, "Copia DNI");
        Documento doc3 = new Documento(3L, "Recibo de pago");
        Documento doc4 = new Documento(4L, "Certificado de notas");
        Documento doc5 = new Documento(5L, "Sílabos");

        DOCUMENTOS.add(doc1);
        DOCUMENTOS.add(doc2);
        DOCUMENTOS.add(doc3);
        DOCUMENTOS.add(doc4);
        DOCUMENTOS.add(doc5);

        // TIPOS DE TRÁMITE
        TipoTramite tipo1 = new TipoTramite(
                "TT1",
                "Certificado de Estudios",
                List.of(doc1, doc2, doc3),
                LocalDate.now()
        );

        TipoTramite tipo2 = new TipoTramite(
                "TT2",
                "Constancia de Matrícula",
                List.of(doc1, doc2, doc3),
                LocalDate.now()
        );

        TipoTramite tipo3 = new TipoTramite(
                "TT3",
                "Convalidación",
                List.of(doc1, doc2, doc4, doc5),
                LocalDate.now()
        );

        TIPOS_TRAMITE.add(tipo1);
        TIPOS_TRAMITE.add(tipo2);
        TIPOS_TRAMITE.add(tipo3);

        // SOLICITANTES
        Solicitante solicitante1 = new Solicitante(
                "74185296",
                "Carlos Ramírez",
                "carlos@gmail.com",
                "987654321"
        );

        SOLICITANTES.add(solicitante1);

        // TRÁMITE
        Tramite tramite1 = new Tramite();

        tramite1.setNroTramite("TR001");
        tramite1.setTipoTramite(tipo1);
        tramite1.setSolicitante(solicitante1);
        tramite1.setFechaRegistro(LocalDate.now());
        tramite1.setEstadoActual(EstadoTramite.REGISTRADO);

        TRAMITES.add(tramite1);

        // TRAZABILIDAD
        Trazabilidad trazabilidad1 = new Trazabilidad();

        trazabilidad1.setIdTrazabilidad("TZ001");
        trazabilidad1.setTramite(tramite1);
        trazabilidad1.setUsuario(usuario1);
        trazabilidad1.setEstadoCambio(EstadoTramite.REGISTRADO);
        trazabilidad1.setFechaHora(LocalDateTime.now());
        trazabilidad1.setComentario("Trámite registrado correctamente");

        TRAZABILIDADES.add(trazabilidad1);
    }

    private DatosMemoria() {
    }
}