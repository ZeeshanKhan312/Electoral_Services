"use strict";

let candidates;
const candidateResult = document.getElementById('result-body')

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

    candidateResult.innerHTML=returnHTMLCode(res)

}


fetchCandidates()
const returnHTMLCode = (candidates) => {
    let result ='';

    candidates.forEach((candidate)=>{
        result+=`<tr>
        <td>${candidate.name}</td>
        <td>${candidate.votes}</td>
      </tr>`
    })

    return result;
}