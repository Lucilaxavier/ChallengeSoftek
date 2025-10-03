const express = require('express');
const router = express.Router();
const diarioController = require('../controllers/diarioController');
const auth = require('../middlewares/auth');

router.post('/', auth, diarioController.createDiario);
router.get('/', auth, diarioController.getMeusCheckins);
router.get('/:id', auth, diarioController.getCheckinById);

module.exports = router;
