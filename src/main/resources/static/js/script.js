'use strict';
window.addEventListener('load', function () {
    const saveButton = document.getElementById("save-task");
    saveButton.addEventListener("click",function () {
        const publicationForm = document.getElementById("form-task");
        let data = new FormData(publicationForm);
        console.log("ELEMENT SAVED");
        let content = document.querySelector('[name=title]').value;
        if (content == undefined || content.trim().length == 0)
            return;
        fetch("http://localhost:8080/task",{
            method: 'POST',
            body: data
        }).then(r => r.json()).then(data => {
            window.location.href = "http://localhost:8080/";
            console.log(data)
        });
    });
});
function createTaskElement(task) {
    let elem = document.createElement('li');
    elem.id = task.id;
    elem.ondblclick = function(){ changeText(elem.id)};
    elem.innerHTML = task.title;
    if (task.status === true){
        elem.style.textDecorationLine = "none";
    } else {
        elem.style.textDecorationLine = "line-through";
        elem.className = "finish";
    }
    elem.style.userSelect = "none";
    elem.style.fontSize = '15px';
    elem.style.fontStyle = 'italic';
    return elem;
}
function changeText(id){
    console.log("Change text - " + id);
    let task = document.getElementById(id);
    if (task.classList.contains("finish")){
        task.classList.remove("finish");
        console.log("LINE THROUGH");
        task.style.textDecorationLine = ("none");
    } else {
        console.log("LINE NOT THROUGH");
        task.classList.add("finish");
        task.style.textDecorationLine = ("line-through");
    }
    let form = document.getElementById("form-task")
    let data = new FormData(form);
    data.delete("title")
    data.append("id",id)
    fetch("http://localhost:8080/status/", {
        method: 'POST',
        body: data
    });
}
async function getTasks() {
    let url = 'http://localhost:8080/getTasks';
    let response = await fetch(url);
    console.log(response);
    return await response.json();
}

async function addTaskElements(){
        let tasks = await getTasks();
        for (let i = 0; i < tasks.length; i++){
            let task = {
                id: tasks[i].id,
                title: tasks[i].title,
                status: tasks[i].status
            };
            document.getElementsByTagName('ol')[0].append(createTaskElement(task));
        }
}