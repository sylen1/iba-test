# IBA - test

Solution for each level is in it's own commit, text is in ``tasks.pdf``.

## Level 1 - GitHub repo
```
:-)
```

## Level 2 - Hello IBA! (once)
```
localhost:8080
```

## Level 3, 4 - Hello IBA! X-times  
``X >= 0``, incorrect value sets X to 1
```
localhost:8080/?x={number}
```
## Level 5, 6 - Add and display student
```
http://localhost:8080/form
```
## Level 7, 8, 9  - Service CRUD and JSP views  
**All students**
```
http://localhost:8080/all
```
**Student detail**
```
http://localhost:8080/student/{id}
```
**Edit student**
```
http://localhost:8080/edit/{id}
```
**Remove student**
```
http://localhost:8080/remove?id={1}
```
**Add student**
```
http://localhost:8080/create
```
## Level 10 - Rest API  
**All students**
```
localhost:8080/api/all
```
**One student**
```
localhost:8080/api/findById?id={number}
```
**Add student**  
put JSON in POST request body
```
localhost:8080/api/add
```
**Add all students**  
put JSON array in POST request body
```
localhost:8080/api/addAll
```
**Remove by example**  
put JSON in POST request body
```
localhost:8080/api/removeByExample
```
**Remove by id**
```
localhost:8080/api/removeById?id={number}
```
**Remove all**  
put JSON array in POST request body
```
localhost:8080/api/removeAll
```
**Update student**  
put JSON in POST request body
```
localhost:8080/api/update
```
## Level 11 - Unit tests
```
StudentServiceTest.java
```
