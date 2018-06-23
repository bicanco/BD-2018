-- COMANDOS PARA REALIZAR CONSULTAS AVANÇADAS NO BANCO DE DADOS

-- 1) Para uma locação, informar todos os lotes, o estado deles (adquiridos ou disponíveis) e,
-- caso possível, as empresas fornecedoras que os adquiriram.

-- ID_LOCACAO: id da locacao buscada

SELECT LT.NUMERO, LT.PRECO, LT.LARGURA, LT.COMPRIMENTO, EM.NOMEFANTASIA, LT.FORNECEDORA 
    FROM LOTE LT
        LEFT JOIN EMPRESA EM ON LT.FORNECEDORA = EM.CNPJ
    WHERE LOCACAO = /* ID_LOCACAO */ 1;
    
-- 2) (.........................)

-- 3) Para um funcionário, informar quais são as festas que ele trabalhou em certo período de tempo e o quanto ele deve receber.

-- DATA_MIN: data minima da busca (dd/mm/yyyy)
-- DATA_MAX: data maxima da busca (dd/mm/yyyy)
-- CPF_FUNC: cpf do funcionario buscado

SELECT F.NOME, F.DATA, F.CONTRATANTE, F.TIPOFESTA, C.VALORPAGO
    FROM FESTA F, CONTRATOCOQUETEL C
    WHERE F.ID = C.COQUETEL
        AND C.FUNCIONARIO = /* CPF_FUNC */ '12345678912'
        AND F.DATA >= TO_DATE(/* DATA_MIN */ '01/05/2018', 'dd/mm/yyyy')
        AND F.DATA <= TO_DATE(/* DATA_MAX */ '20/08/2018', 'dd/mm/yyyy')
UNION
SELECT F.NOME, F.DATA, F.CONTRATANTE, F.TIPOFESTA, C.VALORPAGO
    FROM FESTA F, CONTRATOFESTFOOD C
    WHERE F.ID = C.FESTFOOD
        AND C.SEGURANCA = /* CPF_FUNC */ '12345678912'
        AND F.DATA >= TO_DATE(/* DATA_MIN */ '01/05/2018', 'dd/mm/yyyy')
        AND F.DATA <= TO_DATE(/* DATA_MAX */ '20/08/2018', 'dd/mm/yyyy');
        
-- 4) Mostrar, dado um estado, a média salarial por hora de funcionários, organizados pela sua função, 
-- além do número de cada tipo de funcionário.

-- ESTADO: estado cujos funcionarios devem ser buscados

SELECT FUNCAO, COUNT(*) AS QUANTIDADE, AVG(VALORPORHORA) AS MEDIASALARIAL
    FROM FUNCIONARIO
    WHERE ESTADO = /* ESTADO */ 'Bahia'
    GROUP BY FUNCAO;
    
-- 5) Para uma categoria de fornecimento, mostrar qual é a faixa de preço mais comum e as empresas que 
-- fornecem esse tipo de alimento nesta faixa de preço

-- CATEGORIA: nome da categoria a ser buscada

SELECT E.NOMEFANTASIA, F.CNPJ, ATR.FAIXAPRECO
    FROM FORNECEDORA F, ATRIBUICAOCATEGORIA ATR, EMPRESA E
    WHERE E.CNPJ = F.CNPJ
        AND F.CNPJ = ATR.FORNECEDORA
        AND ATR.CATEGORIA = /* CATEGORIA */ 'Sorvetes'
        AND ATR.FAIXAPRECO =
            (SELECT STATS_MODE(FAIXAPRECO) FROM ATRIBUICAOCATEGORIA WHERE CATEGORIA = /* CATEGORIA */ 'Sorvetes');
            
-- 6) Mostrar todas as próximas Fest Foods que vão acontecer, com o número de lotes total, 
-- o número de lotes já vendidos e o número de ingressos já vendidos

WITH
    QING AS
    (SELECT FESTFOOD, COUNT(*) AS INGRESSOSVENDIDOS
        FROM INGRESSO
        GROUP BY FESTFOOD),
    QLOTE AS
    (SELECT LOCA.FESTFOOD, COUNT(LOTE.NUMERO) AS TOTALLOTES, COUNT(LOTE.FORNECEDORA) AS LOTESVENDIDOS
        FROM LOCACAO LOCA, LOTE
        WHERE LOCA.ID = LOTE.LOCACAO
        GROUP BY LOCA.FESTFOOD)
SELECT F.NOME, F.DATA, F.CONTRATANTE, QLOTE.TOTALLOTES, QLOTE.LOTESVENDIDOS, QING.INGRESSOSVENDIDOS
    FROM FESTA F, FESTFOOD FF, QING, QLOTE
    WHERE F.ID = FF.FESTA
        AND FF.FESTA = QING.FESTFOOD
        AND QING.FESTFOOD = QLOTE.FESTFOOD;