const express = require('express');
const router = express.Router();
const logController = require('../controllers/logController');
const auth = require('../middlewares/auth');

router.get('/', auth, logController.getMeusLogs);
router.get('/:id', auth, logController.getLogById);

module.exports = router;
