"use strict";

let candidateNameInput = document.getElementById("candidate-name");

candidateNameInput.addEventListener("change",(e)=>{
    candidateNameInput.value = e.target.value;
})

let submitButton = document.getElementById("submit-btn")

submitButton.addEventListener("click",async(e)=>{
    e.preventDefault()
    const res = await fetch(`/admin/delete-candidate`,{
        method: 'DELETE',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({
                AdminDetails:{
                    username:localStorage.getItem('admin-username'),
                    password:localStorage.getItem('admin-pass')
                },
                name:candidateNameInput.value
            })
    }).then(response=>response.json())

    alert(`${candidateNameInput.value} deleted successfully`)
    window.location.replace("/adminTask.html");
})