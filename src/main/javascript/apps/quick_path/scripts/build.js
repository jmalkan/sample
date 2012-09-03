//js apps/quick_path/scripts/build.js

load("steal/rhino/rhino.js");
steal('steal/build').then('steal/build/scripts','steal/build/styles',function(){
	steal.build('apps/quick_path/scripts/build.html',{to: 'apps/quick_path'});
});
