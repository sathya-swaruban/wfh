(async function submitRequest() {
    let request = {
        "fromDate": "2023-11-20",
        "toDate": "2023-11-20",
        "fromTime": "09:00",
        "toTime": "18:15"
    };
    await fetch('http://localhost:8080/submit', {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(request)
    }).then(result => result.text()).then(text => alert(text));
})();