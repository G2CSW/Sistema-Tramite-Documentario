-- Documentos
INSERT INTO documentos (nombre_documento, activo) VALUES
    ('Solicitud simple',     TRUE),
    ('Copia DNI',            TRUE),
    ('Recibo de pago',       TRUE),
    ('Certificado de notas', TRUE),
    ('Sílabos',              TRUE);

-- Tipos de Trámite
INSERT INTO tipos_tramite (nombre, fecha_creacion, activo) VALUES
    ('Certificado de Estudios',  CURRENT_DATE, TRUE),
    ('Constancia de Matrícula',  CURRENT_DATE, TRUE),
    ('Convalidación',            CURRENT_DATE, TRUE);

-- Documentación mínima por tipo de trámite
-- Si los inserts anteriores quedaron en orden, los IDs generados serán 1, 2 y 3
INSERT INTO tipo_tramite_documento (tipo_tramite_id, documento_id) VALUES
    (1, 1), (1, 2), (1, 3),
    (2, 1), (2, 2), (2, 3),
    (3, 1), (3, 2), (3, 4), (3, 5);

-- Usuarios
INSERT INTO usuarios (id_usuario, nombre, correo_electronico, password, area, activo) VALUES
    ('12345678', 'Luis Pérez',    'luis.perez@gmail.com',   '123', 'Mesa de Partes', TRUE),
    ('87654321', 'María Torres',  'maria.torres@gmail.com', '123', 'Área Académica',  TRUE),
    ('admin',    'Administrador', 'admin@gmail.com',        'admin', 'Admin', TRUE);

-- Solicitantes
INSERT INTO solicitantes (id_solicitante, nombre_completo, correo_electronico, telefono_contacto) VALUES
    ('74185296', 'Carlos Ramírez', 'carlos@gmail.com', '987654321');

-- Trámites
INSERT INTO tramites (
    id_tipo_tramite, id_solicitante, fecha_registro, estado_actual,
    datos_completos, datos_consistentes, cumple_requisitos, sustento_valido
) VALUES (
    1, '74185296', CURRENT_DATE, 'REGISTRADO', NULL, NULL, NULL, NULL
);

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