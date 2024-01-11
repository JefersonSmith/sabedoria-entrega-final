const mentorBtn = document.getElementById("mentorBtn");
    const mentoradoBtn = document.getElementById("mentoradoBtn");
    const container2Mentor = document.getElementById("container2-mentor");
    const container2Mentorado = document.getElementById("container2-mentorado");

    mentorBtn.addEventListener("click", () => {
        container2Mentor.style.display = "flex";
        container2Mentorado.style.display = "none";
    });

    mentoradoBtn.addEventListener("click", () => {
        container2Mentor.style.display = "none";
        container2Mentorado.style.display = "flex";
    });