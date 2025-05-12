INSERT INTO `zonas` (`id`, `ciudadid`, `latitud`, `longitud`, `nombre`, `voluntarioszona`) VALUES
(1, 1, 40.4168, -3.7038, 'Zona Norte', NULL),
(2, 2, 37.3826, -5.9963, 'Zona Sur', NULL),
(3, 3, 41.3851, 2.1734, 'Zona Este', NULL),
(4, 4, 39.4699, -0.3763, 'Zona Oeste', NULL),
(5, 5, 40.960539, -5.675386, 'ZonaRio1', 'Mc981204,Cp192881'),
(6, 5, 40.955628, -5.653502, 'ZonaRio2', 'Mc981204');

INSERT INTO `zonas_entity_batidaid` (`zonas_entity_id`, `batidaid`) VALUES
(5, 1),
(5, 2);