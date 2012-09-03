// load('apps/quick_path/scripts/crawl.js')

load('steal/rhino/rhino.js')

steal('steal/html/crawl', function(){
  steal.html.crawl("apps/quick_path/quick_path.html","apps/quick_path/out")
});
