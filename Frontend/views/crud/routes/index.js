var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'CRUD' });
});

router.get('/createContact', function(req, res, next){
  res.render('createContact');
})
module.exports = router;
