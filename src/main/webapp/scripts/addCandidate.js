
"use strict";

let nameInput = document.getElementById('name-input')

nameInput.addEventListener('change',(e)=>{
    nameInput.value = e.target.value
})

const submitButton = document.getElementById('submit-btn')

submitButton.addEventListener('click',async(e)=>{
    e.preventDefault()
    console.log(nameInput.value)

    const res = await fetch(`/admin/add-candidate`,{
        method: 'POST',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({
                AdminDetails:{
                    username:localStorage.getItem('admin-username'),
                    password:localStorage.getItem('admin-pass')
                },
                    name:nameInput.value,
                
            })
    }).then(response=>response.json())

    if(res.error){
        alert(res.error.message)
        return
    }
    alert(res.message)
    window.location.replace("/adminTask.html");
})