steal(function($) {
  /**
   * @class Todo
   * @parent index
   * @inherits jQuery.Model
   * Wraps backend todo services.
   */
$.Model('Todo', 
  /* @Static */ {
    findAll: "/service/todos",
    findOne : "/service/todos/{id}",
    create : "/service/todos",
    update : "/service/todos/{id}",
    destroy : "/service/todos/{id}"
  },
  /* @Prototype */
  { });
});