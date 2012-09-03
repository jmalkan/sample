steal("funcunit", function(){
	module("quick_path test", { 
		setup: function(){
			S.open("//apps/quick_path/quick_path.html");
		}
	});
	
	test("Copy Test", function(){
		equals(S("h1").text(), "Welcome to JavaScriptMVC 3.2!","welcome text");
	});
})