//js todo/scripts/build.js

load("steal/rhino/rhino.js");
steal('steal/build').then('steal/build/scripts','steal/build/styles',function(){
	steal.build('apps/todos/scripts/build.html',{to: 'apps/todos'});
});
