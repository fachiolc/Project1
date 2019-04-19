window.onload = () => {
	///getAllEmployees();
	document.getElementById("DisplayInfo").addEventListener("click", getAllEmployees);
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
	xhr.open("GET", "http://localhost:8088/Project1_1/api/employees");
	// 4: xhr.send()
	xhr.send();
}
const populateEmployeesTable = (listOfTodos) => {
    // The for...of loop is Javascript's version of the enhanced for loop
    // The for...in loop, this iterates over every property of a JS object
    for (let todo of listOfTodos) {
        // Create a table cell for each property of our object
        const tdUserId = document.createElement("td");
        const tdName = document.createElement("td");
        const tdPassword = document.createElement("td");
        const tdEmail = document.createElement("td");
        const tdDepartment = document.createElement("td");
        const tdEmployeeType = document.createElement("td");
        
        // Set the value of each cell
        tdUserId.textContent = todo.userId;
        tdName.textContent = todo.name;
        tdPassword.textContent = todo.password;
        tdEmail.textContent = todo.email;
        tdDepartment.textContent = todo.department;
        tdEmployeeType.textContent = todo.employeeType;
        
        // Create a row to be appended onto our table
        const row = document.createElement("tr");
        
        // Set the td's to the corresponding order of our table header
        row.appendChild(tdUserId);
        row.appendChild(tdName);
        row.appendChild(tdPassword);
        row.appendChild(tdEmail);
        row.appendChild(tdDepartment);
        row.appendChild(tdEmployeeType);
        
        
        // Append our row onto our table of todos
        document.getElementById("employeeTable").appendChild(row);
    }
}