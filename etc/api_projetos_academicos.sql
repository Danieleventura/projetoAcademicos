create schema api_projetos_academicos;

use api_projetos_academicos;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `matricula` int(12) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `fk_endereco_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `matricula`, `nome`, `cpf`, `curso`, `fk_endereco_id`) VALUES
(2, 125658, 'Daniele', '586.568.598-70', 'Eng. da Computação', 2),
(3, 167686, 'Mariana', '586.568.598-70', 'Eng. da Computação', 3);

-- --------------------------------------------------------
--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `matricula` int(12) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `fk_endereco_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id`, `matricula`, `nome`, `curso`, `fk_endereco_id`) VALUES
(2, 125658, 'Demetrio', 'Eng. da Computação', 2),
(3, 167686, 'Gomes', 'Eng. da Computação', 3);

-- --------------------------------------------------------
--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `numero` varchar(8) DEFAULT NULL,
  `cep` varchar(14) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `rua`, `numero`, `cep`, `cidade`, `estado`, `pais`) VALUES
(2, 'Rua 2', '80', '58.415-200', 'Campina Grande', 'PB', 'BR'),
(3, 'Rua 5', '70', '58.415-200', 'Campina Grande', 'PB', 'BR'),
(4, 'Rua 5', '60', '58.415-200', 'Campina Grande', 'PB', 'BR'),
(5, 'Rua 5', '50', '58.415-200', 'Campina Grande', 'PB', 'BR');
-- --------------------------------------------------------
--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `area_projeto` varchar(255) DEFAULT NULL,
  `resumo` varchar(3000) DEFAULT NULL,
  `palavra_chave1` varchar(50) DEFAULT NULL,
  `palavra_chave2` varchar(50) DEFAULT NULL,
  `palavra_chave3` varchar(50) DEFAULT NULL,
  `url_documento` varchar(255) DEFAULT NULL,
  `fk_professor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `projeto`
--
INSERT INTO `projeto` (`id`, `titulo`, `area_projeto`, `resumo`, `palavra_chave1`, `palavra_chave2`, `palavra_chave3`, `url_documento`, `fk_professor_id`) VALUES
(1, 'Robótica', 'computação', 'Desenvolvimento de IA', 'robô', 'uepb', 'laboratoio', 'www.robotica.com', 2),
(2, 'Cibersegurança', 'computação', 'Estudo da segurança do usuario', 'segurança', 'phishing', 'senhas', 'www.phishing.com', 3);
-- --------------------------------------------------------
--
-- Estrutura da tabela `lista_alunos`
--

CREATE TABLE `lista_alunos` (
   `fk_projeto_id` int(11) NOT NULL,
    `fk_aluno_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Extraindo dados da tabela `lista_alunos`
--
	INSERT INTO `lista_alunos` (`fk_projeto_id`,  `fk_aluno_id`) VALUES
	(1, 2),
	(2, 3);
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_endereco` (`fk_endereco_id`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_endereco` (`fk_endereco_id`);
  
--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_professor_id` (`fk_professor_id`);

--
-- Índices para tabela `lista_alunos`
--
ALTER TABLE `lista_alunos`
  ADD PRIMARY KEY (`fk_projeto_id`, `fk_aluno_id`),
  ADD KEY `fk_projeto_id` (`fk_projeto_id`),
  ADD KEY `fk_aluno_id` (`fk_aluno_id`);
--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
  
--
-- AUTO_INCREMENT de tabela `projeto`
--
ALTER TABLE `projeto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
  
--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_endereco` FOREIGN KEY (`fk_endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `fk_endereco` FOREIGN KEY (`fk_endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `fk_professor` FOREIGN KEY (`fk_professor_id`) REFERENCES `professor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

--
-- Limitadores para a tabela `lista_alunos`
--
ALTER TABLE `lista_alunos`
  ADD CONSTRAINT `fk_projeto` FOREIGN KEY (`fk_projeto_id`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aluno` FOREIGN KEY (`fk_aluno_id`) REFERENCES `aluno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;
