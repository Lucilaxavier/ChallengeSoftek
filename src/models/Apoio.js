const mongoose = require('mongoose');

const ApoioSchema = new mongoose.Schema({
  tipo: { type: String, required: true },
  descricao: { type: String },
  contato: { type: String },
  criadoEm: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Apoio', ApoioSchema);
