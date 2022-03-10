var welcomeMsg = 'Hello, World!';
document.querySelector('h1').innerText = welcomeMsg;

fetch('/cards').then(resp => resp.json()).then(cards => {
    document.querySelector('#cards').innerHTML = listCards(cards);
});

function listCards(json) {
    return `${json.map(listCard).join('\n')}`;
}

let listCard = function(card) {
    return '<p>' + card.typeId + ": " + card.name + ": " + card.cost + '</p>';
}

function postCard() {
    let card = {
        "typeId": document.getElementById("typeId").value,
        "name": document.getElementById("name").value,
        "cost": document.getElementById("cost").value
    }
    console.log(card);
    fetch("/cards", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(card)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
        console.log(result.text());
    }).catch((error) => { console.log(error); })
    fetch('/cards').then(resp => resp.json()).then(cards => {
            document.querySelector('#cards').innerHTML = listCards(cards);
        }
    );
}


let button = document.querySelector('button');
button.addEventListener('mouseenter',function() {
    button.textContent = "Go!";
})