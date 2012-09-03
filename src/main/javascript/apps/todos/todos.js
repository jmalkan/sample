steal('jquery/class',
      'jquery/view/ejs',
      'jquery/controller',
      './todos.css',             // application CSS file
      './models/models.js',      // steals all your models
  function($) {
    $.Controller("Todos", {
      defaults : {template: 'todos.ejs'}
      }, {
      "init" : function(element, options) {
        this.reset(false, true);
        $("#todo", element).html(options.template, Todo.findAll())
      },
      "li click" : function(li) {
        var text = li.text().trim().split("X - ");
        this.reset(true, false);
        li.addClass("green");
        $("#editorId").text(text[1].trim());
        $("#editor").val(text[0].trim()).select();
      },
      "li .destroy click" : function(el, ev) {
        el.closest('.todo').model().destroy();
        ev.stopPropagation();
      },
      "#createBtn click" : function(el, ev) {
        var todo = new Todo({name: $("#editor").val()});
        todo.save();
      },
      "#updateBtn click" : function(el, ev) {
    	var id  = +$("#editorId").text();
    	Todo.findOne({id: id}, function(todo) {
          console.log(todo.name); // print out the todo name
          todo.attr("name", $("#editor").val());
          todo.save();
        });
      },
      "{Todo} created" : function(Todo, ev, newTodo) {
        $("#todo", this.element).append(this.options.template, [newTodo]);
        this.reset(false, true);
      },
      "{Todo} updated" : function(Todo, ev, updatedTodo) {
        updatedTodo.elements(this.element).replaceWith(this.options.template, [updatedTodo]);
        this.reset(false, true);
      },
      "{Todo} destroyed" : function(Todo, ev, destroyedTodo) {
        destroyedTodo.elements(this.element).remove();
        this.reset(false, true);
      },
      reset : function(createBtnDisabled, updateBtnDisabled) {
        $("#editor").val("");
        $("li").removeClass("green");
        $("#createBtn").attr("disabled", createBtnDisabled);
        $("#updateBtn").attr("disabled", updateBtnDisabled);
      }
    });
    
    $(function() {
      $("#todos").todos(); // create a todos widget with a list
    })
});