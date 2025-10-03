const Avaliacao = require('../models/Avaliacao');
const Log = require('../models/Log');

exports.createAvaliacao = async (req, res) => {
  try {
    const { respostas, risco } = req.body;
    const avaliacao = new Avaliacao({
      usuario: req.user.id,
      respostas,
      risco
    });
    await avaliacao.save();
    await Log.create({ usuario: req.user.id, acao: 'Nova Avaliação', detalhes: `Avaliação criada.` });
    res.status(201).json(avaliacao);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao criar avaliação.', error: err });
  }
};

exports.getMinhasAvaliacoes = async (req, res) => {
  try {
    const avaliacoes = await Avaliacao.find({ usuario: req.user.id });
    res.json(avaliacoes);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar avaliações.', error: err });
  }
};

exports.getAvaliacaoById = async (req, res) => {
  try {
    const avaliacao = await Avaliacao.findOne({ _id: req.params.id, usuario: req.user.id });
    if (!avaliacao) return res.status(404).json({ message: 'Avaliação não encontrada.' });
    res.json(avaliacao);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar avaliação.', error: err });
  }
};
