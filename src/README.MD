# Reading from the Database
   1. Root of the page is in index.jsp
   2. Records are retrieved from the mysql database via the Servlet file thats attached to the jsp

# Create
1. Build the create form in ads/create.jsp
2. Form action attribute is equal to the route of the create servlet file i.e. "ads/create"
```html
        <form action="/ads/create" method="post">
```
3. Servlet file has tag with **urlPatterns = "/ads/create"**
```javaq
    @WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
```