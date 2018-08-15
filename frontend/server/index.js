const express = require('express')
const app = express()

const runForeignTests = require('./middleware/runForeignTests');

app.post('/run', async (req, res) => {
    try {
        const json = await runForeignTests();
        res.json(json);
    } catch (err) {
        res.status(500).send(err);
    }
});
app.get('/', (req, res) => res.send('Hello NullPointerException!!!'))

app.listen(3001, () => console.log('Example app listening on port 3001!'))