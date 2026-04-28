const { Server, Socket } = require("socket.io");
const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Hello World");
});

const httpServer = app.listen(3000, () => {
  console.log("Server running on port 3000");
});

const io = new Server(httpServer, {
    cors:{
        origin:"*",
    },
});

io.on("connection", (socket) => {
    const address = socket.handshake.address;
    console.log("a user connected",socket.id ,address);
});