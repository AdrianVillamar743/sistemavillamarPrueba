-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-02-2022 a las 23:35:16
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_villamar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `clave` varchar(1200) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellido`, `email`, `clave`, `estado`) VALUES
(5, 'aaa', 'a', 'a', 'a', 'A'),
(6, '1', '12', '1', '1', 'A'),
(8, 'de nuevo', 'registrado', 'papu', 'aaa', 'A'),
(10, 'qqe', 'w', 'w', '$argon2id$v=19$m=1024,t=1,p=1$r0chgHyeCeSeWoMhzmy1mQ$BpylVLCIArL/PBM8soBVGWLWmsmFtzXCz4RxDPO8te8', 'A'),
(11, 'Adrian', 'Villamar', 'villa', '$argon2id$v=19$m=1024,t=5,p=5$8y9r8BnnEBhijumaiEdSLQ$8GPZ5cc8owVIInOgrDmh51bFLYgIjkmJduq7ABDcdko', 'A'),
(12, '25', '25', '26', '$argon2id$v=19$m=1024,t=5,p=5$bzZrW7Wcht5XiIof++wwEA$VToSts4uZs03DWlfc4lNteksSd/RqBMQsrWbopgL6dU', 'A'),
(13, 'Registrado', 'Ani', 'animal', '$argon2id$v=19$m=1024,t=5,p=5$0XUwTQDB6mZOgrUIc7NCEg$prDYIuKcDw8O83/A7/oUijE6sagova9ELczJzT6V5LY', 'A');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
