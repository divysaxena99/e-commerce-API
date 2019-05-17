# e-commerce-API
e-commerce-API using Java Spring-boot

APIs

Product:
path: 
1. Get all products: GET "localhost:8080/api/product"

2. Get product by id: GET "localhost:8080/api/product/{id}"

3. Create product: POST "localhost:8080/api/product"

                  RequestBody:
                  {
                  "name":"",
                  "price":"",
                  "stock":""
                  }

4. Update product: PUT "localhost:8080/api/product/{id}"

                  RequestBody:
                  {
                  "name":"",
                  "price":"",
                  "stock":""
                  }
                  
5. Delete product: DELETE "localhost:8080/api/product/{id}"



Order:
path:
1. Get all orders: GET "localhost:8080/api/order"

2. Create order: POST "localhost:8080/api/order"
                
                RequestBody:
                {
                "emailId":"",
                "productList": [
                    {
                      "productId":"",
                      "quantity":""
                    },
                    {
                      "productId":"",
                      "quantity":""
                    }
                  ]
                }
