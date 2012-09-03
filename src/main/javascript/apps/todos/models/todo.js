steal(function($) {
  /**
   * @class Todo
   * @parent index
   * @inherits jQuery.Model
   * Wraps backend todo services.
   */
$.Model('Todo', 
  /* @Static */ {
    findAll: "/todos",
    findOne : "/todos/{id}",
    create : "/todos",
    update : "/todos/{id}",
    destroy : "/todos/{id}"
  },
  /* @Prototype */
  { });
})