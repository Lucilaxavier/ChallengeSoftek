const Apoio = require('../models/Apoio');
const Log = require('../models/Log');

exports.createApoio = async (req, res) => {
  try {
    const { tipo, descricao, contato } = req.body;
    const apoio = new Apoio({ tipo, descricao, contato });
    await apoio.save();
    await Log.create({ usuario: req.user.id, acao: 'Novo Canal de Apoio', detalhes: `Canal de apoio criado.` });
    res.status(201).json(apoio);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao criar canal de apoio.', error: err });
  }
};

exports.getApoios = async (req, res) => {
  try {
    const apoios = await Apoio.find();
    res.json(apoios);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar canais de apoio.', error: err });
  }
};

exports.getApoioById = async (req, res) => {
  try {
    const apoio = await Apoio.findById(req.params.id);
    if (!apoio) return res.status(404).json({ message: 'Canal de apoio não encontrado.' });
    res.json(apoio);
  } catch (err) {
    res.status(500).json({ message: 'Erro ao buscar canal de apoio.', error: err });
  }
};
