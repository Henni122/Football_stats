document.addEventListener("DOMContentLoaded", () => {
    const searchForm = document.getElementById("search-for-team");
    const searchInput = document.getElementById("search-input");
    const resultsContainer = document.getElementById("player-result");

    searchForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const valueFromSearch = searchInput.value.trim();
        //Check if user has entered something
        if (!valueFromSearch) return;
        //Emptying the search field
        resultsContainer.innerHTML = "";

        fetch(`/players/profiles?=${encodeURIComponent(valueFromSearch)}`)
            .then(response => {
                if (!response.ok) throw new Error(`Server error ${response.status}`);
                return response.json();
            })
            .then(data => {
                data.forEach(player => {
                    const displayingOfTheResult = document.createElement("div");
                    displayingOfTheResult.textContent = `${player.firstname} \n 
                                                      + ${player.lastname} \n
                                                      + ${player.age}`;

                    resultsContainer.appendChild(displayingOfTheResult);

                })
            })
            .catch(error => console.error(error));
    })
})