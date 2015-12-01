CREATE DATABASE `locadora` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(45) NOT NULL,
  `cnh_cliente` varchar(11) NOT NULL,
  `endereco_cliente` varchar(60) NOT NULL,
  `bairro_cliente` varchar(30) NOT NULL,
  `cidade_cliente` varchar(30) NOT NULL,
  `estado_cliente` varchar(2) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `email_usuario` varchar(45) NOT NULL,
  `senha_usuario` varchar(45) NOT NULL,
  `nome_usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `veiculo` (
  `id_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa_veiculo` varchar(7) NOT NULL,
  `fabricante_veiculo` varchar(15) NOT NULL,
  `modelo_veiculo` varchar(15) NOT NULL,
  `valor_aluguel` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_veiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
