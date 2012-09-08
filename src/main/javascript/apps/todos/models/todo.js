steal(function($) {
  /**
   * @class Todo
   * @parent index
   * @inherits jQuery.Model Wraps backend todo services.
   */
  $.Model('Todo',
  /* @Static */{
    findAll : "/sample/service/todos",
    findOne : "/sample/service/todos/{id}",
    create : "/sample/service/todos",
    update : "/sample/service/todos/{id}",
    destroy : "/sample/service/todos/{id}"
  },
  /* @Prototype */
  {});
});