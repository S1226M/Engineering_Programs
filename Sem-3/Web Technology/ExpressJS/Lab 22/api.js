const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const Patient = require('./Patient');
const cors = require('cors');

const connectionString = 'mongodb+srv://Smit:smit123@cluster0.nr60d.mongodb.net/Hospital_Management';
mongoose.connect(connectionString).then(() => {
    const app = express();
    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(bodyParser.json()); // To parse JSON bodies
    app.use(cors());

    // Get all patients
    app.get('/patient', async (req, res) => {
        const data = await Patient.find();
        res.send(data);
    });

    // Get patient by number
    app.get('/patient/:number', async (req, res) => {
        const data = await Patient.findOne({ number: req.params.number });
        res.send(data);
    });

    // Delete patient by number
    app.delete('/patient/:number', async (req, res) => {
        const data = await Patient.deleteOne({ number: req.params.number });
        res.send(data);
    });

    // Add new patient
    app.post('/patient', async (req, res) => {
        const patient = new Patient({ ...req.body });
        const savedPatient = await patient.save();
        res.send(savedPatient);
    });

    // Update patient by number
    app.put('/patient/:number', async (req, res) => {
        const updatedPatient = await Patient.findOneAndUpdate(
            { number: req.params.number },
            { ...req.body },
            { new: true }
        );
        res.send(updatedPatient);
    });

    app.listen(4000, () => {
        console.log("Server is running on port 4000");
    });

    console.log("Your server is connected with database");
});