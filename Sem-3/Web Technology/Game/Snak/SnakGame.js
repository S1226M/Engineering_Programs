var blockSize = 30;
var rows = 20;
var cols = 20;
var board;
var context;

// Snake head
var snakex = blockSize * 5;
var snakey = blockSize * 5;

// Food
var foodx;
var foody;

// Game state
var gameOver = false;

// Velocity
var velocityX = 0;
var velocityY = 0;

// Snake body
var snakeBody = [];

window.onload = function() {
    board = document.getElementById("board");
    board.height = rows * blockSize;
    board.width = cols * blockSize;
    context = board.getContext("2d"); // Use for drawing on the board

    placeFood();
    document.addEventListener("keydown", changeDirection);
    requestAnimationFrame(update);
}

function update() {
    if (gameOver) {
        return;
    }

    context.fillStyle = "black";
    context.fillRect(0, 0, board.width, board.height);

    context.fillStyle = "red";
    context.fillRect(foodx, foody, blockSize, blockSize);

    if (snakex === foodx && snakey === foody) {
        snakeBody.push([foodx, foody]);
        placeFood();
    }

    for (let i = snakeBody.length - 1; i > 0; i--) {
        snakeBody[i] = snakeBody[i - 1];
    }
    if (snakeBody.length) {
        snakeBody[0] = [snakex, snakey];
    }

    snakex += velocityX;
    snakey += velocityY;

    context.fillStyle = "lime";
    context.fillRect(snakex, snakey, blockSize, blockSize);
    for (let i = 0; i < snakeBody.length; i++) {
        context.fillRect(snakeBody[i][0], snakeBody[i][1], blockSize, blockSize);
    }

    // Game over condition
    if (snakex < 0 || snakex >= cols * blockSize || snakey < 0 || snakey >= rows * blockSize) {
        gameOver = true;
        alert("Game Over");
    }

    for (let i = 0; i < snakeBody.length; i++) {
        if (snakex === snakeBody[i][0] && snakey === snakeBody[i][1]) {
            gameOver = true;
            alert("Game Over");
        }
    }

    setTimeout(() => {
        requestAnimationFrame(update);
    }, 100);
}

function changeDirection(e) {
    if (e.code === "ArrowUp" && velocityY === 0) {
        velocityX = 0;
        velocityY = -blockSize;
    } else if (e.code === "ArrowDown" && velocityY === 0) {
        velocityX = 0;
        velocityY = blockSize;
    } else if (e.code === "ArrowLeft" && velocityX === 0) {
        velocityX = -blockSize;
        velocityY = 0;
    } else if (e.code === "ArrowRight" && velocityX === 0) {
        velocityX = blockSize;
        velocityY = 0;
    }
}

function placeFood() {
    foodx = Math.floor(Math.random() * cols) * blockSize;
    foody = Math.floor(Math.random() * rows) * blockSize;
}