INSERT INTO EMPRESA (CNPJ, NOMEFANTASIA, RAZAOSOCIAL, ENDERECO)
    VALUES ('12345678901234', 'Os Argentinos', 'Mao de Dois LTDA.', 'Rua Bom Nos Ares, 123');
INSERT INTO EMPRESA (CNPJ, NOMEFANTASIA, RAZAOSOCIAL, ENDERECO)
    VALUES ('43210987654321', 'Iceland Ice Cream', 'Islandeses Que Fazem Sorvete SA', 'Rua de Teste Mesmo, 1222');
INSERT INTO EMPRESA (CNPJ, NOMEFANTASIA, RAZAOSOCIAL, ENDERECO)
    VALUES ('11223344556677', 'CP Produ��es', 'Canarinho Bravo Marketing Social', 'Rua dos Pintassilgos, 6');
INSERT INTO EMPRESA (CNPJ, NOMEFANTASIA, RAZAOSOCIAL, ENDERECO)
    VALUES ('77665544332211', 'Marrocos Motors', 'Motores Marroquinhos - ME', 'Rua Contra, 1');
    
INSERT INTO FORNECEDORA (CNPJ) VALUES ('43210987654321');
INSERT INTO FORNECEDORA (CNPJ) VALUES ('12345678901234');
INSERT INTO FORNECEDORA (CNPJ) VALUES ('11223344556677');

INSERT INTO CONTRATANTE (CNPJ) VALUES ('12345678901234');
INSERT INTO CONTRATANTE (CNPJ) VALUES ('11223344556677');
INSERT INTO CONTRATANTE (CNPJ) VALUES ('77665544332211');

INSERT INTO CONTATOEMPRESA (EMPRESA, EMAIL, NOME, TELEFONE)
    VALUES ('11223344556677', 'ney@brasil.gov.br', 'Menino Ney', NULL);
INSERT INTO CONTATOEMPRESA (EMPRESA, EMAIL, NOME, TELEFONE)
    VALUES ('11223344556677', 'coutinho@brasil.gov.br', 'Mr. Coutinho', NULL);
INSERT INTO CONTATOEMPRESA (EMPRESA, EMAIL, NOME, TELEFONE)
    VALUES ('12345678901234', 'froze@iceland.com', 'Princesa da Froze', '41998731123');

INSERT INTO LOCAL (NOME, CIDADE, ESTADO, RUA, NUMERO, MAXFREQUENTADORES, POSSUIABERTURA, DIARIALOCACAO)
    VALUES ('Morumbi', 'S�o Paulo', 'S�o Paulo', 'Rua dos Craques', 1233, 50000, 'S', 40000.0);
INSERT INTO LOCAL (NOME, CIDADE, ESTADO, RUA, NUMERO, MAXFREQUENTADORES, POSSUIABERTURA, DIARIALOCACAO)
    VALUES ('Maracan�', 'Rio de Janeiro', 'Rio de Janeiro', 'Rua Principal', 2145, 65000, 'N', 55000.0);
INSERT INTO LOCAL (NOME, CIDADE, ESTADO, RUA, NUMERO, MAXFREQUENTADORES, POSSUIABERTURA, DIARIALOCACAO)
    VALUES ('O Sal�o de Festas', 'Bras�lia', 'Distrito Federal', 'Rua 13', 134, 300, 'N', 8500.0);
    
INSERT INTO FESTA (ID, CONTRATANTE, DATA, NOME, HORAINICIO, DURACAO, TIPOFESTA)
    VALUES (1, '11223344556677', TO_DATE('24/08/2018', 'dd/mm/yyyy'), 'Food Fan Fest', TO_DATE('11:00', 'hh:mi'), TO_DATE('06:00', 'hh:mi'), 'FESTFOOD');
INSERT INTO FESTA (ID, CONTRATANTE, DATA, NOME, HORAINICIO, DURACAO, TIPOFESTA)
    VALUES (2, '77665544332211', TO_DATE('11/08/2018', 'dd/mm/yyyy'), 'Food Motor Fest', TO_DATE('11:00', 'hh:mi'), TO_DATE('06:00', 'hh:mi'), 'FESTFOOD');
INSERT INTO FESTA (ID, CONTRATANTE, DATA, NOME, HORAINICIO, DURACAO, TIPOFESTA)
    VALUES (3, '11223344556677', TO_DATE('11/05/2018', 'dd/mm/yyyy'), 'Lan�amento do Boneco Canarinho', TO_DATE('11:00', 'hh:mi'), TO_DATE('06:00', 'hh:mi'), 'COQUETEL');
INSERT INTO FESTA (ID, CONTRATANTE, DATA, NOME, HORAINICIO, DURACAO, TIPOFESTA)
    VALUES (4, '12345678901234', TO_DATE('22/05/2018', 'dd/mm/yyyy'), 'Nova Campanha 2019', TO_DATE('11:00', 'hh:mi'), TO_DATE('06:00', 'hh:mi'), 'COQUETEL');

INSERT INTO FESTFOOD (FESTA, PRECOINGRESSO) VALUES (1, 100.00);
INSERT INTO FESTFOOD (FESTA, PRECOINGRESSO) VALUES (2, 50.00);

INSERT INTO COQUETEL (FESTA, ORCAMENTO, LOCAL, CIDADE)
    VALUES (3, 0.0, 'O Sal�o de Festas', 'Bras�lia');
INSERT INTO COQUETEL (FESTA, ORCAMENTO, LOCAL, CIDADE)
    VALUES (4, 0.0, 'O Sal�o de Festas', 'Bras�lia');
    
INSERT INTO BRINDE (COQUETEL, NOME, DESCRICAO)
    VALUES (3, 'Botton Canarinho', 'Verde e amarelo com o personagem no centro.');
INSERT INTO BRINDE (COQUETEL, NOME, DESCRICAO)
    VALUES (3, 'P�ster Canarinho', 'A4, verde e amarelo, com detalhes em azul.');
    
INSERT INTO CONVIDADO (EMAIL, NOME, TELEFONE)
    VALUES ('tite@bilidade.com', 'Tite', NULL);
INSERT INTO CONVIDADO (EMAIL, NOME, TELEFONE)
    VALUES ('mara@dona.com', 'Dona Mara', '12345678901');
    
INSERT INTO CONVITE (CONVIDADO, COQUETEL) VALUES ('tite@bilidade.com', 3);
INSERT INTO CONVITE (CONVIDADO, COQUETEL) VALUES ('mara@dona.com', 4);

INSERT INTO LOCACAO (ID, FESTFOOD, NOMELOCAL, CIDADELOCAL) VALUES (1, 1, 'Morumbi', 'S�o Paulo');
INSERT INTO LOCACAO (ID, FESTFOOD, NOMELOCAL, CIDADELOCAL) VALUES (2, 2, 'Maracan�', 'Rio de Janeiro');

INSERT INTO LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO)
    VALUES (1, 1, '43210987654321', 3000.0, 10.0, 5.0);
INSERT INTO LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO)
    VALUES (1, 2, '12345678901234', 3000.0, 10.0, 5.0);
INSERT INTO LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO)
    VALUES (1, 3, NULL, 3000.0, 10.0, 5.0);
INSERT INTO LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO)
    VALUES (2, 1, '43210987654321', 3000.0, 10.0, 5.0);
INSERT INTO LOTE (LOCACAO, NUMERO, FORNECEDORA, PRECO, LARGURA, COMPRIMENTO)
    VALUES (2, 2, '12345678901234', 3000.0, 10.0, 5.0);


INSERT INTO INGRESSO (FESTFOOD, NUMERO, CPFCOMPRADOR) VALUES (1, 100100, '12312312312');
INSERT INTO INGRESSO (FESTFOOD, NUMERO, CPFCOMPRADOR) VALUES (1, 200200, '99988888877');
INSERT INTO INGRESSO (FESTFOOD, NUMERO, CPFCOMPRADOR) VALUES (2, 444444, '99988888877');
INSERT INTO INGRESSO (FESTFOOD, NUMERO, CPFCOMPRADOR) VALUES (2, 455554, '66666688877');
INSERT INTO INGRESSO (FESTFOOD, NUMERO, CPFCOMPRADOR) VALUES (2, 666664, '77777777777');

INSERT INTO FORNECIMENTOCOQUETEL (FORNECEDORA, COQUETEL, PRECO)
    VALUES ('43210987654321', 3, 5000.0);
INSERT INTO FORNECIMENTOCOQUETEL (FORNECEDORA, COQUETEL, PRECO)
    VALUES ('12345678901234', 3, 2000.0);
    
INSERT INTO PRODUTOSFORNECIDOS (FORNECEDORA, COQUETEL, NOME, QUANTIDADE)
    VALUES ('43210987654321', 3, 'Sorvete de Abacaxi Su��o', 200);
INSERT INTO PRODUTOSFORNECIDOS (FORNECEDORA, COQUETEL, NOME, QUANTIDADE)
    VALUES ('12345678901234', 3, 'Coxinha de Frango', 500); 
    
INSERT INTO CATEGORIAFORNECIMENTO (NOMEREF, DESCRICAO)
    VALUES ('Sorvetes', 'Sorvetes e picol�s em geral.');
INSERT INTO CATEGORIAFORNECIMENTO (NOMEREF, DESCRICAO)
    VALUES ('Salgadinhos', 'Kibes, esfihas, coxinhas e outros petiscos fritos e assados.');
    
INSERT INTO ATRIBUICAOCATEGORIA (FORNECEDORA, CATEGORIA, FAIXAPRECO)
    VALUES ('43210987654321', 'Sorvetes', '4');
INSERT INTO ATRIBUICAOCATEGORIA (FORNECEDORA, CATEGORIA, FAIXAPRECO)
    VALUES ('43210987654321', 'Salgadinhos', '2');
INSERT INTO ATRIBUICAOCATEGORIA (FORNECEDORA, CATEGORIA, FAIXAPRECO)
    VALUES ('11223344556677', 'Sorvetes', '4');    
INSERT INTO ATRIBUICAOCATEGORIA (FORNECEDORA, CATEGORIA, FAIXAPRECO)
    VALUES ('12345678901234', 'Sorvetes', '2');     

INSERT INTO FUNCIONARIO (CPF, RG, ESTADO, NOME, CIDADE, RUA, NUMERO, EMAIL, TELRESIDENCIAL, TELCELULAR, VALORPORHORA, FUNCAO)
    VALUES ('12345678912', '233321345', 'Bahia', 'Fulano', 'Vit�ria da Conquista', 'Rua Vit�ria', 111, 'fulano@bol.com.br', NULL, NULL, 150.0, 'SEGURAN�A');
INSERT INTO FUNCIONARIO (CPF, RG, ESTADO, NOME, CIDADE, RUA, NUMERO, EMAIL, TELRESIDENCIAL, TELCELULAR, VALORPORHORA, FUNCAO)
    VALUES ('11115678912', '244321345', 'Bahia', 'Max', 'Vit�ria da Conquista', 'Rua Vit�ria', 1234, 'max@bol.com.br', NULL, NULL, 450.0, 'SEGURAN�A');
INSERT INTO FUNCIONARIO (CPF, RG, ESTADO, NOME, CIDADE, RUA, NUMERO, EMAIL, TELRESIDENCIAL, TELCELULAR, VALORPORHORA, FUNCAO)
    VALUES ('56354211123', '886353421', 'Sergipe', 'Ciclano', 'Aracaju', 'Rua Dez', 1010, 'ciclano@zipmail.com.br', NULL, NULL, 120.0, 'GAR�OM');
INSERT INTO FUNCIONARIO (CPF, RG, ESTADO, NOME, CIDADE, RUA, NUMERO, EMAIL, TELRESIDENCIAL, TELCELULAR, VALORPORHORA, FUNCAO)
    VALUES ('00054211123', '116353421', 'Bahia', 'Mano', 'Aracaju', 'Rua Onze', 1111, '11@zipmail.com.br', NULL, NULL, 555.0, 'GAR�OM');


INSERT INTO CONTRATOCOQUETEL (COQUETEL, FUNCIONARIO, HORASTRABALHADAS, VALORPAGO) VALUES (3, '12345678912', 2, 300.0);
INSERT INTO CONTRATOCOQUETEL (COQUETEL, FUNCIONARIO, HORASTRABALHADAS, VALORPAGO) VALUES (3, '56354211123', 2, 240.0);

INSERT INTO CONTRATOFESTFOOD (FESTFOOD, SEGURANCA, HORASTRABALHADAS, VALORPAGO) VALUES (1, '12345678912', 2, 300.0);
INSERT INTO CONTRATOFESTFOOD (FESTFOOD, SEGURANCA, HORASTRABALHADAS, VALORPAGO) VALUES (2, '12345678912', 2, 300.0);

COMMIT;
