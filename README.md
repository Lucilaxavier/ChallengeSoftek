# ChallengeSoftek

## Desafio FIAP
Coleta de informações a partir dos projetos, com base nas principais alterações da NR1, para que a Softtek crie um programa de apoio à saúde mental e psicossocial.

Esse programa da Softtek deverá oferecer aos Softtekians recursos como: terapia, grupos de apoio, programas de bem-estar e atividades que promovam a saúde mental e o bem-estar.

### O Desafio
Desenvolvimento de um aplicativo para auxiliar a Softtek no programa de saúde mental e psicossocial de seus funcionários.

### Objetivo
Desenvolver um aplicativo móvel para ajudar a Softtek a cumprir as exigências da nova legislação, promovendo um ambiente de trabalho saudável e engajando os colaboradores por meio de uma solução digital intuitiva e acolhedora.

## Descrição
Backend completo para o app de bem-estar emocional, em conformidade com a NR-1, focado em avaliações psicossociais, diário emocional, canais de apoio, registro de atividades e integração com aplicativo mobile.

## Tecnologias Utilizadas
- Node.js
- Express
- MongoDB (NoSQL)
- Mongoose
- JWT (autenticação)
- bcryptjs (hash de senha)
- Winston (logs)
- dotenv (variáveis de ambiente)
- Room/SQLite (persistência local no app mobile)
- Retrofit (consumo de API no app mobile)

## Estrutura do Projeto
```
/src
  /controllers
  /models
  /routes
  /middlewares
  /utils
  app.js
/.env
/logs
/app_kotlin (exemplo de integração mobile)
```

## Como Rodar o Projeto

1. Tenha o MongoDB rodando localmente (ou ajuste a variável `MONGO_URI` no arquivo `.env` para apontar para seu banco).
2. Instale as dependências:
   ```bash
   npm install
   ```
3. Execute o servidor:
   ```bash
   node src/app.js
   ```
4. O back-end estará disponível em `http://localhost:3000` (ou na porta definida no `.env`).

Você pode testar os endpoints usando ferramentas como Postman, Insomnia ou via integração com o app mobile.

Se precisar de scripts de inicialização, exemplos de requisições ou encontrar algum erro ao rodar, posso te ajudar a corrigir! Deseja que eu gere um script de start ou exemplos de uso dos endpoints?

## Endpoints Principais
### Autenticação
- `POST /api/auth/register` — Cadastro de usuário
- `POST /api/auth/login` — Login e geração de token JWT

### Usuário
- `GET /api/usuarios/me` — Perfil do usuário autenticado

### Avaliações Psicossociais
- `POST /api/avaliacoes` — Criar avaliação
- `GET /api/avaliacoes` — Listar avaliações do usuário
- `GET /api/avaliacoes/:id` — Buscar avaliação específica

### Diário Emocional
- `POST /api/diario` — Criar check-in de humor
- `GET /api/diario` — Listar check-ins do usuário
- `GET /api/diario/:id` — Buscar check-in específico

### Canais de Apoio
- `POST /api/apoio` — Criar canal de apoio
- `GET /api/apoio` — Listar canais de apoio
- `GET /api/apoio/:id` — Buscar canal específico

### Logs de Atividades
- `GET /api/logs` — Listar logs do usuário
- `GET /api/logs/:id` — Buscar log específico

## Segurança
- Autenticação JWT obrigatória para rotas protegidas
- Senhas armazenadas com hash (bcryptjs)
- Logs de atividades para auditoria

## Integração com App Mobile
- Exemplo de integração disponível em `/app_kotlin` (Kotlin, Android Studio)
- Identificador anônimo gerado localmente no app
- Persistência local com Room/SQLite
- Sincronização automática com o backend

## Requisitos Atendidos
- Avaliação de riscos psicossociais
- Diário emocional
- Canais de apoio
- Visualização e histórico de dados
- Registro de atividades
- Persistência local e sincronização
- Anonimato garantido
- Segurança e conformidade NR-1

## Como Testar
Utilize ferramentas como Postman ou Insomnia para testar os endpoints REST. Para integração mobile, utilize o exemplo Kotlin fornecido.

## Documentação Técnica
- Diagrama de arquitetura
- Especificação dos endpoints
- Modelo de dados NoSQL
- Estratégia de autenticação

## Observações
- Para produção, configure HTTPS e variáveis de ambiente seguras.
- O projeto está pronto para expansão e integração com outros módulos internos.

---

Desenvolvido por: [Lucila Xavier da Silva]