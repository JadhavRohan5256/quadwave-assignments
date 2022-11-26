// opening form on click of add btn 
const addBtn = document.querySelector('.add-btn');
const employeeWrapper = document.querySelector('.employee-wrapper');
addBtn.addEventListener('click', () => {
	if (employeeWrapper.classList.contains('clear')) {
		employeeWrapper.classList.remove('clear');
	}
	else {
		employeeWrapper.classList.add('clear');
	}
})
const cancelForm = document.querySelector('.cancel-btn');
cancelForm.addEventListener('click', () => addBtn.click());


// Theme javascript 
const darkMode = document.querySelector('#darkMode');
const mode = document.querySelector('.mode');
let root = document.documentElement;
const dark = () => {
	root.style.setProperty('--bg-color', '#000000');
	root.style.setProperty('--bg-surface-color', '#121212');
	root.style.setProperty('--font-color', '#808080');
	root.style.setProperty('--primary-color', '#81D4FA');
	root.style.setProperty('--secondary-color', '#FF5722');
	root.style.setProperty('--error-color', '#721c24');
	root.style.setProperty('--error-bg', '#f8d7da');
	root.style.setProperty('--success-color', '#155724');
	root.style.setProperty('--success-bg', '#d4edda');
}
const light = () => {
	root.style.setProperty('--bg-color', '#eee');
	root.style.setProperty('--bg-surface-color', '#ffffff');
	root.style.setProperty('--font-color', '#121212');
	root.style.setProperty('--primary-color', '#81D4FA');
	root.style.setProperty('--secondary-color', '#FF5722');
	root.style.setProperty('--error-color', '#721c24');
	root.style.setProperty('--error-bg', '#f8d7da');
	root.style.setProperty('--success-color', '#155724');
	root.style.setProperty('--success-bg', '#d4edda');
}
const applyTheme = () => {
	let darkMode = localStorage.getItem("darkMode");
	if (darkMode === null || darkMode === 'true') {
		mode.innerHTML = '<i class="fa-solid fa-moon theme-icons"></i>';
		dark();
		localStorage.setItem("darkMode", true);
	} else {
		mode.innerHTML = '<i class="fa-solid fa-sun theme-icons"></i>';
		light();
		darkMode.checked = true;
	}
}
applyTheme();
window.addEventListener('load', applyTheme())
darkMode.addEventListener('change', () => {
	if (darkMode.checked == true) {
		mode.innerHTML = '<i class="fa-solid fa-sun theme-icons"></i>';
		localStorage.setItem("darkMode", false);
		light();
	}
	else {
		mode.innerHTML = '<i class="fa-solid fa-moon theme-icons"></i>';
		localStorage.setItem("darkMode", true);
		dark();
	}
})


//toast javascript
const toastWrapper = document.querySelector('.toast-wrapper');
const toast = (messageType, messageDesc) => {
	const div = document.createElement("div");
	div.classList.add("toast", messageType);
	div.setAttribute("onclick", "closeToast(this)");
	// p for message
	const p = document.createElement("p");
	p.classList.add('toast-message');
	p.textContent = messageDesc;
	// i for close icon
	const small = document.createElement("small");
	small.classList.add("fa-solid", "fa-xmark", "close-toast");
	div.appendChild(p);
	div.appendChild(small);
	toastWrapper.appendChild(div);
}

const closeToast = (current) => {
	current.style.display = "none";
}

// adding result data into table body function
const parseTableData = (result) => {
	if (result.length <= 0) {
		let row = `
		<tr>
			<td colspan="5">No content found</td>
		</tr>
		`
		$('.all-employee').html(row);
	}
	else {
		let content = '';
		result.forEach((employee) => {
			let row = `
				<tr>
					<td>${employee.empId}</td>
					<td>${employee.empName}</td>
					<td>${employee.empBirthDate}</td>
					<td>${employee.empExperience}</td>
					<td>${employee.empDesignation}</td>
				</tr>
			`;
			content += row;
		})

		$('.all-employee').html(content);
	}
}


// fetching all employees data
// ajax call 
function load() {
	$(document).ready(() => {
		$('.animate').html('fetching...')
		$('.spinner-global').show();
		$.ajax({
			url: "employees",
			type: "post",
			success: (data) => {
				let result = $.parseJSON(data);
				parseTableData(result);
				$('.spinner-global').hide();
			}
		});
	})
}
window.addEventListener("load", () => {
	load();
})


// ajax call 
$(document).ready(() => {

	// fetching search data 
	$('#search').on('keyup', (e) => {
		const inputData = e.target.value;
		$('.animate').html('fetching...')
		$('.spinner-global').show();
		$.ajax({
			url: 'search',
			type: 'POST',
			data: { search: inputData },
			success: (data) => {
				const result = $.parseJSON(data);
				parseTableData(result);
				$('.spinner-global').hide();
			}
		})
	})

	// inserting employee data 
	$('#employeeForm').on('submit', (e) => {
		e.preventDefault();
		const data = $('#employeeForm').serialize();
		$('.animate').html('inserting..')
		$('.spinner-global').show();
		$.ajax({
			url: 'employee-data',
			method: 'POST',
			data: data,
			success: (data) => {
				const message = $.parseJSON(data);
				toast(message.messageType, message.messageDesc);
				if (message.messageType === 'success-message') {
					$('#employeeForm')[0].reset()
					$('.spinner-global').hide();
					load();
				}
				else {
					$('.spinner-global').hide();
				}
			}
		})
	})
})


