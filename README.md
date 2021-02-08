# Noroff_task4


heroku app: https://dry-temple-65548.herokuapp.com/


postman:

{
	"info": {
		"_postman_id": "7e7ae83c-3fff-4688-8701-fd983587ee64",
		"name": "task4",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "getAllCustomers",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/main/Customer",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"main",
						"Customer"
					]
				},
				"description": "All customers"
			},
			"response": []
		},
		{
			"name": "addCustomer",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/main/Customer",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"main",
						"Customer"
					]
				}
			},
			"response": []
		},
		{
			"name": "updateCustomer",
			"request": {
				"method": "PUT",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/main/Customer",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"main",
						"Customer"
					]
				}
			},
			"response": []
		}
	]
}
