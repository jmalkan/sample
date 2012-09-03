//js apps/quick_path/scripts/doc.js

load('steal/rhino/rhino.js');
steal("documentjs").then(function(){
	DocumentJS('apps/quick_path/quick_path.html', {
		markdown : ['quick_path']
	});
});