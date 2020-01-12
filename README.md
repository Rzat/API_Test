# API_Test
Please find the below API's with expected request and response.
After running application,  1 Employee with address details will be loaded. 

{
    "id": 1,
    "name": "John Snow",
    "date_of_birth": "05/02/1995",
    "addresses": [
        {
            "id": 1,
            "addr_line_one": "NINDIAN",
            "addr_line_two": "Nindian2",
            "city": "Bangalore"
        }
    ]
}

having same api for Create and Update Customer:
for new Customer:
				http://localhost:8080/api/v1/Employee/new
				
				request :
							{
										"name":"Rajat",
										"date_of_birth":"05/02/1995",
										"addresses":{
											"addr_line_one":"IGI",
											"addr_line_two":"India",
											"city":"New Delhi"
										}
							}
							
				response:
							{
										"id": 2,
										"name": "Rajat",
										"date_of_birth": "05/02/1995",
										"addresses": [
											{
												"id": 2,
												"addr_line_one": "IGI",
												"addr_line_two": "India",
												"city": "New Delhi"
											}
										]
							}
							

for Update Customer:
				http://localhost:8080/api/v1/Employee/new
				
				request :
							{
										"id":2,
										"name":"Rajat",
										"date_of_birth":"05/12/1995",
										"addresses":{
											"addr_line_one":"IGI2",
											"addr_line_two":"India2",
											"city":"New Delhi2"
										}
							}
							
				response:
							{
										"id": 2,
										"name": "Rajat",
										"date_of_birth": "05/12/1995",
										"addresses": [
											{
												"id": 2,
												"addr_line_one": "IGI2",
												"addr_line_two": "India2",
												"city": "New Delhi2"
											}
										]
							}
											
							
							
Get employee by id:
					http://localhost:8080/api/v1/Employee/1/find
					
					response:
							{
								"id": 1,
								"name": "John Snow",
								"date_of_birth": "05/02/1995",
								"addresses": [
									{
										"id": 1,
										"addr_line_one": "NINDIAN",
										"addr_line_two": "Nindian2",
										"city": "Bangalore"
									}
								]
							}
							

Get ALl Employee:
					http://localhost:8080/api/v1/Employee/findAll
					
					response:
									[
					{
						"id": 2,
						"name": "Mohan ",
						"date_of_birth": "05/01/1985",
						"addresses": [
							{
								"id": 2,
								"addr_line_one": "Kormangala",
								"addr_line_two": "India",
								"city": "Bangalore"
							}
						]
					},
					{
						"id": 1,
						"name": "John Snow",
						"date_of_birth": "05/02/1995",
						"addresses": [
							{
								"id": 1,
								"addr_line_one": "NINDIAN",
								"addr_line_two": "Nindian2",
								"city": "Bangalore"
							}
						]
					}
				]
							
							
Delete Employee:
				http://localhost:8080/api/v1/Employee/1/delete
				
				response:
				
						Employee with id 1 Deleted Successfully
								
 