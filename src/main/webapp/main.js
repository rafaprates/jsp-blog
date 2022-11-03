const privilege = sessionStorage.getItem("privilege");
console.log(privilege);

if (privilege === null) {
     const userOnlyElements = document.getElementsByClassName("user-only-element");
     for (e of userOnlyElements) {
        e.style.display = "none";
     }
}

if (privilege > 0) {
    const visitorOnlyElements = document.getElementsByClassName("visitor-only-element");
    for (e of visitorOnlyElements) {
        e.style.display = "none";
    }
}

if (privilege < 3) {
     const adminElements = document.getElementsByClassName("admin-element");
     for (e of adminElements) {
        e.style.display = "none";
     }
}
