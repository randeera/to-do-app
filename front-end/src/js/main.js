const txtElm = document.querySelector("#txt");
const btnAddElm = document.querySelector("#btn-add");
const taskContainerElm = document.querySelector("#task-container");

loadAllTasks();

function loadAllTasks(){
    fetch('http://localhost:8080/tasks').then(res => {
        if (res.ok){
            res.json().then(taskList => taskList.forEach(task => createTask(task))) ;
        }else{
            alert("Failed to load task list");
        }
    }).catch(err => {
        alert("Something went wrong, try again later");
    });
}

function createTask(task){
    const liElm = document.createElement('li');
    taskContainerElm.append(liElm);
    liElm.id = "task-" + task.id;

    liElm.innerHTML = `
        <input id="chk-task-${task.id}" type="checkbox" ${task.status ? "checked": ""}>
        <label for="chk-task-${task.id}">${task.description}</label>
        <i class="delete bi bi-trash"></i>    
    `;
}

taskContainerElm.addEventListener('click', (e)=>{
    if (e.target?.classList.contains('delete')){

        const taskId = e.target.closest('li').id.substring(5);

        fetch(`http://localhost:8080/tasks/${taskId}`, {method: 'DELETE'})
        .then(res => {
            if (res.ok){
                e.target.closest("li").remove();
            }else{
                alert("Failed to delete the task");
            }
        }).catch(err => {
            alert("Something went wrong, try again later");
        });  
              
    } else if (e.target?.tagName === "INPUT"){
        // Todo: Update the task status in the back-end
        // If not success
        if (!false){
            e.preventDefault();
        }
    }
});

let taskId = 0;

btnAddElm.addEventListener('click', ()=>{
    const taskDescription = txtElm.value;
    
    if (!taskDescription.trim()){
        txtElm.focus();
        txtElm.select();
        return;
    }

    // Todo: Save the task in the back-end
    // If success

    createTask({id: taskId++, description: taskDescription, status: false});
    txtElm.value = "";
    txtElm.focus();
});