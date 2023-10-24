"use strict";

let nameInput = document.getElementById('name-input')
let addressInput = document.getElementById('address-input')
let DOBInput = document.getElementById('dob-input')
let mobileInput = document.getElementById('mobile-input')

nameInput.addEventListener('change',(e)=>{
    nameInput.value = e.target.value
})
addressInput.addEventListener('change',(e)=>{
    addressInput.value = e.target.value
})
DOBInput.addEventListener('change',(e)=>{
    DOBInput.value = e.target.value
})
mobileInput.addEventListener('change',(e)=>{
    mobileInput.value = e.target.value
})


const submitButton = document.getElementById('submit-btn')

submitButton.addEventListener('click',async(e)=>{
    e.preventDefault()
    console.log(nameInput.value,addressInput.value,DOBInput.value,mobileInput.value)

    const res = await fetch(`/admin/add-voter`,{
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
                Voter:{
                    name:nameInput.value,
                    address:addressInput.value,
                    dob:DOBInput.value,
                    mobile_no:mobileInput.value
                }
            })
    }).then(response=>response.json())

    if(res.error){
        alert(res.error.message)
        return
    }

    alert(res.message)
    window.location.replace("/adminTask.html");
})