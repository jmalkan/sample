steal( 'jquery/controller',
	   'jquery/view/ejs',
	   'jquery/controller/view',
	   'apps/models' )
.then( './views/init.ejs', 
       './views/quick_path.ejs', 
       function($){

/**
 * @class Apps.QuickPath.List
 * @parent index
 * @inherits jQuery.Controller
 * Lists quick_paths and lets you destroy them.
 */
$.Controller('Apps.QuickPath.List',
/** @Static */
{
	defaults : {}
},
/** @Prototype */
{
	init : function(){
		this.element.html(this.view('init',Apps.Models.QuickPath.findAll()) )
	},
	'.destroy click': function( el ){
		if(confirm("Are you sure you want to destroy?")){
			el.closest('.quick_path').model().destroy();
		}
	},
	"{Apps.Models.QuickPath} destroyed" : function(QuickPath, ev, quick_path) {
		quick_path.elements(this.element).remove();
	},
	"{Apps.Models.QuickPath} created" : function(QuickPath, ev, quick_path){
		this.element.append(this.view('init', [quick_path]))
	},
	"{Apps.Models.QuickPath} updated" : function(QuickPath, ev, quick_path){
		quick_path.elements(this.element)
		      .html(this.view('quick_path', quick_path) );
	}
});

});