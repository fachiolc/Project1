window.onload = () => {
//	getAllEmployees();
	document.getElementById("DisplayAllEmployees").addEventListener("click", getAllEmployees);
}
const getAllEmployees = () => {
	// 1: XMLHttpRequest
	const xhr = new XMLHttpRequest();
	// 2: onreadystatechange
	xhr.onreadystatechange = () => {
		// 5: handle outcomes
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
//			console.log(json);
			populateEmployeesTable(JSON.parse(json));
			console.log (JSON.parse(json));
		}
	};
	// 3: xhr.open()
	xhr.open("GET", "http://localhost:8088/Project1_1/api/employees");
	// 4: xhr.send()
	xhr.send();
}
const populateEmployeesTable = (listofEmployees) => {
	// enhanced for loop
	for (let employee of listofEmployees) {
		// Create a table cell for each property
        const tdUserId = document.createElement("td");
        const tdName = document.createElement("td");
//        const tdPassword = document.createElement("td");
        const tdEmail = document.createElement("td");
//        const tdDepartment = document.createElement("td");
        const tdEmployeeType = document.createElement("td");
		// Set value of each cell
        tdUserId.textContent = employee.UserId;
        tdName.textContent = employee.name;
//        tdPassword.textcontent = employee.password;
        tdEmail.textContent = employee.email;
        tdEmployeeType.textContent = employee.employeeType;
        // Create row to be appended
        const row = document.createElement("tr");
        
        // Set td's to the corresponding order of table header
        row.appendChild(tdUserId);
        row.appendChild(tdName);
//        row.appendChild(tdPassword);
        row.appendChild(tdEmail);
//        row.appendChild(tdDepartment);
        row.appendChild(tdEmployeeType);
        
		// Append row onto table of employees
		document.getElementById("employeeTable").appendChild(row);
	}
}
