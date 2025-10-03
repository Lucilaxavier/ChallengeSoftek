const mongoose = require('mongoose');

const AvaliacaoSchema = new mongoose.Schema({
  usuario: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  respostas: [{
    pergunta: String,
    resposta: String
  }],
  risco: { type: String },
  criadoEm: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Avaliacao', AvaliacaoSchema);
