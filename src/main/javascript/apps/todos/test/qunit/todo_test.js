steal("funcunit/qunit", "apps/todos/fixtures", "apps/todos/models/models.js", function(){
	module("Model: Todo");
	
	test("findAll", function(){
		expect(4);
		stop();
		Todo.findAll({}, function(todos){
			ok(todos);
	        ok(todos.length);
	        ok(todos[0].name);
	        ok(todos[0].description);
			start();
		});
	});
	
	test("create", function(){
		expect(3);
		stop();
		new Todo({name: "dry cleaning", description: "take to street corner"}).save(function(todo){
			ok(todo);
	        ok(todo.id);
	        equals(todo.name,"dry cleaning");
	        todo.destroy();
			start();
		});
	});
	
	test("update" , function(){
		expect(2);
		stop();
		new Todo({name: "cook dinner", description: "chicken"}).save(function(todo){
	            	equals(todo.description,"chicken");
	        		todo.update({description: "steak"},function(todo){
	        			equals(todo.description,"steak");
	        			todo.destroy();
						start();
	        		});
	            });
	});
	
	test("destroy", function(){
		expect(1);
		stop();
		new Todo({name: "mow grass", description: "use riding mower"}).destroy(function(todo){
	            	ok(true ,"Destroy called");
					start();
	            });
	});
});