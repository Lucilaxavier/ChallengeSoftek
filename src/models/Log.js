const mongoose = require('mongoose');

const LogSchema = new mongoose.Schema({
  usuario: { type: mongoose.Schema.Types.ObjectId, ref: 'User' },
  acao: { type: String, required: true },
  detalhes: { type: String },
  criadoEm: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Log', LogSchema);
