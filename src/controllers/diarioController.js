const Diario = require('../models/Diario');
const Log = require('../models/Log');

exports.createDiario = async (req, res) => {
  try {
    const { humor, comentario } = req.body;
    const diario = new Diario({
      usuario: req.user.id,
      humor,
      comentario
    });
    await diario.save();
    await Log.create({ usuario: req.user.id, acao: 'Novo Check-in', detalhes: `Check-in de humor realizado.` });
    res.status(201).json(diario);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao criar check-in.', error: err });
  }
};

exports.getMeusCheckins = async (req, res) => {
  try {
    const checkins = await Diario.find({ usuario: req.user.id });
    res.json(checkins);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar check-ins.', error: err });
  }
};

exports.getCheckinById = async (req, res) => {
  try {
    const checkin = await Diario.findOne({ _id: req.params.id, usuario: req.user.id });
    if (!checkin) return res.status(404).json({ message: 'Check-in não encontrado.' });
    res.json(checkin);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar check-in.', error: err });
  }
};
