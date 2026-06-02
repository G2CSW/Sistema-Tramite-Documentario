-- ==========================================
-- DATA-METRICAS.SQL
-- Datos de prueba para validar métricas
-- Período: Febrero 2026 - Junio 2026
-- ==========================================


-- ==========================================
-- DATOS BASE
-- ==========================================

INSERT INTO documentos (nombre_documento, activo) VALUES
    ('Solicitud simple', TRUE),
    ('Copia DNI', TRUE),
    ('Recibo de pago', TRUE),
    ('Certificado de notas', TRUE),
    ('Sílabos', TRUE);

INSERT INTO tipos_tramite (nombre, fecha_creacion, activo) VALUES
    ('Certificado de Estudios', CURRENT_DATE, TRUE),
    ('Constancia de Matrícula', CURRENT_DATE, TRUE),
    ('Convalidación', CURRENT_DATE, TRUE);

INSERT INTO tipo_tramite_documento (tipo_tramite_id, documento_id) VALUES
    (1, 1), (1, 2), (1, 3),
    (2, 1), (2, 2), (2, 3),
    (3, 1), (3, 2), (3, 4), (3, 5);

INSERT INTO usuarios (id_usuario, nombre, correo_electronico, password, area, activo) VALUES
    ('12345678', 'Luis Pérez', 'luis.perez@gmail.com', '123', 'Mesa de Partes', TRUE),
    ('87654321', 'María Torres', 'maria.torres@gmail.com', '123', 'Área de Evaluación', TRUE),
    ('admin', 'Administrador', 'admin@gmail.com', 'admin', 'Admin', TRUE);

INSERT INTO solicitantes (id_solicitante, nombre_completo, correo_electronico, telefono_contacto) VALUES
    ('74185296', 'Carlos Ramírez', 'carlos@gmail.com', '987654321'),
    ('85296371', 'Ana García', 'ana.garcia@gmail.com', '987654322'),
    ('96371482', 'Juan López', 'juan.lopez@gmail.com', '987654323'),
    ('07482593', 'Patricia Díaz', 'patricia.diaz@gmail.com', '987654324'),
    ('18593604', 'Roberto Silva', 'roberto.silva@gmail.com', '987654325'),
    ('29604715', 'Claudia Morales', 'claudia.morales@gmail.com', '987654326'),
    ('30715826', 'Fernando Castro', 'fernando.castro@gmail.com', '987654327'),
    ('41826937', 'Margarita Ruiz', 'margarita.ruiz@gmail.com', '987654328'),
    ('52937048', 'Alejandro Flores', 'alejandro.flores@gmail.com', '987654329'),
    ('63048159', 'Elena Rodríguez', 'elena.rodriguez@gmail.com', '987654330');

-- FEBRERO
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (1, '74185296', '2026-02-03', 'APROBADO', TRUE, TRUE, TRUE, TRUE);
INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (1, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-02-03 08:00:00'),
    (1, '87654321', 'EN_EVALUACION', 'Iniciando evaluación del trámite', '2026-02-04 09:30:00'),
    (1, '87654321', 'APROBADO', 'Trámite aprobado. Cumple con todos los requisitos', '2026-02-11 14:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (1, '85296371', '2026-02-05', 'APROBADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (2, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-02-05 09:15:00'),
    (2, '87654321', 'EN_EVALUACION', 'Enviado a evaluación', '2026-02-06 10:00:00'),
    (2, '87654321', 'APROBADO', 'Aprobado con observaciones menores', '2026-02-17 15:30:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (2, '96371482', '2026-02-08', 'APROBADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (3, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-02-08 07:45:00'),
    (3, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-02-09 11:20:00'),
    (3, '87654321', 'APROBADO', 'Aprobado', '2026-02-18 13:45:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (1, '07482593', '2026-02-10', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (4, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-02-10 10:00:00'),
    (4, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-02-11 12:00:00'),
    (4, '87654321', 'RECHAZADO', 'Rechazado por incumplimiento de requisitos: Falta documentación importante', '2026-02-20 16:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (2, '18593604', '2026-02-15', 'CANCELADO', TRUE, TRUE, NULL, NULL);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (5, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-02-15 14:30:00'),
    (5, '12345678', 'CANCELADO', 'Cancelado por solicitud del solicitante', '2026-02-20 09:00:00');

-- MARZO
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES 
    (1, '29604715', '2026-03-02', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '30715826', '2026-03-05', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '41826937', '2026-03-08', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (3, '52937048', '2026-03-12', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '63048159', '2026-03-18', 'APROBADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (6, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-02 08:00:00'),
    (6, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-03 10:00:00'),
    (6, '87654321', 'APROBADO', 'Aprobado', '2026-03-17 15:00:00'),
    
    (7, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-05 09:00:00'),
    (7, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-06 11:00:00'),
    (7, '87654321', 'APROBADO', 'Aprobado', '2026-03-20 14:00:00'),
    
    (8, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-08 10:30:00'),
    (8, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-09 12:00:00'),
    (8, '87654321', 'APROBADO', 'Aprobado', '2026-03-23 16:30:00'),
    
    (9, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-12 07:45:00'),
    (9, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-13 09:30:00'),
    (9, '87654321', 'APROBADO', 'Aprobado', '2026-03-27 13:00:00'),
    
    (10, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-18 11:00:00'),
    (10, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-19 13:00:00'),
    (10, '87654321', 'APROBADO', 'Aprobado', '2026-04-02 15:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '74185296', '2026-03-10', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE),
    (2, '85296371', '2026-03-22', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (11, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-10 09:00:00'),
    (11, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-11 10:30:00'),
    (11, '87654321', 'RECHAZADO', 'Rechazado por falta de sustento válido', '2026-03-25 14:00:00'),
    
    (12, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-22 14:00:00'),
    (12, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-23 15:30:00'),
    (12, '87654321', 'RECHAZADO', 'Rechazado por inconsistencia en datos', '2026-04-06 10:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (1, '96371482', '2026-03-25', 'CANCELADO', TRUE, TRUE, NULL, NULL);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (13, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-03-25 10:00:00'),
    (13, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-03-26 11:00:00'),
    (13, '12345678', 'CANCELADO', 'Cancelado por solicitud del usuario', '2026-04-02 09:00:00');

-- ABRIL
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '07482593', '2026-04-02', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '18593604', '2026-04-05', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (3, '29604715', '2026-04-08', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '30715826', '2026-04-12', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '41826937', '2026-04-15', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '52937048', '2026-04-20', 'APROBADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (14, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-02 08:00:00'),
    (14, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-03 10:00:00'),
    (14, '87654321', 'APROBADO', 'Aprobado', '2026-04-24 14:00:00'),
    
    (15, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-05 09:00:00'),
    (15, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-06 11:00:00'),
    (15, '87654321', 'APROBADO', 'Aprobado', '2026-04-27 15:00:00'),
    
    (16, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-08 10:00:00'),
    (16, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-09 12:00:00'),
    (16, '87654321', 'APROBADO', 'Aprobado', '2026-04-30 13:00:00'),
    
    (17, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-12 07:30:00'),
    (17, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-13 09:00:00'),
    (17, '87654321', 'APROBADO', 'Aprobado', '2026-05-04 16:00:00'),
    
    (18, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-15 11:00:00'),
    (18, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-16 13:00:00'),
    (18, '87654321', 'APROBADO', 'Aprobado', '2026-05-05 14:30:00'),
    
    (19, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-20 10:00:00'),
    (19, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-21 12:00:00'),
    (19, '87654321', 'APROBADO', 'Aprobado', '2026-05-12 15:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '63048159', '2026-04-10', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE),
    (2, '74185296', '2026-04-25', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (20, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-10 09:00:00'),
    (20, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-11 10:30:00'),
    (20, '87654321', 'RECHAZADO', 'Rechazado: Datos incompletos', '2026-04-28 14:00:00'),
    
    (21, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-25 14:00:00'),
    (21, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-26 15:30:00'),
    (21, '87654321', 'RECHAZADO', 'Rechazado por documentación incompleta', '2026-05-13 10:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (1, '85296371', '2026-04-18', 'CANCELADO', TRUE, TRUE, NULL, NULL);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (22, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-18 10:00:00'),
    (22, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-19 11:00:00'),
    (22, '12345678', 'CANCELADO', 'Cancelado por retiro voluntario del solicitante', '2026-04-28 09:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (2, '96371482', '2026-04-22', 'ARCHIVADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (23, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-04-22 10:00:00'),
    (23, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-04-23 12:00:00'),
    (23, '87654321', 'APROBADO', 'Aprobado - Entrega de documento realizada', '2026-05-12 14:00:00'),
    (23, '12345678', 'ARCHIVADO', 'Tramite archivado después de procesamiento', '2026-05-17 09:00:00');

-- MAYO
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '07482593', '2026-05-02', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '18593604', '2026-05-04', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '29604715', '2026-05-06', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (3, '30715826', '2026-05-08', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '41826937', '2026-05-10', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '52937048', '2026-05-12', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '63048159', '2026-05-15', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '74185296', '2026-05-18', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (3, '85296371', '2026-05-20', 'APROBADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (24, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-02 08:00:00'),
    (24, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-03 10:00:00'),
    (24, '87654321', 'APROBADO', 'Aprobado', '2026-05-24 14:00:00'),
    
    (25, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-04 09:00:00'),
    (25, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-05 11:00:00'),
    (25, '87654321', 'APROBADO', 'Aprobado', '2026-05-26 15:00:00'),
    
    (26, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-06 10:00:00'),
    (26, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-07 12:00:00'),
    (26, '87654321', 'APROBADO', 'Aprobado', '2026-05-28 13:00:00'),
    
    (27, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-08 07:30:00'),
    (27, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-09 09:00:00'),
    (27, '87654321', 'APROBADO', 'Aprobado', '2026-05-30 16:00:00'),
    
    (28, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-10 11:00:00'),
    (28, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-11 13:00:00'),
    (28, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 14:30:00'),
    
    (29, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-12 10:00:00'),
    (29, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-13 12:00:00'),
    (29, '87654321', 'APROBADO', 'Aprobado', '2026-06-02 15:00:00'),
    
    (30, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-15 08:00:00'),
    (30, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-16 10:00:00'),
    (30, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 13:00:00'),
    
    (31, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-18 09:00:00'),
    (31, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-19 11:00:00'),
    (31, '87654321', 'APROBADO', 'Aprobado', '2026-06-02 14:00:00'),
    
    (32, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-20 10:00:00'),
    (32, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-21 12:00:00'),
    (32, '87654321', 'APROBADO', 'Aprobado', '2026-06-03 15:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '96371482', '2026-05-05', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE),
    (2, '07482593', '2026-05-14', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE),
    (1, '18593604', '2026-05-25', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (33, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-05 09:00:00'),
    (33, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-06 10:30:00'),
    (33, '87654321', 'RECHAZADO', 'Rechazado: Sustento inválido', '2026-05-25 14:00:00'),
    
    (34, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-14 14:00:00'),
    (34, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-15 15:30:00'),
    (34, '87654321', 'RECHAZADO', 'Rechazado por inconsistencia', '2026-06-03 10:00:00'),
    
    (35, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-25 14:00:00'),
    (35, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-26 15:30:00'),
    (35, '87654321', 'RECHAZADO', 'Rechazado por falta de documentación', '2026-06-04 10:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (2, '29604715', '2026-05-09', 'CANCELADO', TRUE, TRUE, NULL, NULL),
    (1, '30715826', '2026-05-22', 'CANCELADO', TRUE, TRUE, NULL, NULL);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (36, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-09 10:00:00'),
    (36, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-10 11:00:00'),
    (36, '12345678', 'CANCELADO', 'Cancelado por solicitud del usuario', '2026-05-21 09:00:00'),
    
    (37, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-22 10:00:00'),
    (37, '12345678', 'CANCELADO', 'Cancelado - Usuario no continuó con el trámite', '2026-05-29 14:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (2, '41826937', '2026-05-13', 'ARCHIVADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (38, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-13 10:00:00'),
    (38, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-05-14 12:00:00'),
    (38, '87654321', 'APROBADO', 'Aprobado - Documento entregado', '2026-06-04 14:00:00'),
    (38, '12345678', 'ARCHIVADO', 'Tramite archivado después de procesamiento', '2026-06-05 09:00:00');

-- JUNIO
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '52937048', '2026-05-27', 'REGISTRADO', TRUE, NULL, NULL, NULL),
    (2, '63048159', '2026-05-28', 'REGISTRADO', TRUE, NULL, NULL, NULL),
    (1, '74185296', '2026-05-29', 'REGISTRADO', TRUE, NULL, NULL, NULL),
    (2, '85296371', '2026-05-30', 'REGISTRADO', TRUE, NULL, NULL, NULL),
    (1, '96371482', '2026-05-31', 'REGISTRADO', TRUE, NULL, NULL, NULL),
    (2, '07482593', '2026-06-01', 'REGISTRADO', TRUE, NULL, NULL, NULL);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (39, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-27 10:00:00'),
    (40, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-28 11:00:00'),
    (41, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-29 09:30:00'),
    (42, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-30 14:00:00'),
    (43, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-05-31 10:30:00'),
    (44, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 09:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '18593604', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '29604715', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '30715826', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (3, '41826937', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '52937048', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (1, '63048159', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE),
    (2, '74185296', '2026-06-01', 'APROBADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (45, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 08:00:00'),
    (45, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 10:00:00'),
    (45, '87654321', 'APROBADO', 'Aprobado - Documento listo para entrega', '2026-06-01 14:00:00'),
    
    (46, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 08:15:00'),
    (46, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 11:00:00'),
    (46, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 15:00:00'),
    
    (47, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 08:30:00'),
    (47, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 12:00:00'),
    (47, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 13:30:00'),
    
    (48, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 08:45:00'),
    (48, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 09:00:00'),
    (48, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 16:00:00'),
    
    (49, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 09:00:00'),
    (49, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 13:00:00'),
    (49, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 14:30:00'),
    
    (50, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 09:15:00'),
    (50, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 12:00:00'),
    (50, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 15:00:00'),
    
    (51, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 09:30:00'),
    (51, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 11:00:00'),
    (51, '87654321', 'APROBADO', 'Aprobado', '2026-06-01 14:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '85296371', '2026-06-01', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE),
    (2, '96371482', '2026-06-01', 'RECHAZADO', TRUE, FALSE, FALSE, FALSE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (52, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 09:45:00'),
    (52, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 10:30:00'),
    (52, '87654321', 'RECHAZADO', 'Rechazado: Documentación incompleta', '2026-06-01 14:00:00'),
    
    (53, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 10:00:00'),
    (53, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 15:30:00'),
    (53, '87654321', 'RECHAZADO', 'Rechazado por datos inconsistentes', '2026-06-01 10:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES
    (1, '07482593', '2026-06-01', 'CANCELADO', TRUE, TRUE, NULL, NULL),
    (2, '18593604', '2026-06-01', 'CANCELADO', TRUE, TRUE, NULL, NULL);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (54, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 10:15:00'),
    (54, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 11:00:00'),
    (54, '12345678', 'CANCELADO', 'Cancelado por solicitud del solicitante', '2026-06-01 09:00:00'),
    
    (55, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 10:30:00'),
    (55, '12345678', 'CANCELADO', 'Cancelado - Usuario retira solicitud', '2026-06-01 14:00:00');
INSERT INTO tramites (id_tipo_tramite, id_solicitante, fecha_registro, estado_actual, datos_completos, datos_consistentes, cumple_requisitos, sustento_valido)
VALUES (2, '29604715', '2026-06-01', 'ARCHIVADO', TRUE, TRUE, TRUE, TRUE);

INSERT INTO trazabilidades (nro_tramite, id_usuario, estado_cambio, comentario, fecha_hora) VALUES
    (56, '12345678', 'REGISTRADO', 'Trámite registrado en sistema', '2026-06-01 10:45:00'),
    (56, '87654321', 'EN_EVALUACION', 'En evaluación', '2026-06-01 12:00:00'),
    (56, '87654321', 'APROBADO', 'Aprobado - Entrega completada', '2026-06-01 14:00:00'),
    (56, '12345678', 'ARCHIVADO', 'Tramite archivado después de procesamiento', '2026-06-01 09:00:00');

