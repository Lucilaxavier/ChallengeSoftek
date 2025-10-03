require('dotenv').config();
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const winston = require('winston');

const app = express();
app.use(express.json());
app.use(cors());

// Logger setup
const logger = winston.createLogger({
  level: 'info',
  format: winston.format.json(),
  transports: [
    new winston.transports.File({ filename: 'logs/app.log' })
  ]
});

// MongoDB connection
mongoose.connect(process.env.MONGO_URI, {
  useNewUrlParser: true,
  useUnifiedTopology: true
}).then(() => {
  logger.info('MongoDB conectado');
}).catch((err) => {
  logger.error('Erro ao conectar ao MongoDB', err);
});

// Rotas principais (serão importadas depois)
app.use('/api/auth', require('./routes/auth'));
app.use('/api/avaliacoes', require('./routes/avaliacoes'));
app.use('/api/diario', require('./routes/diario'));
app.use('/api/apoio', require('./routes/apoio'));
app.use('/api/usuarios', require('./routes/usuarios'));
app.use('/api/logs', require('./routes/logs'));

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  logger.info(`Servidor rodando na porta ${PORT}`);
  console.log(`Servidor rodando na porta ${PORT}`);
});
