// map fixtures for this application

steal("jquery/dom/fixture", function() {
  // findAll
  $.fixture("GET /sample/service/quick_paths", function() {
    return;
  });
  
  // findOne
  $.fixture("GET /sample/service/quick_paths/{id}", function(orig) {
    return;
  });
  
  // create
  $.fixture("POST /sample/service/quick_paths", function(form) {
	return;
  });
  
  // update
  $.fixture("PUT /sample/service/quick_paths/{id}", function(form) {
    return;
  });
  
  // destroy
  $.fixture("DELETE /sample/service/quick_paths/{id}", function() {
    return;
  });
});