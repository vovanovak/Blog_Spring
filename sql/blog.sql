-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Сен 22 2014 г., 14:48
-- Версия сервера: 5.6.16
-- Версия PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `blog`
--

-- --------------------------------------------------------

--
-- Структура таблицы `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) NOT NULL,
  `commentbody` text NOT NULL,
  `commentdate` date NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Дамп данных таблицы `comment`
--

INSERT INTO `comment` (`id`, `postid`, `commentbody`, `commentdate`, `userid`) VALUES
(1, 20, '123', '2014-09-17', 1),
(2, 20, '1234', '2014-09-17', 1),
(3, 20, '12345', '2014-09-17', 1),
(4, 20, 'new', '2014-09-17', 1),
(5, 21, 'new', '2014-09-17', 1),
(6, 21, 'n', '2014-09-17', 1),
(7, 22, 'Blablabla', '2014-09-17', 16),
(8, 23, 'dashsdhasdhs', '2014-09-18', 1),
(9, 17, 'jquery', '2014-09-18', 1),
(10, 28, 'comment', '2014-09-18', 1),
(11, 29, 'sadhasdhasdhasdh', '2014-09-18', 1),
(12, 30, 'asdhjsdhijsodahji', '2014-09-18', 21),
(13, 32, 'newcomment\r\n', '2014-09-19', 16),
(14, 32, 'sadfhjsdhsdh', '2014-09-19', 16),
(15, 32, 'komment', '2014-09-19', 16),
(16, 32, 'afdjsdfjsdj', '2014-09-19', 16),
(17, 32, 'ahsdsdhasdh', '2014-09-19', 22),
(18, 32, 'J', '2014-09-19', 22),
(19, 32, 'asdhsdhsdh', '2014-09-19', 22),
(20, 32, 'adsfhjsdfjadfjafdj', '2014-09-19', 22),
(21, 32, 'adfjadsfjadfj', '2014-09-19', 22),
(22, 32, 'adswhasfjasfdjasdfj', '2014-09-19', 22),
(23, 37, 'adsophsidhjiasdhisodah', '2014-09-19', 22),
(24, 36, 'Hi', '2014-09-19', 22),
(25, 35, 'sadhasdhasdh', '2014-09-19', 22),
(26, 41, 'asdojhgjshdiasodh', '2014-09-19', 22),
(27, 36, 'sfdhsfdohasdfkpa', '2014-09-22', 25),
(28, 36, 'user2209', '2014-09-22', 25),
(29, 36, 'new', '2014-09-22', 25);

-- --------------------------------------------------------

--
-- Структура таблицы `config`
--

CREATE TABLE IF NOT EXISTS `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `element` varchar(64) NOT NULL,
  `property` varchar(64) NOT NULL,
  `value` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `config`
--

INSERT INTO `config` (`id`, `userid`, `element`, `property`, `value`) VALUES
(1, 22, '.poster', 'color', 'red');

-- --------------------------------------------------------

--
-- Структура таблицы `like1`
--

CREATE TABLE IF NOT EXISTS `like1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Дамп данных таблицы `like1`
--

INSERT INTO `like1` (`id`, `postid`, `userid`) VALUES
(1, 23, 1),
(2, 17, 1),
(3, 28, 1),
(4, 28, 1),
(5, 29, 1),
(6, 30, 21),
(9, 22, 16),
(20, 32, 16),
(21, 36, 16),
(23, 37, 22),
(24, 36, 22),
(25, 35, 22),
(26, 36, 25),
(27, 42, 25);

-- --------------------------------------------------------

--
-- Структура таблицы `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postheader` varchar(128) NOT NULL,
  `postbody` text NOT NULL,
  `postdate` date NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Дамп данных таблицы `post`
--

INSERT INTO `post` (`id`, `postheader`, `postbody`, `postdate`, `userid`) VALUES
(16, 'new', '123', '2014-09-15', 1),
(17, 'hewaf', '123', '2014-09-15', 1),
(18, 'newq', '123', '2014-09-15', 1),
(19, 'bebebe', '123', '2014-09-15', 1),
(20, '123', '123', '2014-09-17', 1),
(21, 'header', '123', '2014-09-17', 1),
(22, 'Newuser', '123', '2014-09-17', 16),
(23, 'sdhdasjhosihodjisad', 'hasdjhispodh', '2014-09-17', 1),
(24, 'asdjhiasdhjoiasdh', ' asdhsdhasdhasdh', '2014-09-18', 1),
(25, 'ddsahjsdjoha', 'dahsdhjasdhjioa\r\nadshajsdjhiasdhojiasd\r\nasdhjisdahiojasdhjoi\r\nasdhasjodhasijodh', '2014-09-18', 1),
(26, 'dsahasdhasdh', 'asdhasdhasdhasdh\r\ndashoksdhpokasdopha\r\nasdpohpasdpohaospkdhok\r\nasdhaposkdhkopasdokhasodpk\r\nasdophasdokpaospdkh', '2014-09-18', 1),
(27, 'adshsdh', 'sadhasdhasdh\r\nsadhoaskdhopas\r\nasdhokpasdhasdh', '2014-09-18', 1),
(28, 'dhasdh', 'dashasdhasdha\r\nasdhkoasdhpo\r\ndsahaokdskopasdophasdhasdojhasdjhosdhasdreha asdhsdhasdh', '2014-09-18', 1),
(29, 'asdhsdhhasdh', '', '2014-09-18', 1),
(30, 'adsjogiasdjhasjodhjoasdhisoad', 'ashdasdjosdhsdhasjdhsdh\r\nasdhasdhojiasdhasodhijasdhasd\r\nasdhjsadhjoiasdhsdhoiasijodasdhoij', '2014-09-18', 21),
(31, 'dsahasdhsdh', 'adshjsdhdhjasdjhsdj', '2014-09-19', 16),
(32, 'afdsjsdj', 'asdjsdjsdjsdj', '2014-09-19', 16),
(33, 'dssahpodahpdishdxpo', 'oedahgjpsdhjsdhiasdphasdh', '2014-09-19', 16),
(34, 'abc def', 'asdhsdhasdh', '2014-09-19', 16),
(35, 'abc vgb', 'asdhsdhsdhsdh', '2014-09-19', 16),
(36, 'abc bmdsadgh', 'adshasdhsdh', '2014-09-19', 16),
(37, 'bcd', 'dsahasdohsjdhoisadoijhasdho', '2014-09-19', 22),
(38, 'Post about CPUs', 'adshasdhasdhasdh', '2014-09-19', 22),
(39, 'Asdkoas', 'dsajosdohjaisdhas\r\ndasdhjisodahosdohja\r\nasdhasjdhiosadohjiasdhoias\r\ndaasodjihasodhisdjohiaisjdh', '2014-09-19', 22),
(40, 'sdahsdh', 'sadhsdhasdhasdh', '2014-09-19', 22),
(41, 'oisdaohsodhioa', 'afhisodahijosadhoa\r\ndasjhsdhoiasdhoig', '2014-09-19', 22),
(42, 'header', 'new', '2014-09-22', 25);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `username`) VALUES
(15, 'newuser@gmail.com', '123', 'userw4t5'),
(16, 'mail@gmail.com', '123', 'newuser'),
(22, '123@gmail.com', '123', 'Vova'),
(24, 'voavn@gmail.com', '123', 'voavn'),
(25, 'user2209@gmail.com', '123', 'user2209');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
