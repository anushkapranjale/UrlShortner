async function shortenUrl() {

    const urlInput = document.getElementById("urlInput");
    const result = document.getElementById("result");

    const originalUrl = urlInput.value.trim();

    if (!originalUrl) {
        result.innerText = "Please enter a URL.";
        return;
    }

    try {

        const response = await fetch("/api/urls", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                originalUrl: originalUrl
            })
        });

        const data = await response.json();

        if (!response.ok) {
            result.innerText = data.error || "Something went wrong.";
            return;
        }

        result.innerHTML = `
            <p>Your shortened URL:</p>

            <a href="${data.shortUrl}" target="_blank">
                ${data.shortUrl}
            </a>
        `;

    } catch (error) {

        result.innerText = "Unable to connect to server.";

    }
}