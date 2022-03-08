var welcomeMsg = 'Hello, World!';

document.querySelector('h1').innerText = welcomeMsg;

fetch('/artists').then(resp => resp.json().then(artists => console.log(artists)));

function listArtists(json) {
    return `${json.map(listArtists).join('\n')}`;
}

let listArtists = function(artist) {
    return '<p>' + artist.artistId + ": " + artist.name + '</p>' ;
}

function postArtist() {
    let artist = new Artist();
}