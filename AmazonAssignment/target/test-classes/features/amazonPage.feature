Feature: To Land on amazon page
			To verify search Nikon product and sort result in Highest to Lowest order
				 To verify and select second product and click on details
				     To verify Nikon 3DX text from displayed details using verify and assert

Background: application open and title is verified 
    Given Open Amazon Site	
	When  Application is loaded then verify the title 

@amazonProduct
Scenario: Search Nikon product and sort it in Higest to Lowset order
	Given Search Nikon product
	Then  Sort it in Higest to Lowset order
	
	
@amazonProduct
Scenario: Select sceond product and find Nikon 3DX as text in product description
	Given Click on second product
	When  Check product details
	Then  Use assert and verify to find Nikon 3DX in product description