async function initialize() {
    const response = await fetch(
        'http://localhost:8080/current_date'
    ).then((res) => res.json());
    document.getElementById("fromDate").value = response;
    document.getElementById("toDate").value = response;
}

async function submitRequest() {
    let request = {
        "fromDate": fromDate.value,
        "toDate": toDate.value,
        "fromTime": fromTime.value,
        "toTime": toTime.value
    };
    await fetch('http://localhost:8080/submit', {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(request)
    }).then(result => result.text()).then(text => alert(text));
}