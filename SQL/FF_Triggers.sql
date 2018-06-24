-- COMANDOS DE TRIGGERS, FUNCTIONS E PROCEDURES

-- FESTA_ID_SEQ: sequência usada para fazer o autoincremento do ID de Festa
CREATE SEQUENCE FESTA_ID_SEQ
    START WITH 10;

-- LOCACAO_ID_SEQ: sequência usada para fazer o autoincremento do ID de Locação 
CREATE SEQUENCE LOCACAO_ID_SEQ
    START WITH 10;

-- FESTA_AUTOINCREMENTO
-- Permite o autoincremento do atributo ID de Festa
CREATE OR REPLACE TRIGGER FESTA_AUTOINCREMENTO
    BEFORE INSERT ON FESTA -- antes da inserção de uma tupla em Festa
    FOR EACH ROW
    
    BEGIN
        IF (:NEW.ID IS NULL) THEN -- se o ID é nulo
            SELECT FESTA_ID_SEQ.NEXTVAL -- pegue o próximo da sequência
                INTO :NEW.ID -- e coloque como ID
                FROM DUAL;
        END IF;
    END;
/

-- LOCACAO_AUTOINCREMENTO
-- Permite o autoincremento do atributo ID de Locação
CREATE OR REPLACE TRIGGER LOCACAO_AUTOINCREMENTO
    BEFORE INSERT ON LOCACAO
    FOR EACH ROW
    
    BEGIN
        IF :NEW.ID IS NULL THEN -- se o ID é nulo
            SELECT LOCACAO_ID_SEQ.NEXTVAL -- pegue o próximo da sequência
            INTO :NEW.ID -- e coloque como ID
            FROM DUAL;  
        END IF;
    END;  
/

-- CONTRATO_CALCULAVALORPAGO
-- Calcula o valor pago a um funcionário por trabalhar em um evento.
CREATE OR REPLACE FUNCTION CONTRATO_CALCULAVALORPAGO (FUNC IN VARCHAR2, HORASTRAB IN NUMBER) 
    RETURN NUMBER
    IS VALPORHORA NUMBER(9,2);
    
    BEGIN
        SELECT MAX(VALORPORHORA) -- encontre o valor por hora do funcionario
            INTO VALPORHORA -- coloque na global VALPORHORA
            FROM FUNCIONARIO
            WHERE FUNC = FUNCIONARIO.CPF
            ORDER BY FUNCIONARIO.CPF;
        
        RETURN (VALPORHORA * HORASTRAB); -- multiplique o valor por hora e quanto ele trabalhou
    END;
/

-- CONTRATOCOQUETEL_VALORPAGO
-- Chama função para calcular valor pago a funcionário por trabalho em coquetel.
CREATE OR REPLACE TRIGGER CONTRATOCOQUETEL_VALORPAGO
    BEFORE INSERT OR UPDATE ON CONTRATOCOQUETEL -- ao inserir ou alterar um contrato de coquetel
    FOR EACH ROW
    
    BEGIN
        IF (:NEW.VALORPAGO IS NULL) THEN -- se o valor pago é nulo
            SELECT CONTRATO_CALCULAVALORPAGO(:NEW.FUNCIONARIO, :NEW.HORASTRABALHADAS) -- calcule-o
            INTO :NEW.VALORPAGO
            FROM DUAL;
        END IF;
    END;
/

-- CONTRATOFESTFOOD_VALORPAGO
-- Chama função para calcular valor pago a funcionário por trabalho em Fest Food.
CREATE OR REPLACE TRIGGER CONTRATOFESTFOOD_VALORPAGO
    BEFORE INSERT OR UPDATE ON CONTRATOFESTFOOD -- ao inserir ou alterar um contrato de Fest Food
    FOR EACH ROW
    
    BEGIN
        IF (:NEW.VALORPAGO IS NULL) THEN -- se o valor pago é nulo
            SELECT CONTRATO_CALCULAVALORPAGO(:NEW.SEGURANCA, :NEW.HORASTRABALHADAS) -- calcule-o
            INTO :NEW.VALORPAGO
            FROM DUAL;
        END IF;
    END;
/

-- COQUETEL_CALCULAORCAMENTO
-- Calcula o orçamento de um coquetel.
-- Deve ser chamado após cada insert/update em FORNECIMENTOCOQUETEL, COQUETEL ou CONTRATOCOQUETEL
-- Não está dentro de um trigger por problemas de "mutating table"
CREATE OR REPLACE PROCEDURE COQUETEL_CALCULAORCAMENTO (ID_COQ NUMBER)
    IS FORNECIMENTO NUMBER(9,2);
        DIARIA NUMBER(9,2);
        PAGAMENTOS NUMBER(9,2);
    BEGIN
        -- FORNECIMENTO DE ALIMENTOS
        SELECT SUM(PRECO)
            INTO FORNECIMENTO
            FROM FORNECIMENTOCOQUETEL
            WHERE COQUETEL = ID_COQ;         

        IF (FORNECIMENTO IS NULL) THEN FORNECIMENTO := 0.0; END IF;

       -- DIARIA DA LOCACAO
        SELECT L.DIARIALOCACAO
                INTO DIARIA
                FROM LOCAL L, COQUETEL COQ
                WHERE L.NOME = COQ.LOCAL
                    AND L.CIDADE = COQ.CIDADE
                    AND COQ.FESTA = ID_COQ;
                    
        IF (DIARIA IS NULL) THEN DIARIA := 0.0; END IF;

       -- PAGAMENTO DE FUNCIONARIOS
       SELECT SUM(VALORPAGO)
            INTO PAGAMENTOS
            FROM CONTRATOCOQUETEL
            WHERE COQUETEL = ID_COQ;
            
        IF (PAGAMENTOS IS NULL) THEN PAGAMENTOS := 0.0; END IF;

        -- ATUALIZAR ORCAMENTO
        UPDATE COQUETEL 
            SET ORCAMENTO = (FORNECIMENTO + DIARIA + PAGAMENTOS)
            WHERE FESTA = ID_COQ;
    END;
/