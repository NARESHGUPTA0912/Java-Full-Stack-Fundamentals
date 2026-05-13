// GLOBAL VARIABLES
let playerName = "";
let difficulty = "";
let questions = [];
let currentIndex = 0;
let score = 0;
let timer;
let timeLimit = 0;

// SAMPLE QUESTIONS (You can replace them later)
const allQuestions = {
    easy: [
        { q: "2 + 2 = ?", options: ["3", "4", "5", "6"], answer: 1 },
        { q: "Capital of India?", options: ["Delhi", "Mumbai", "Pune", "Kolkata"], answer: 0 },
        { q: "5 × 2 = ?", options: ["10", "8", "6", "12"], answer: 0 },
    ],

    medium: [
        { q: "HTML stands for?", options: ["Hyper Text Markup Language", "Hot Mail", "How To Make Links", "None"], answer: 0 },
        { q: "CSS is used for?", options: ["Styling", "Database", "Backend", "Photoshop"], answer: 0 },
        { q: "RAM is?", options: ["Temporary Memory", "Permanent Memory", "Hard Disk", "None"], answer: 0 },
    ],

    hard: [
        { q: "JS is ______?", options: ["Language", "Library", "Framework", "None"], answer: 0 },
        { q: "CPU means?", options: ["Central Processing Unit", "Control Power Unit", "Computer Power Utility", "None"], answer: 0 },
        { q: "JSON stands for?", options: ["JavaScript Object Notation", "Java Standard Object", "Jolly Script Object Node", "None"], answer: 0 },
    ]
};


// STEP 1 — Save Player Name
function saveName() {
    const nameInput = document.getElementById("playerName").value.trim();

    if (nameInput === "") {
        alert("Please enter your name!");
        return;
    }

    playerName = nameInput;

    document.getElementById("welcomePopup").classList.add("hidden");
    document.getElementById("difficultyPopup").classList.remove("hidden");
}


// STEP 2 — Start Quiz According to Difficulty
function startQuiz(level) {
    difficulty = level;

    if (level === "easy") {
        questions = allQuestions.easy.slice(0, 10);
        timeLimit = 0;
    } else if (level === "medium") {
        questions = allQuestions.medium.slice(0, 15);
        timeLimit = 60;
    } else {
        questions = allQuestions.hard.slice(0, 25);
        timeLimit = 30;
    }

    score = 0;
    currentIndex = 0;

    document.getElementById("difficultyPopup").classList.add("hidden");
    document.getElementById("quizScreen").classList.remove("hidden");

    loadQuestion();
}


// STEP 3 — Load Each Question
function loadQuestion() {
    clearInterval(timer);

    let q = questions[currentIndex];

    document.getElementById("questionText").innerText = q.q;
    document.getElementById("score").innerText = "Score: " + score;

    let optHTML = "";
    q.options.forEach((op, index) => {
        optHTML += `<div class="option" onclick="checkAnswer(${index})">${op}</div>`;
    });

    document.getElementById("options").innerHTML = optHTML;
    document.getElementById("nextBtn").disabled = true;

    if (timeLimit > 0) startTimer();
}


// STEP 4 — Timer
function startTimer() {
    let t = timeLimit;

    timer = setInterval(() => {
        document.getElementById("time").innerText = "Time Left: " + t + "s";

        if (t <= 0) {
            clearInterval(timer);
            document.getElementById("time").innerText = "Time Up!";
            autoWrong();
        }

        t--;
    }, 1000);
}


// If time finishes: auto-wrong
function autoWrong() {
    const options = document.querySelectorAll(".option");

    options.forEach(op => op.style.pointerEvents = "none");

    score -= 1;

    document.getElementById("nextBtn").disabled = false;
}


// STEP 5 — Check Answer
function checkAnswer(selected) {
    clearInterval(timer);

    let q = questions[currentIndex];
    const options = document.querySelectorAll(".option");

    options.forEach((op, index) => {
        op.style.pointerEvents = "none";

        if (index === q.answer) {
            op.classList.add("correct");
        } else if (index === selected) {
            op.classList.add("wrong");
        }
    });

    if (selected === q.answer) {
        score += 4;
    } else {
        score -= 1;
    }

    document.getElementById("score").innerText = "Score: " + score;
    document.getElementById("nextBtn").disabled = false;
}


// STEP 6 — Next Question
function nextQuestion() {
    currentIndex++;

    if (currentIndex >= questions.length) {
        endQuiz();
    } else {
        loadQuestion();
    }
}


// STEP 7 — End Quiz
function endQuiz() {
    document.getElementById("quizScreen").classList.add("hidden");

    setTimeout(() => {
        document.getElementById("scorePopup").classList.remove("hidden");

        document.getElementById("finalName").innerText = "Player: " + playerName;
        document.getElementById("finalScore").innerText = "Score: " + score;

        let stars = Math.round(score / 10);
        if (stars > 5) stars = 5;

        document.getElementById("finalRating").innerText =
            "Rating: " + "⭐".repeat(stars);

    }, 1500);
}


// STEP 8 — Play Again
function playAgain() {
    document.getElementById("scorePopup").classList.add("hidden");
    document.getElementById("difficultyPopup").classList.remove("hidden");

    score = 0;
    currentIndex = 0;
}