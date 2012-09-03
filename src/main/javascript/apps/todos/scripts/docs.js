//js todo/scripts/doc.js

load('steal/rhino/rhino.js');
steal("documentjs").then(function(){
	DocumentJS('apps/todos/todos.html', {
		markdown : ['todos']
	});
});