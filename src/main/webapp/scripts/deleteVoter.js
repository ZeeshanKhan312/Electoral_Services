"use strict";

let voterIdInput = document.getElementById("voter-id-input");

voterIdInput.addEventListener("change",(e)=>{
    voterIdInput.value = e.target.value;
})

let submitButton = document.getElementById("submit-btn")

submitButton.addEventListener("click",async(e)=>{
    e.preventDefault()
    const res = await fetch(`/admin/delete-voter`,{
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
                voterId:voterIdInput.value
            })
    }).then(response=>response.json())

    alert(`${voterIdInput.value} deleted successfully`)
    window.location.replace("/adminTask.html");
})