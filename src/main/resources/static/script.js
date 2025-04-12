let currentPage = 0;
const pageSize = 10;

function fetchData() {
    fetch(`/dat/data?page=${currentPage}&size=${pageSize}`)
        .then(response => response.json())
        .then(data => {
            displayData(data.content);
            updatePagination(data.totalPages);
        });
}

function displayData(records) {
    const tableBody = document.querySelector('#productTable tbody');
    tableBody.innerHTML = '';
    records.forEach(record => {
        const row = `
                <tr>
                    <td>${record.uniqueSystemIdentifier}</td>
                    <td>${product.fileNumber}</td>
                    <td>${product.dateEntered}</td>
                     <td>${product.signatureFirstName}</td>
                </tr>
            `;
        tableBody.innerHTML += row;
    });
}

function updatePagination(totalPages) {
    const prevButton = document.querySelector('#pagination button:first-child');
    const nextButton = document.querySelector('#pagination button:last-child');

    prevButton.disabled = currentPage === 0;
    nextButton.disabled = currentPage === totalPages - 1;
}

function changePage(amount) {
    currentPage += amount;
    fetchData();
}

fetchData();