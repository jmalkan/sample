// map fixtures for this application
steal("jquery/dom/fixture").then(function($) {
  /*
    $.fixture.make("todo", 5, function(i, todo) {
    var descriptions = ["grill fish", "make ice", "cut onions"]
    return new Todo({
      name: "todo " + i,
      description: $.fixture.rand(descriptions , 1)[0]
    });
  })
  */
    var TODOS = [new Todo({id: 1, name: "wake up"}), new Todo({id: 2, name: "take out trash"}), new Todo({id: 3, name: "do dishes"})];
  var id = TODOS.length + 1;
  
  
  // findAll
  $.fixture("GET /todos", function() {
    return [TODOS]
  });
  
  // findOne
  $.fixture("GET /todos/{id}", function(orig) {
    return TODOS[(+orig.data.id)-1];
  });
  
  // create
  $.fixture("POST /todos", function(form) {
	var newTodo = new Todo({"id": id++, "name": form.data.name});
    TODOS.push(newTodo);
    return newTodo;
  });
  
  // update
  $.fixture("PUT /todos/{id}", function(form) {
	// issue with id being 1 higher then the one selected.
	var index = form.data.id - 1;
	var todo = TODOS[index];
	todo.name = form.data.name;
	TODOS[index] = todo;
	
    return todo;
  });
  
  // destroy
  $.fixture("DELETE /todos/{id}", function() {
    return {};
  });
})