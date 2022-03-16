let welcomeMsg = 'Magic the Gathering Database';
document.querySelector('h1').innerText = welcomeMsg;

fetch('/cards').then(resp => resp.json()).then(cards => {
    document.querySelector('#cardsDiv').innerHTML = listCards(cards);
});

function listCards(json) {
    return `${json.map(listCard).join('\n')}`;
}
// lists the cards in the database to the screen
let listCard = function(card) {
    return '<p>' + card.typeId + ": " + card.cost + ": " + card.name + '</p>';
}

function postCard() {
    let card = {
        "typeId": document.getElementById("typeId").value,
        "cost": document.getElementById("cost").value,
        "name": document.getElementById("name").value
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
        if (result.status !== 200) {
            throw new Error("Bad Server Response");
        }
        console.log(result.text());
    }).catch((error) => { console.log(error); })
    fetch('/cards').then(resp => resp.json()).then(cards => {
            document.querySelector('#cards').innerHTML = listCards(cards);
        }
    );
    window.document.location.reload();
}

// Creates the mouse hover event to the add card/insert button
let button = document.querySelector('button');
    button.addEventListener('mouseover',function() {
            button.textContent = "insert";
    })
    button.addEventListener('mouseout',function() {
        button.textContent="Add Card";
    })
