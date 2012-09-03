steal("funcunit/qunit", "apps/fixtures", "apps/models/quick_path.js", function(){
	module("Model: Apps.Models.QuickPath")
	
	test("findAll", function(){
		expect(4);
		stop();
		Apps.Models.QuickPath.findAll({}, function(quick_paths){
			ok(quick_paths)
	        ok(quick_paths.length)
	        ok(quick_paths[0].name)
	        ok(quick_paths[0].description)
			start();
		});
		
	})
	
	test("create", function(){
		expect(3)
		stop();
		new Apps.Models.QuickPath({name: "dry cleaning", description: "take to street corner"}).save(function(quick_path){
			ok(quick_path);
	        ok(quick_path.id);
	        equals(quick_path.name,"dry cleaning")
	        quick_path.destroy()
			start();
		})
	})
	test("update" , function(){
		expect(2);
		stop();
		new Apps.Models.QuickPath({name: "cook dinner", description: "chicken"}).
	            save(function(quick_path){
	            	equals(quick_path.description,"chicken");
	        		quick_path.update({description: "steak"},function(quick_path){
	        			equals(quick_path.description,"steak");
	        			quick_path.destroy();
						start();
	        		})
	            })
	
	});
	test("destroy", function(){
		expect(1);
		stop();
		new Apps.Models.QuickPath({name: "mow grass", description: "use riding mower"}).
	            destroy(function(quick_path){
	            	ok( true ,"Destroy called" )
					start();
	            })
	})
})