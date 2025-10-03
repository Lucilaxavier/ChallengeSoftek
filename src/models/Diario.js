const mongoose = require('mongoose');

const DiarioSchema = new mongoose.Schema({
  usuario: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  humor: { type: String, required: true },
  comentario: { type: String },
  criadoEm: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Diario', DiarioSchema);
