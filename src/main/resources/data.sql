SET foreign_key_checks = 0;

TRUNCATE TABLE address;
TRUNCATE TABLE public_area;
TRUNCATE TABLE city;
TRUNCATE TABLE neighborhood;
TRUNCATE TABLE federal_unit;
TRUNCATE TABLE public_area_type;
TRUNCATE TABLE account_type;
TRUNCATE TABLE transaction_type;
TRUNCATE TABLE bank_account_transaction;
TRUNCATE TABLE email;
TRUNCATE TABLE ddi;
TRUNCATE TABLE ddd;
TRUNCATE TABLE phone;
TRUNCATE TABLE client;
TRUNCATE TABLE bank;
TRUNCATE TABLE agency;
TRUNCATE TABLE bank_account;

SET foreign_key_checks = 1;

INSERT INTO federal_unit (acronym, name) VALUES
                                             ('SP', 'São Paulo'),
                                             ('RJ', 'Rio de Janeiro'),
                                             ('MG', 'Minas Gerais'),
                                             ('ES', 'Espírito Santo'),
                                             ('BA', 'Bahia'),
                                             ('PE', 'Pernambuco'),
                                             ('PR', 'Paraná'),
                                             ('SC', 'Santa Catarina'),
                                             ('RS', 'Rio Grande do Sul'),
                                             ('GO', 'Goiás');

INSERT INTO city (name, federal_unit_acronym) VALUES
                                                  ('São Paulo', 'SP'),
                                                  ('Rio de Janeiro', 'RJ'),
                                                  ('Belo Horizonte', 'MG'),
                                                  ('Vitória', 'ES'),
                                                  ('Salvador', 'BA'),
                                                  ('Recife', 'PE'),
                                                  ('Curitiba', 'PR'),
                                                  ('Florianópolis', 'SC'),
                                                  ('Porto Alegre', 'RS'),
                                                  ('Goiânia', 'GO');

INSERT INTO public_area_type (acronym, name) VALUES
                                                 ('R', 'Rua'),
                                                 ('AV', 'Avenida'),
                                                 ('PR', 'Praça'),
                                                 ('AL', 'Alameda'),
                                                 ('TR', 'Travessa'),
                                                 ('ROD', 'Rodovia'),
                                                 ('V', 'Viela'),
                                                 ('CJ', 'Conjunto'),
                                                 ('QD', 'Quadra'),
                                                 ('CL', 'Clube');

INSERT INTO public_area (name, public_area_type_acronym) VALUES
                                                             ('Paulista', 'AV'),
                                                             ('Atlântica', 'AV'),
                                                             ('Afonso Pena', 'ROD'),
                                                             ('Nossa Senhora de Copacabana', 'R'),
                                                             ('Ipiranga', 'AV'),
                                                             ('Barra da Tijuca', 'R'),
                                                             ('Sete de Setembro', 'R'),
                                                             ('Boa Viagem', 'R'),
                                                             ('Beira-Mar', 'AV'),
                                                             ('XV de Novembro', 'R');

INSERT INTO neighborhood (name) VALUES
                                    ('Bela Vista'),
                                    ('Copacabana'),
                                    ('Savassi'),
                                    ('Centro'),
                                    ('Jardins'),
                                    ('Barra da Tijuca'),
                                    ('Boa Viagem'),
                                    ('Campo Grande'),
                                    ('Liberdade'),
                                    ('Moema');


INSERT INTO address (zip_code, neighborhood_id, public_area_id, city_id) VALUES
                                                                             ('01310-100', 1, 1, 1),
                                                                             ('22070-001',  2, 2, 2),
                                                                             ('30130-002', 3, 3, 3),
                                                                             ('29010-000', 4, 4, 4),
                                                                             ('40020-010',  5, 5, 5),
                                                                             ('50030-200',  6, 6, 6),
                                                                             ('82530-030',  7, 7, 7),
                                                                             ('88040-120',  8, 8, 8),
                                                                             ('90010-001',  9, 9, 9),
                                                                             ('74000-000',  10, 10, 10),
                                                                             ('22072-003', 2, 3, 2),
                                                                             ('30132-004', 3, 4, 3),
                                                                             ('29012-002', 4, 5, 4),
                                                                             ('40022-012', 5, 6, 5),
                                                                             ('50032-202', 6, 7, 6),
                                                                             ('82532-032', 7, 8, 7),
                                                                             ('88042-122', 8, 9, 8),
                                                                             ('90012-003', 9, 10, 9),
                                                                             ('74002-002', 10, 1, 10),
                                                                             ('74002-010', 10, 1, 10);

INSERT INTO account_type (name) VALUES ('Corrente');
INSERT INTO account_type (name) VALUES ('Poupança');
INSERT INTO account_type (name) VALUES ('Salário');
INSERT INTO account_type (name) VALUES ('Investimento');
INSERT INTO account_type (name) VALUES ('Empresarial');

INSERT INTO transaction_type (name, description, payment_method)
VALUES
    ('Pagamento de boleto', 'Pagamento de conta de energia', 0),
    ('Deposito', 'Recebimento de deposito', 1),
    ('Pagamento de PIX', 'Pagamento de PIX', 0),
    ('PIX recebido', 'Recebimento de PIX', 1);


-- Seed para a tabela bank_account_transaction


-- Seed para a tabela client utilizando valores numéricos para ClientType e nomes reais

INSERT INTO client (name, document_number, client_type, address_number, address_complement, address_id)
VALUES
    ('João Silva', '12345678901', 0, '100', 'Apartamento 1', 1),
    ('Maria Souza', '98765432100', 0, '200', 'Bloco B', 2),
    ('Carlos Oliveira', '45678912345', 0, '300', 'Casa 3', 3),
    ('Ana Pereira', '78912345678', 0, '400', 'Andar 4', 4),
    ('Empresa XYZ Ltda', '32165498700', 1, '500', 'Sala 5', 5),
    ('Comercial ABC S/A', '65498732112', 1, '600', 'Conjunto 6', 6),
    ('Fernando Lima', '98732165409', 0, '700', 'Cobertura 7', 7),
    ('Distribuidora DEF Ltda', '14725836900', 1, '800', 'Bloco H', 8),
    ('Luisa Mendes', '96385274102', 0, '900', 'Loja 9', 9),
    ('Construtora GHI S/A', '85296374111', 1, '1000', 'Andar 10', 10);

-- Seed para a tabela bank com alguns bancos fictícios


INSERT INTO email (email, client_id)
VALUES
    ('joao.silva@email.com', 1),
    ('maria.souza@email.com', 2),
    ('carlos.oliveira@email.com', 3),
    ('ana.pereira@email.com', 4),
    ('empresa.xyz@email.com', 5),
    ('comercial.abc@email.com', 6),
    ('fernando.lima@email.com', 7),
    ('distribuidora.def@email.com', 8),
    ('luisa.mendes@email.com', 9),
    ('construtora.ghi@email.com', 10);

INSERT INTO ddi (number) VALUES
                             (1),   -- Estados Unidos e Canadá
                             (55),  -- Brasil
                             (44),  -- Reino Unido
                             (33),  -- França
                             (49),  -- Alemanha
                             (34),  -- Espanha
                             (39),  -- Itália
                             (61),  -- Austrália
                             (81),  -- Japão
                             (86);  -- China

INSERT INTO ddd (number) VALUES
                             (11),  -- São Paulo
                             (21),  -- Rio de Janeiro
                             (31),  -- Minas Gerais
                             (41),  -- Paraná
                             (51),  -- Rio Grande do Sul
                             (61),  -- Distrito Federal
                             (71),  -- Bahia
                             (81),  -- Pernambuco
                             (85),  -- Ceará
                             (91);  -- Pará

INSERT INTO phone (number, ddd_number, ddi_number, client_id) VALUES
                                                                  ('91234-5678', 11, 55, 1),  -- João Silva
                                                                  ('98876-5432', 21, 55, 2),  -- Maria Souza
                                                                  ('97765-4321', 31, 55, 3),  -- Carlos Oliveira
                                                                  ('96654-3210', 41, 55, 4),  -- Ana Pereira
                                                                  ('95543-2109', 61, 55, 5),  -- Empresa XYZ Ltda
                                                                  ('94432-1098', 71, 55, 6),  -- Comercial ABC S/A
                                                                  ('93321-0987', 81, 55, 7),  -- Fernando Lima
                                                                  ('92210-9876', 85, 55, 8),  -- Distribuidora DEF Ltda
                                                                  ('91109-8765', 11, 55, 9),  -- Luisa Mendes
                                                                  ('90098-7654', 21, 55, 10);  -- Construtora GHI S/A

INSERT INTO bank (name)
VALUES
    ('Banco do Brasil'),
    ('Caixa Econômica Federal'),
    ('Itaú Unibanco'),
    ('Bradesco'),
    ('Santander'),
    ('Banco Inter'),
    ('Nubank'),
    ('BTG Pactual'),
    ('Banco Original'),
    ('C6 Bank');

INSERT INTO agency (agency_number, name, address_number, address_complement, address_id, bank_id)
VALUES
    ('101', 'Agência Paulista Nova', '10', 'Prédio 1', 11, 1),
    ('102', 'Agência Atlântica Nova', '20', 'Sala 5', 12, 2),
    ('103', 'Agência BH Nova', '30', 'Conjunto 10', 13, 3),
    ('104', 'Agência Vitória Nova', '40', 'Bloco E', 14, 4),
    ('105', 'Agência Salvador Nova', '50', 'Torre 8', 15, 5),
    ('106', 'Agência Recife Nova', '60', 'Andar 3', 16, 6),
    ('107', 'Agência Curitiba Nova', '70', 'Bloco F', 17, 7),
    ('108', 'Agência Florianópolis Nova', '80', 'Edifício G', 18, 8),
    ('109', 'Agência Porto Alegre Nova', '90', 'Sala H', 19, 9),
    ('110', 'Agência Goiânia Nova', '100', 'Prédio I', 20, 10);

-- Inserindo contas bancárias associadas a clientes e agências
INSERT INTO bank_account (account_number, opening_date, agency_account_agency_number, account_type_id, client_id)
VALUES
    ('12345-6','2024-09-01', '101', 1, 1),  -- Conta Corrente da Agência 1, Cliente 1
    ('23456-7', '2024-09-01', '102', 1, 2),  -- Conta Poupança da Agência 2, Cliente 2
    ('34567-8', '2024-09-01', '103', 3, 3),  -- Conta Salário da Agência 3, Cliente 3
    ('45678-9', '2024-09-01', '104', 4, 4),  -- Conta Investimento da Agência 4, Cliente 4
    ('56789-0', '2024-09-01', '105', 5, 5),  -- Conta Empresarial da Agência 5, Cliente 5
    ('67890-1', '2024-09-01', '106', 1, 1),   -- Conta Corrente da Agência 6, Cliente 1
    ('78901-2', '2024-09-01', '107', 2, 2),    -- Conta Poupança da Agência 7, Cliente 2
    ('89012-3', '2024-09-01', '108', 3, 3),    -- Conta Salário da Agência 8, Cliente 3
    ('90123-4', '2024-09-01', '109', 4, 4),    -- Conta Investimento da Agência 9, Cliente 4
    ('01234-5', '2024-09-01', '110', 5, 5);   -- Conta Empresarial da Agência 10, Cliente 5

INSERT INTO bank_account_transaction (transaction_date, amount, transaction_type_id, note, bank_account_account_number)
VALUES
    ('2024-09-01', 1500.00, 1, 'Saque em dinheiro', '12345-6'),    -- Transação associada à conta 1
    ('2024-09-02', 200.00, 2, 'Deposito em dinheiro', '23456-7'),    -- Transação associada à conta 1
    ('2024-09-03', 300.50, 3, 'Pagamento de conta de luz', '34567-8'),  -- Transação associada à conta 2
    ('2024-09-04', 500.00, 4, 'Transferência recebida', '45678-9'),  -- Transação associada à conta 1
    ('2024-09-05', 150.00, 1, 'Compra em supermercado', '56789-0'),  -- Transação associada à conta 2
    ('2024-09-06', 50.00, 2, 'Recebimento de PIX', '67890-1'),  -- Transação associada à conta 3
    ('2024-09-07', 100.00, 3, 'Pagamento de plano de celular', '78901-2'),  -- Transação associada à conta 3
    ('2024-09-08', 2500.00, 4, 'Depósito de salário', '89012-3'),  -- Transação associada à conta 4
    ('2024-09-09', 75.00, 1, 'Compra em restaurante', '90123-4'),  -- Transação associada à conta 4
    ('2024-09-10', 500.00, 2,'Recebimento de bônus', '01234-5'),  -- Transação associada à conta 5
    ('2024-09-11', 30.00, 3, 'Pagamento de transporte público', '12345-6'),  -- Transação associada à conta 5
    ('2024-09-12', 200.00, 4, 'Transferência recebida', '23456-7'),  -- Transação associada à conta 1
    ('2024-09-13', 700.00, 1, 'Pagamento de conta de internet', '34567-8'),  -- Transação associada à conta 2
    ('2024-09-14', 80.00, 2, 'Reembolso de compra', '45678-9'),  -- Transação associada à conta 3
    ('2024-09-15', 120.00, 3, 'Compra de roupas online', '56789-0');  -- Transação associada à conta 4
