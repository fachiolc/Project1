window.onload = () => {
	getAllEmployees();
	document.getElementById("userName").addEventListener("click", createEmployee);
}
const getAllEmployees = () => {
	// 1: XMLHttpRequest
	const xhr = new XMLHttpRequest();
	// 2: onreadystatechange
	xhr.onreadystatechange = () => {
		// 5: handle outcomes
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			populateEmployeeTable(JSON.parse(json));
		}
	};
	// 3: xhr.open()
	xhr.open("GET", "http://localhost:8088/Project1_1/api/todos");
	// 4: xhr.send()
	xhr.send();
}
const populateEmployeeTable = (listofEmployees) => {
	// enhanced for loop
	for (let employee of listOfEmployees) {
		// Create a table cell for each property
		const tdId = document.createElement("td");
		const tdName = document.createElement("td");
		const tdPassword = document.createElement("td");
		const tdEmail = document.createElement("td");
		const tdPosititon = document.createElement("td");
		// Set value of each cell
		row.appendChild(tdId);
		row.appendChild(tdName);
		row.appendChild(tdPassword);
		row.appendChild(tdEmail);
		row.appendChild(tdPosition);
		// Append row onto table of employees
		document.getElementById("employeeTable").appendChild(row);
	}
}
