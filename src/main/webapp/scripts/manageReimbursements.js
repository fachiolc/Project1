window.onload = () => {
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
	console.log("populateReimbursementTable entered");
	for (let reimbursement of listofReimbursements) {
		// Create a table cell for each property
		console.log(reimbursement);
		const  tdRId = document.createElement("td");
		const tdRReq = document.createElement("td");
		const tdRCst = document.createElement("td");
		const tdRDsc = document.createElement("td");
		const tdRSts = document.createElement("td");
		// Set value of each cell
		 tdRId.textContent = reimbursement.tdRId;
		tdRReq.textContent = reimbursement.tdRReq;
		tdRCst.textContent = reimbursement.tdRCst;
		tdRDsc.textContent = reimbursement.tdRDsc;
		tdRSts.textContent = reimbursement.tdRSts;
		// Create row to be appended
		const row = document.createElement("tr");
		// Set td's to the corresponding order of table header
		row.appendChild(tdRId);
		row.appendChild(tdRReq);
		row.appendChild(tdRCst);
		row.appendChild(tdRDsc);
		row.appendChild(tdRSts);
		// Append row onto table of reimbursements
		document.getElementById("reimbursementTable").appendChild(row);
	}
}