INSERT INTO `rios` (`id`, `descripcion`, `imagen`, `nombre`) VALUES
(1, 'El río Ebro es el río más caudaloso de España y el segundo más largo del país, con una longitud de aproximadamente 910 km. Nace en Fontibre, en la comunidad de Cantabria, y atraviesa varias regiones del norte y noreste de España antes de desembocar en el ', 'https://media.istockphoto.com/id/859727138/es/foto/el-río-ebro.jpg?s=612x612&w=0&k=20&c=SkPXVxQ44OATU0Vj4RC2xMnhMPDpAA9q33JMO3nnbVs=', 'Ebro'),
(2, 'rio tajo situado en ;;:', 'https://www.iagua.es/sites/default/files/styles/thumbnail-830x455/public/rio_tajo_nacimiento.jpg?itok=hQpQW1Zh', 'Tajo'),
(3, 'Rio Guadalquivir', 'https://sevillainformacion.es/wp-content/uploads/2024/05/cual-es-la-importancia-del-guadalquivir-en-sevilla.jpg', 'Guadalquivir');

INSERT INTO `rios_entity_pezid` (`rios_entity_id`, `pezid`) VALUES
(1, 1),
(1, 2),
(2, 3);