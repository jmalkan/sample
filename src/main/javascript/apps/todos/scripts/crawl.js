// load('todo/scripts/crawl.js')

load('steal/rhino/rhino.js')

steal('steal/html/crawl', function(){
  steal.html.crawl("apps/todos/todos.html","apps/todos/out")
});
