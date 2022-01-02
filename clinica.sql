-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Out-2021 às 19:36
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clinica`
--

CREATE TABLE `clinica` (
  `IDClinica` int(11) UNSIGNED NOT NULL,
  `NomeFantasia` varchar(255) NOT NULL,
  `Endereco` varchar(255) NOT NULL,
  `Numero` varchar(9) NOT NULL,
  `Cep` varchar(10) NOT NULL,
  `Razao_Social` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clinica`
--

INSERT INTO `clinica` (`IDClinica`, `NomeFantasia`, `Endereco`, `Numero`, `Cep`, `Razao_Social`) VALUES
(3, ' nome ', '  endereco', '  num  ', ' cep ', 'social?');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `IDConsulta` int(11) UNSIGNED NOT NULL,
  `IDMedico` int(11) UNSIGNED NOT NULL,
  `IDpaciente` int(11) UNSIGNED NOT NULL,
  `DataConsulta` date NOT NULL,
  `Descricao` text NOT NULL,
  `StatusConsulta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`IDConsulta`, `IDMedico`, `IDpaciente`, `DataConsulta`, `Descricao`, `StatusConsulta`) VALUES
(1, 1, 1, '2021-10-10', 'nao', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `especialidade`
--

CREATE TABLE `especialidade` (
  `IDespecialidade` int(10) UNSIGNED NOT NULL,
  `nomeespecialidade` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `especialidade`
--

INSERT INTO `especialidade` (`IDespecialidade`, `nomeespecialidade`) VALUES
(1, '  Cardio  '),
(3, '  Neuro  ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `IDMedico` int(11) UNSIGNED NOT NULL,
  `IDusuario` int(11) UNSIGNED NOT NULL,
  `Nomemedico` varchar(255) NOT NULL,
  `CRM` varchar(255) NOT NULL,
  `IDClinica` int(11) UNSIGNED NOT NULL,
  `IDespecialidade` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`IDMedico`, `IDusuario`, `Nomemedico`, `CRM`, `IDClinica`, `IDespecialidade`) VALUES
(1, 9, '  jorge  ', '  456  ', 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `IDpaciente` int(11) UNSIGNED NOT NULL,
  `Id_usuario` int(11) NOT NULL,
  `Nomepaciente` varchar(255) NOT NULL,
  `DataNascimento` date NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `RG` varchar(20) NOT NULL,
  `Telefone` varchar(9) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Contato` varchar(255) NOT NULL,
  `TelefoneContato` varchar(9) NOT NULL,
  `Comentario` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`IDpaciente`, `Id_usuario`, `Nomepaciente`, `DataNascimento`, `CPF`, `RG`, `Telefone`, `Email`, `Contato`, `TelefoneContato`, `Comentario`) VALUES
(1, 6, '  hel  ', '2012-12-12', ' 123456 ', ' 444', ' 2312 ', ' meail ', ' conteme ', ' 555 ', ' aaaha '),
(9, 9, '  aaaa  ', '2012-12-12', ' 123 ', ' 4567 ', ' 343 ', ' wdawfw ', ' fdawf ', ' 2141 ', ' aaa '),
(11, 10, '  hela  ', '2010-12-12', ' 123 ', ' 345 ', ' 576 ', ' awdaw ', ' dawd ', ' 123 ', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `IDusuario` int(11) UNSIGNED NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Senha` varchar(255) NOT NULL,
  `Tipo_usuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`IDusuario`, `Email`, `Senha`, `Tipo_usuario`) VALUES
(31, 'email', 'senha', 'nenhum'),
(32, 'user', 'pass', 'nenhum');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clinica`
--
ALTER TABLE `clinica`
  ADD PRIMARY KEY (`IDClinica`);

--
-- Índices para tabela `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`IDConsulta`);

--
-- Índices para tabela `especialidade`
--
ALTER TABLE `especialidade`
  ADD PRIMARY KEY (`IDespecialidade`);

--
-- Índices para tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`IDMedico`);

--
-- Índices para tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`IDpaciente`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IDusuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clinica`
--
ALTER TABLE `clinica`
  MODIFY `IDClinica` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `consulta`
--
ALTER TABLE `consulta`
  MODIFY `IDConsulta` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `especialidade`
--
ALTER TABLE `especialidade`
  MODIFY `IDespecialidade` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `IDMedico` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `IDpaciente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IDusuario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
