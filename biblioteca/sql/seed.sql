USE biblioteca;

INSERT INTO livros (titulo, autor, ano, disponivel)
SELECT 'Dom Casmurro', 'Machado de Assis', 1899, TRUE
WHERE NOT EXISTS (
  SELECT 1 FROM livros WHERE titulo = 'Dom Casmurro' AND autor = 'Machado de Assis'
);

INSERT INTO livros (titulo, autor, ano, disponivel)
SELECT 'O Cortico', 'Aluisio Azevedo', 1890, FALSE
WHERE NOT EXISTS (
  SELECT 1 FROM livros WHERE titulo = 'O Cortico' AND autor = 'Aluisio Azevedo'
);

INSERT INTO livros (titulo, autor, ano, disponivel)
SELECT 'Grande Sertao: Veredas', 'Guimaraes Rosa', 1956, TRUE
WHERE NOT EXISTS (
  SELECT 1 FROM livros WHERE titulo = 'Grande Sertao: Veredas' AND autor = 'Guimaraes Rosa'
);

INSERT INTO livros (titulo, autor, ano, disponivel)
SELECT 'Capitaes da Areia', 'Jorge Amado', 1937, FALSE
WHERE NOT EXISTS (
  SELECT 1 FROM livros WHERE titulo = 'Capitaes da Areia' AND autor = 'Jorge Amado'
);

-- Usuario inicial para testes de login (trocar para hash de senha na etapa de seguranca)
INSERT INTO usuarios (nome, email, senha, perfil)
SELECT 'Administrador', 'admin@biblioteca.com', '123456', 'ADMIN'
WHERE NOT EXISTS (
  SELECT 1 FROM usuarios WHERE email = 'admin@biblioteca.com'
);

