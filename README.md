# Sistema de Controle de pagamentos simplificado do desafio PicPay

Consultar no seguinte repositório:

https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file

## Descrição
Nela é possível depositar e realizar transferências de dinheiro entre usuários. Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles.

### Requisitos


A seguir estão algumas regras de negócio que são importantes para o funcionamento do PicPay Simplificado:


- [x] Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail;

-[x] Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários;

-[x] Lojistas só recebem transferências, não enviam dinheiro para ninguém;

-[x] Validar se o usuário tem saldo antes da transferência;

-[ ] Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock https://util.devi.tools/api/v2/authorize para simular o serviço utilizando o verbo GET;

-[ ] A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia;

-[ ] No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock https://util.devi.tools/api/v1/notify)) para simular o envio da notificação utilizando o verbo POST;

-[ ] Este serviço deve ser RESTFul.



`````mermaid
---
title: Order example
---
erDiagram
    CUSTOMER ||--o{ TRANSACTION : places
    CUSTOMER {
        long id
        string firstName
        string lastName
        string document
        string email
        string password
        bigDecimal balance
        enum userType
    }
    TRANSACTION ||--|{ CUSTOMER : contains
    TRANSACTION {
        int id
        int receiver_id
        int sender_id
        timeStamp timestamp
    }
    

`````