// map fixtures for this application

steal("jquery/dom/fixture", function() {
  // findAll
  $.fixture("GET /service/quick_paths", function() {
    return;
  });
  
  // findOne
  $.fixture("GET /service/quick_paths/{id}", function(orig) {
    return;
  });
  
  // create
  $.fixture("POST /service/quick_paths", function(form) {
	return;
  });
  
  // update
  $.fixture("PUT /service/quick_paths/{id}", function(form) {
    return;
  });
  
  // destroy
  $.fixture("DELETE /service/quick_paths/{id}", function() {
    return;
  });
});