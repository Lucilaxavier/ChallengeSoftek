const express = require('express');
const router = express.Router();
const apoioController = require('../controllers/apoioController');
const auth = require('../middlewares/auth');

router.post('/', auth, apoioController.createApoio);
router.get('/', auth, apoioController.getApoios);
router.get('/:id', auth, apoioController.getApoioById);

module.exports = router;
