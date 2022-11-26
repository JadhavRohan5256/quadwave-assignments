<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/home-page-style.css">
</head>
<body>
	<main>
		<!-- SPINNER -->
		<div class="spinner-global">
			<div class="spinner">
				<div class="spinner-wrapper">
					<div class="animate">Loading..</div>
				</div>
			</div>
		</div>
		
		<!-- TOAST MESSAGE -->
		<div class="toast-wrapper"></div>
		<div class="theme-mode">
			<input 
				type="checkbox" 
				name="darkMode" 
				id="darkMode" 
			/> 
			<label for="darkMode" class="mode"> 
				<i class="fa-solid fa-moon"></i>
			</label>
		</div>
		<div class="show-contact-main">
			<div class="filter">
				<form action="#" method="post">
					<div class="search-box">
						<i class="fa-solid fa-magnifying-glass search-icon"></i> 
						<input
							type="text" 
							name="search" 
							id="search"
							placeholder="Search employee here.." 
						/>
					</div>
				</form>
				<button class="employee-btn add-btn">Add</button>
			</div>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>Eid</th>
							<th>EName</th>
							<th>DOJ</th>
							<th>YOE</th>
							<th>Designation</th>
						</tr>
					</thead>
					<tbody class="all-employee">
					</tbody>
				</table>
			</div>
		</div>
		<!-- ADD EMPLOYEE FORM CONTAINER  -->
		<div class="employee-form-main">
			<div class="employee-wrapper">
				<form id="employeeForm">
					<div class="form-box">
						<h2 class="employee-title">Employee Details</h2>
					</div>
					<div class="form-box">
						<label for="empId">Employee Id</label> 
						<input 
							type="number"
							name="empId" 
							id="empId" 
							placeholder="Enter employee id.." 
						/>
					</div>
					<div class="form-box">
						<label for="empName">Employee Name</label> 
						<input 
							type="text"
							name="empName" 
							id="empName" 
							placeholder="Enter name here.." 
						/>
					</div>
					<div class="form-box">
						<label for="empBirthDate">Birth Date</label> <input type="date"
							name="empBirthDate" id="empBirthDate" />
					</div>
					<div class="form-box">
						<label for="empExperience">Year of Experience</label> 
						<input
							type="number" 
							name="empExperience" 
							id="empExperience"
							placeholder="Enter total experience here.." 
						/>
					</div>
					<div class="form-box">
						<label for="empDesignation">Designation</label> 
						<input 
							type="text"
							name="empDesignation" 
							id="empDesignation"
							placeholder="Enter  here.." 
						/>
					</div>
					<div class="form-box">
						<button type="submit" class="employee-btn">Save</button>
					</div>
					<div class="form-box">
						<button type="reset" class="employee-btn cancel-btn">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<script src="js/jquery.js"></script>
	<script src="js/home-page-script.js"></script>
</body>
</html>