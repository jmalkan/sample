// map fixtures for this application

steal("jquery/dom/fixture", function() {
  // findAll
  $.fixture("GET /quick_paths", function() {
    return;
  });
  
  // findOne
  $.fixture("GET /quick_paths/{id}", function(orig) {
    return;
  });
  
  // create
  $.fixture("POST /todos", function(form) {
	return;
  });
  
  // update
  $.fixture("PUT /todos/{id}", function(form) {
    return;
  });
  
  // destroy
  $.fixture("DELETE /todos/{id}", function() {
    return;
  });
})