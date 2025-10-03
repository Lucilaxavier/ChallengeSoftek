const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const User = require('../models/User');
const Log = require('../models/Log');

exports.register = async (req, res) => {
  try {
    const { nome, email, senha, cargo } = req.body;
    const userExists = await User.findOne({ email });
    if (userExists) return res.status(400).json({ message: 'Email já cadastrado.' });

    const hashedPassword = await bcrypt.hash(senha, 10);
    const user = new User({ nome, email, senha: hashedPassword, cargo });
    await user.save();

    await Log.create({ usuario: user._id, acao: 'Cadastro', detalhes: `Usuário ${email} cadastrado.` });
    res.status(201).json({ message: 'Usuário cadastrado com sucesso.' });
  } catch (err) {
    res.status(500).json({ message: 'Erro no cadastro.', error: err });
  }
};

exports.login = async (req, res) => {
  try {
    const { email, senha } = req.body;
    const user = await User.findOne({ email });
    if (!user) return res.status(400).json({ message: 'Usuário não encontrado.' });

    const validPassword = await bcrypt.compare(senha, user.senha);
    if (!validPassword) return res.status(401).json({ message: 'Senha incorreta.' });

    const token = jwt.sign({ id: user._id }, process.env.JWT_SECRET, { expiresIn: '1d' });
    await Log.create({ usuario: user._id, acao: 'Login', detalhes: `Usuário ${email} logou.` });
    res.json({ token });
  } catch (err) {
    res.status(500).json({ message: 'Erro no login.', error: err });
  }
};
