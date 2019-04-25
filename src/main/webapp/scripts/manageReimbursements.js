windows.onload = () => {
	getAllReimbursements();
}
const getAllReimbursements = () => {
	// 1: XMLHttpRequest
	const xhr = new XMLHttpRequest();
	// 2: onreadystatechange
	xhr.onreadystatechange = () => {
		// 5: handle outcomes
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
//			console.log(json);
			populateReimbursementsTable(JSON.parse(json));
			console.log (JSON.parse(json));
		}
	};
	// 3: xhr.open()
	xhr.open("GET", "http://localhost:8088/Project1_1/api/reimbursements");
	// 4: xhr.send()
	xhr.send();
}
const populateReimbursementsTable = (listofReimbursements) => {
	// enhanced for loop
	for (let reimbursement of listofReimbursements) {
		// Create a table cell for each property
		const 
	}
}