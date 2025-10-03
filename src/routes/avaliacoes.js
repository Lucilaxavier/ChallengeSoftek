const express = require('express');
const router = express.Router();
const avaliacaoController = require('../controllers/avaliacaoController');
const auth = require('../middlewares/auth');

router.post('/', auth, avaliacaoController.createAvaliacao);
router.get('/', auth, avaliacaoController.getMinhasAvaliacoes);
router.get('/:id', auth, avaliacaoController.getAvaliacaoById);

module.exports = router;
