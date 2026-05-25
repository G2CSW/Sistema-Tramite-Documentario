-- ============================================================
-- data.sql  –  Datos iniciales del Sistema de Trámite Documentario
-- Basado en DatosMemoria.java
-- ============================================================

-- Documentos
INSERT INTO documentos (id_documento, nombre_documento, activo) VALUES
    (1, 'Solicitud simple',     TRUE),
    (2, 'Copia DNI',            TRUE),
    (3, 'Recibo de pago',       TRUE),
    (4, 'Certificado de notas', TRUE),
    (5, 'Sílabos',              TRUE);

-- Tipos de Trámite
INSERT INTO tipos_tramite (id_tipo_tramite, nombre, fecha_creacion, activo) VALUES
    ('TT1', 'Certificado de Estudios',  CURRENT_DATE, TRUE),
    ('TT2', 'Constancia de Matrícula',  CURRENT_DATE, TRUE),
    ('TT3', 'Convalidación',            CURRENT_DATE, TRUE);

-- Documentación mínima por tipo de trámite
INSERT INTO tipo_tramite_documentos (id_tipo_tramite, id_documento) VALUES
    ('TT1', 1), ('TT1', 2), ('TT1', 3),
    ('TT2', 1), ('TT2', 2), ('TT2', 3),
    ('TT3', 1), ('TT3', 2), ('TT3', 4), ('TT3', 5);

-- Usuarios
INSERT INTO usuarios (id_usuario, nombre, correo_electronico, password, area, activo) VALUES
    ('12345678', 'Luis Pérez',    'luis.perez@gmail.com',   '123', 'Mesa de Partes', TRUE),
    ('87654321', 'María Torres',  'maria.torres@gmail.com', '123', 'Área Académica',  TRUE);

-- Solicitantes
INSERT INTO solicitantes (id_solicitante, nombre_completo, correo_electronico, telefono_contacto) VALUES
    ('74185296', 'Carlos Ramírez', 'carlos@gmail.com', '987654321');

-- Trámites
INSERT INTO tramites (id_tipo_tramite, id_usuario, id_solicitante, fecha_registro, estado_actual,
                      datos_completos, datos_consistentes, cumple_requisitos, sustento_valido) VALUES
    ('TT1', NULL, '74185296', CURRENT_DATE, 'REGISTRADO', NULL, NULL, NULL, NULL);

-- Trazabilidades
INSERT INTO trazabilidades (
    nro_tramite,
    id_usuario,
    estado_cambio,
    comentario,
    fecha_hora
) VALUES (
    1,
    '12345678',
    'REGISTRADO',
    'Trámite registrado correctamente',
    CURRENT_TIMESTAMP
);