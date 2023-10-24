"use strict";

let candidates;
const candidateResult = document.getElementById('vote-cast-body')

const fetchCandidates = async()=>{
    const res = await fetch(`/admin/list-candidates`,{
        method: 'POST',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({
                AdminDetails:{
                    username:localStorage.getItem('admin-username'),
                    password:localStorage.getItem('admin-pass')
                }
            })
    }).then(response=>response.json())
    console.log(res)
    candidateResult.innerHTML=returnHTMLCode(res)

}


fetchCandidates()

const handleClick = async (candidateName)=>{
    const res = await fetch(`/voters/cast-vote`,{
        method: 'POST',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({
                candidateName:candidateName,
                voterId:localStorage.getItem('voter-id')
            })
    }).then(response=>response.json())

    if(res.error){
        alert(res.error.message)
        return
    }

    alert(res.success.message)
}

const returnHTMLCode = (candidates) => {
    let result ='';

    candidates.forEach((candidate)=>{
        result+=`<tr>
        <td>${candidate.name}</td>
        <td><button onclick="handleClick('${candidate.name}')">Vote</button></td>
      </tr>`
    })

    return result
}
