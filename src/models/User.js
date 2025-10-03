const mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({
  nome: { type: String, required: true },
  email: { type: String, required: true, unique: true },
  senha: { type: String, required: true },
  cargo: { type: String },
  criadoEm: { type: Date, default: Date.now }
});

module.exports = mongoose.model('User', UserSchema);
