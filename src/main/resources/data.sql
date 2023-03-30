INSERT INTO USUARIO(nome,email, senha) VALUES('Aluno1', 'aluno1@email.com','123456');
INSERT INTO USUARIO(nome,email, senha) VALUES('Aluno2', 'aluno2@email.com','1234567');
INSERT INTO USUARIO(nome,email, senha) VALUES('Aluno3', 'aluno3@email.com','1234568');

INSERT INTO CURSO(nome,categoria) VALUES('Spring Boot', 'Programacao');
INSERT INTO CURSO(nome,categoria) VALUES('HTML 5', 'Front-End');

INSERT INTO TOPICO(titulo,mensagem,data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Teste', SYSDATE,'Teste', 1,1);
INSERT INTO TOPICO(titulo,mensagem,data_criacao, status, autor_id, curso_id) VALUES('Dúvida2', 'Teste2', SYSDATE,'Teste2', 1,1);
INSERT INTO TOPICO(titulo,mensagem,data_criacao, status, autor_id, curso_id) VALUES('Dúvida3', 'Teste3', SYSDATE,'Teste3', 1,1);
