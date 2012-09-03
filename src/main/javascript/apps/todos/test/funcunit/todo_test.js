steal("funcunit", function() {
  module("todo test", {
    setup: function() {
      S.open("//apps/todos/todos.html");
    }

  });
  
  test('test the initial list size', function() {
    S("li").exists().wait(1000, function() {
      ok(S("li").length == 3, "initial list size is 3");
    });
  });
  /**/
  test('select first todo', function() {
    S(".todo:first").click();
    S("#editor").val("wake up", "First Todo selected correctly");
  });
  
  test('select second todo', function() {
    S(".todo")[1].click();
    S("#editor").val("take out trash", "Second Todo selected correctly");
  });
  
  test('select last todo', function() {
    S(".todo:last").click();
    S("#editor").val("do dishes", "Last Todo selected correctly");
  });
  
  test('update last todo', function() {
    S(".todo:last").click();
    var editedText = S("#editor").val() + " modified";
    
    S("#editor").type(editedText);
    S("#updateBtn").click().wait(100, function() {
      S("#editor").val(editedText, "Last item updated correctly");
    });
  });
  
  test('delete the last todo', function() {
    S(".todo:last a").click().wait(100, function() {
      ok(S("li").length == 2, "new list size is 2");
    });
  });
  
  test('create a todo', function() {
    S("#editor").type("go to work");
    S("#createBtn").click().wait(100, function() {
      ok(S("li").length == 4, "new list size is 4");
    });
  });/**/
})