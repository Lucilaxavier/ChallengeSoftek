const Log = require('../models/Log');

exports.getMeusLogs = async (req, res) => {
  try {
    const logs = await Log.find({ usuario: req.user.id }).sort({ criadoEm: -1 });
    res.json(logs);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar logs.', error: err });
  }
};

exports.getLogById = async (req, res) => {
  try {
    const log = await Log.findOne({ _id: req.params.id, usuario: req.user.id });
    if (!log) return res.status(404).json({ message: 'Log não encontrado.' });
    res.json(log);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar log.', error: err });
  }
};
