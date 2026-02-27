💰 OrgFinanceira API
API de Organização Financeira desenvolvida com Spring Boot, focada no controle de receitas e despesas com suporte a integrações externas via WhatsApp (EvolutionAPI) e n8n.

🚀 Sobre o Projeto
O OrgFinanceira é um sistema de backend robusto que permite aos usuários gerenciarem sua saúde financeira. O diferencial técnico deste projeto é a capacidade de realizar lançamentos e consultas diretamente via WhatsApp, utilizando um Agente de IA para processar mensagens naturais e converter em registros no banco de dados.

🛠️ Tecnologias Utilizadas

Java 17+

Spring Boot 3

Spring Data JPA (Persistência de dados)

Lombok (Produtividade)

Spring Security (Configurado para permitir integrações)

PostgreSQL/MySQL (Banco de dados relacional)

📋 Funcionalidades Principais

👤 Gestão de Usuários

Cadastro de usuários com vínculo de número de telefone para integração com Chatbots.

💸 Controle de Despesas

Registro de gastos com título, valor, descrição e método de pagamento.

Marcação de despesas recorrentes e status de pagamento.

Endpoint WhatsApp: Registro simplificado de despesas usando apenas o número do telefone como identificador.

📈 Controle de Receitas

Registro de entradas financeiras.

Listagem por usuário ou por telefone.

🔌 Integração com n8n & WhatsApp

A API foi desenhada para funcionar como o "cérebro" de uma automação:

O usuário envia: "Gastei 50 reais no mercado hoje" no WhatsApp.

A EvolutionAPI envia o Webhook para o n8n.

O n8n (via Agente AI) extrai os dados e faz um POST no endpoint /api/despesa/telefone/{telefone}.

O sistema identifica o usuário pelo telefone e salva a despesa automaticamente.

⚙️ Configuração do Ambiente

Clonar o repositório:

git clone https://github.com/matheuseterno/orgfinanceira.git

Configurar o Banco de Dados:

No arquivo src/main/resources/application.properties, configure suas credenciais e a porta do servidor:

server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/db_financeiro
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

Executar a aplicação:

mvn spring-boot:run

🛣️ Endpoints Principais:

POST    /api/despesa/telefone/{tel} Cria despesa vinculada ao telefone
GET     /api/despesa/telefone/{tel} Lista despesas de um usuário pelo telefone
POST    /api/receita/telefone/{tel} Cria receita vinculada ao telefone
GET     /api/receita/telefone/{tel} Lista receitas de um usuário pelo telefone
GET     /api/usuario/{id}           Busca dados do usuário

