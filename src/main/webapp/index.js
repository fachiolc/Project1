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
				populateTodoTable(JSON.parse(json));
			}
		};
		// 3: xhr.open()
		xhr.open("GET", "http://localhost:8088/Project1_1/api/todos");
		// 4: xhr.send()
		xhr.send();
	}
	
	