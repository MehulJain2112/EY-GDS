<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Registration</title>
<link rel="stylesheet" href="styles.css"> <!-- External CSS file for styling -->
</head>
<body>
<div class="container">
  <h2>Customer Registration Form</h2>
  <form id="customerForm" action="#" method="post">
    <label for="customerId">ID:</label>
    <input type="text" id="customerId" name="customerId" required><br><br>
    
    <label for="customerName">Name:</label>
    <input type="text" id="customerName" name="customerName" required><br><br>
    
    <label for="customerAge">Age:</label>
    <input type="number" id="customerAge" name="customerAge" required><br><br>
    
    <label for="customerDOB">DOB:</label>
    <input type="date" id="customerDOB" name="customerDOB" required><br><br>
    
    <label for="customerEmail">Email:</label>
    <input type="email" id="customerEmail" name="customerEmail" required><br><br>
    
    <label for="customerAddress">Address:</label>
    <textarea id="customerAddress" name="customerAddress" rows="4" required></textarea><br><br>
    
    <input type="submit" value="Submit">
  </form>
</div>
<script src="validateForm.js"></script> <!-- External JavaScript file for form validation -->
</body>
</html>



body {
  font-family: Arial, sans-serif;
  background-color: #f0f0f0;
  margin: 20px;
  padding: 20px;
}

.container {
  max-width: 600px;
  margin: 0 auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
}

form {
  display: flex;
  flex-direction: column;
}

label {
  margin-bottom: 10px;
}

input[type="text"],
input[type="number"],
input[type="email"],
textarea,
input[type="date"] {
  width: 100%;
  padding: 8px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

input[type="submit"]:hover {
  background-color: #45a049;
}



function validateForm() {
  var customerId = document.getElementById('customerId').value;
  var customerName = document.getElementById('customerName').value;
  var customerAge = document.getElementById('customerAge').value;
  var customerDOB = document.getElementById('customerDOB').value;
  var customerEmail = document.getElementById('customerEmail').value;
  var customerAddress = document.getElementById('customerAddress').value;

  // Simple validation example (you can add more complex checks as needed)
  if (customerId === '' || customerName === '' || customerAge === '' || customerDOB === '' || customerEmail === '' || customerAddress === '') {
    alert('All fields must be filled out');
    return false;
  }
  return true;
}

document.getElementById('customerForm').addEventListener('submit', function(e) {
  if (!validateForm()) {
    e.preventDefault(); // Prevent form submission if validation fails
  }
});
