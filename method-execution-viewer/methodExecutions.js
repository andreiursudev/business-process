var methodExecution1 = {"packageName":"ro.exceptionalbear.todoapp.todo","className":"TodoController","methodName":"createTodoPost","input":"{username=andrei, todo=Todo [id=null, username=andrei, description=first todo, targetDate=2021-01-20, done=true]}","output":"{\r\n  \"id\" : 1,\r\n  \"username\" : \"andrei\",\r\n  \"description\" : \"first todo\",\r\n  \"targetDate\" : [ 2021, 1, 20 ],\r\n  \"done\" : true\r\n}","children":[{"packageName":"ro.exceptionalbear.todoapp.todo","className":"TodoService","methodName":"save","input":"{todo=Todo [id=null, username=andrei, description=first todo, targetDate=2021-01-20, done=true]}","output":"{\r\n  \"id\" : 1,\r\n  \"username\" : \"andrei\",\r\n  \"description\" : \"first todo\",\r\n  \"targetDate\" : [ 2021, 1, 20 ],\r\n  \"done\" : true\r\n}","children":[{"packageName":"ro.exceptionalbear.todoapp.todo.repository","className":"TodoRepository","methodName":"save","input":"{arg0=Todo [id=null, username=andrei, description=first todo, targetDate=2021-01-20, done=true]}","output":"{\r\n  \"id\" : 1,\r\n  \"username\" : \"andrei\",\r\n  \"description\" : \"first todo\",\r\n  \"targetDate\" : [ 2021, 1, 20 ],\r\n  \"done\" : true\r\n}","children":[],"id":"ro.exceptionalbear.todoapp.todo.repositoryTodoRepositorysave"}],"id":"ro.exceptionalbear.todoapp.todoTodoServicesave"}],"id":"ro.exceptionalbear.todoapp.todoTodoControllercreateTodoPost"}
