-- Documentos
CREATE TABLE IF NOT EXISTS documentos (
    id_documento      BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_documento  VARCHAR(255) NOT NULL,
    activo            BOOLEAN      NOT NULL DEFAULT TRUE
);

-- Tipos de Trámite
CREATE TABLE IF NOT EXISTS tipos_tramite (
    id_tipo_tramite   BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre            VARCHAR(255) NOT NULL,
    fecha_creacion    DATE         NOT NULL,
    activo            BOOLEAN      NOT NULL DEFAULT TRUE
);

-- Tabla intermedia: TipoTramite ↔ Documentos (documentación mínima)
CREATE TABLE IF NOT EXISTS tipo_tramite_documento (
    tipo_tramite_id   BIGINT NOT NULL,
    documento_id      BIGINT NOT NULL,
    PRIMARY KEY (tipo_tramite_id, documento_id),
    CONSTRAINT fk_ttd_tipo FOREIGN KEY (tipo_tramite_id) REFERENCES tipos_tramite(id_tipo_tramite),
    CONSTRAINT fk_ttd_doc  FOREIGN KEY (documento_id) REFERENCES documentos(id_documento)
);

-- Usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario          VARCHAR(20)  PRIMARY KEY,
    nombre              VARCHAR(255) NOT NULL,
    correo_electronico  VARCHAR(255) NOT NULL,
    password            VARCHAR(255) NOT NULL,
    area                VARCHAR(255),
    activo              BOOLEAN      NOT NULL DEFAULT TRUE
);

-- Solicitantes
CREATE TABLE IF NOT EXISTS solicitantes (
    id_solicitante      VARCHAR(20)  PRIMARY KEY,
    nombre_completo     VARCHAR(255) NOT NULL,
    correo_electronico  VARCHAR(255),
    telefono_contacto   VARCHAR(20)
);

-- Trámites
CREATE TABLE IF NOT EXISTS tramites (
    nro_tramite          BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_tramite      BIGINT       NOT NULL,
    id_usuario           VARCHAR(20),
    id_solicitante       VARCHAR(20)   NOT NULL,
    fecha_registro       DATE         NOT NULL,
    estado_actual        VARCHAR(50)   NOT NULL,
    datos_completos      BOOLEAN,
    datos_consistentes   BOOLEAN,
    cumple_requisitos    BOOLEAN,
    sustento_valido      BOOLEAN,
    CONSTRAINT fk_tramite_tipo        FOREIGN KEY (id_tipo_tramite) REFERENCES tipos_tramite(id_tipo_tramite),
    CONSTRAINT fk_tramite_usuario     FOREIGN KEY (id_usuario)      REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_tramite_solicitante FOREIGN KEY (id_solicitante)  REFERENCES solicitantes(id_solicitante)
);

-- Trazabilidades
CREATE TABLE IF NOT EXISTS trazabilidades (
    id_trazabilidad  BIGINT AUTO_INCREMENT PRIMARY KEY,
    nro_tramite      BIGINT NOT NULL,
    id_usuario       VARCHAR(20),
    estado_cambio    VARCHAR(50) NOT NULL,
    comentario       VARCHAR(500),
    fecha_hora       TIMESTAMP NOT NULL,

    CONSTRAINT fk_traz_tramite FOREIGN KEY (nro_tramite) REFERENCES tramites(nro_tramite),
    CONSTRAINT fk_traz_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);