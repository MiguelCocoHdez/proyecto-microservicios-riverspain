INSERT INTO `peces` (`id`, `biologiaecologia`, `descripcion`, `distribucion`, `nombrecientifico`, `nombrecomun`, `origen`, `taxonomia`, `urlimagen`) VALUES
(1, 'Es omnívoro y se alimenta de insectos, crustáceos y vegetación acuática.', 'Es una especie de pez de agua dulce muy común en los ríos europeos.', 'Se encuentra distribuido por los principales ríos del centro y sur de Europa.', 'Barbus barbus', 'Barbo común', 'Europa', 'Cyprinidae', 'https://www.mediterranea.org/cae/divulgac/peces/barbus.jpg'),
(2, 'Es omnívoro y se alimenta de insectos, crustáceos y vegetación acuática.', 'Es una especie de pez de agua dulce muy común en los ríos europeos.', 'Se encuentra distribuido por los principales ríos del centro y sur de Europa.', 'Siluro Siluro', 'Siluro Comun', 'Europa', 'Cyprinidae', 'https://upload.wikimedia.org/wikipedia/commons/e/ec/Silurus_glanis_01.jpg');

INSERT INTO `peces_entity_rioid` (`peces_entity_id`, `rioid`) VALUES
(1, 1),
(2, 1);